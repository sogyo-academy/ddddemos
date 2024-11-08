import pytest

from demos.user.direct.models.user import User
from demos.user.direct.repository.user_repository import UserRepository


@pytest.fixture(scope="session", autouse=True)
def repository_setup():
    repository = UserRepository()
    repository.add_user(User("CEO", ["admin"]))

    yield

    repository.delete_user_by_name("CEO")
