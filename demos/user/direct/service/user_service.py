from demos.user.direct.repository.user_repository import UserRepository


class UserService:
    def __init__(self):
        self.repository = UserRepository()

    def check_permission(self, user_name: str, required_permission: str):
        user = self.repository.get_user_by_name(user_name)
        if not user:
            raise ValueError(f"User with name {user_name} does not exist")
        return required_permission in user.permissions
