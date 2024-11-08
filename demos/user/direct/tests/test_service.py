from demos.user.direct.service.user_service import UserService
import pytest


def test_that_admin_user_has_admin_permission():
    service = UserService()
    assert service.check_permission("CEO", "admin")


def test_that_admin_user_does_not_have_other_permissions():
    service = UserService()
    assert not service.check_permission("CEO", "user")


def test_that_error_is_raised_if_user_does_not_exist():
    service = UserService()
    with pytest.raises(ValueError):
        service.check_permission("CTO", "admin")
