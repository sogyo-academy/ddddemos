from abc import ABC, abstractmethod

from typing import Optional

from demos.user.injected.models.user import User


class UserRepository(ABC):

    @abstractmethod
    def add_user(self, user: User): ...

    @abstractmethod
    def get_user_by_name(self, user_name: str) -> Optional[User]: ...

    @abstractmethod
    def delete_user_by_name(self, user_name: str): ...
