from typing import Optional

import pytest

from demos.user.injected.models.user import User
from demos.user.injected.repository.user_repository import UserRepository


class TestUserRepository(UserRepository):
    def __init__(self, users: list[User]):
        self.users = users

    def add_user(self, user: User):
        self.users.append(user)

    def get_user_by_name(self, user_name: str) -> Optional[User]:
        return next((user for user in self.users if user.user_name == user_name), None)

    def delete_user_by_name(self, user_name: str):
        self.users = [user for user in self.users if user.user_name != user_name]


@pytest.fixture()
def repository():
    return TestUserRepository([User("CEO", ["admin"])])
