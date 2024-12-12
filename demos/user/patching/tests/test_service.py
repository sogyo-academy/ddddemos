from unittest import mock
from unittest.mock import patch

from demos.user.patching.models.user import User
from demos.user.patching.repository.user_repository import StoredUser, UserRepository
import pytest

from demos.user.patching.service.user_service import UserService


def fake_db_response(self, user_name: str) -> StoredUser:
    return StoredUser(
        Id='some_id',
        user_name='CEO',
        permissions=['admin']
    )


def fake_repository_response(self, user_name: str) -> User:
    return User(
        user_name='CEO',
        permissions=['admin']
    )


def test_that_admin_user_has_admin_permission():
    # Introducing a hard coupling onto a function that is intended private and where the coupling is invisible
    # from the production code's perspective by patching the lowest convenient function.
    with patch.object(UserRepository, "_load_user_by_name", fake_db_response):
        service = UserService()
        assert service.check_permission("CEO", "admin")


def test_that_admin_user_does_not_have_other_permissions():
    # Introducing a hard coupling onto the public interface of the repository class, which is marginally better, but
    # the dependency is still a fragile one, and invisible from the dependency's perspective. Because we use a string
    # to reference a function, the IDE cannot assist in refactoring of said function -- this test wil break.
    with patch.object(UserRepository, "get_user_by_name", fake_repository_response):
        service = UserService()
        assert not service.check_permission("CEO", "user")


@mock.patch(f"{UserService.__module__}.{UserRepository.__name__}")
def test_that_error_is_raised_if_user_does_not_exist(mock_repository):
    # Using mocks can allow tests of invocation rather than value operation. The coupling to the dependency is
    # now resolved through module and name dunder methods, which is better than using strings, but still invisible
    # from the dependency side.
    mock_repository.return_value.get_user_by_name.return_value = None
    service = UserService()
    with pytest.raises(ValueError):
        service.check_permission("CTO", "admin")
