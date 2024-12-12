import os

from ravendb import DocumentStore
from typing import Optional

from demos.user.injected.models.user import User
from demos.user.injected.repository.user_repository import UserRepository


class StoredUser(User):
    def __init__(self, Id: Optional[str], user_name: str, permissions: list[str]):
        super().__init__(user_name, permissions)
        self.Id = Id


class RavenUserRepository(UserRepository):
    def __init__(self):
        url = os.getenv("RAVEN_URL", "http://localhost:8080")
        self.store = DocumentStore([url], "User")
        self.store.initialize()

    def add_user(self, user: User):
        stored_user = StoredUser(None, user.user_name, user.permissions)
        with self.store.open_session() as session:
            session.store(stored_user)
            session.save_changes()

    def _load_user_by_name(self, user_name: str) -> Optional[StoredUser]:
        with self.store.open_session() as session:
            users = list(
                session.query(object_type=StoredUser)
                .wait_for_non_stale_results()
                .where_equals("user_name", user_name)
            )
            return users[0] if len(users) > 0 else None

    def get_user_by_name(self, user_name: str) -> Optional[User]:
        stored_user = self._load_user_by_name(user_name)
        return (
            User(stored_user.user_name, stored_user.permissions)
            if stored_user
            else None
        )

    def delete_user_by_name(self, user_name: str):
        stored_user = self._load_user_by_name(user_name)
        if not stored_user:
            return
        with self.store.open_session() as session:
            session.delete(stored_user.Id)
            session.save_changes()
