from typing import Self


class BankAccount:

    def __init__(self, account_id: str):
        self.account_id = account_id
        self._balance: float = 0

    def get_balance(self) -> float:
        return self._balance

    def deposit(self, amount: float) -> None:
        self._balance += amount

    def withdraw(self, amount: float) -> None:
        if amount > self._balance:
            raise ValueError("Negative balance not allowed")
        self._balance -= amount

    # Define transfer on the entity?

    def transfer_from(self, source_account: Self, amount: float) -> None:
        source_account.withdraw(amount)
        self._balance += amount

    def transfer_to(self, target_account: Self, amount: float) -> None:
        self._balance -= amount  # Oops
        target_account.deposit(amount)
