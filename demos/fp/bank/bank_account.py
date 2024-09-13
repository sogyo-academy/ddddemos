from dataclasses import dataclass, replace
from typing import Self


@dataclass(frozen=True)
class BankAccount:
    account_id: str
    balance: float = 0

    def deposit(self, amount: float) -> Self:
        return replace(self, balance=self.balance + amount)

    def withdraw(self, amount: float) -> Self:
        if amount > self.balance:
            raise ValueError("Negative balance not allowed")
        return replace(self, balance=self.balance - amount)
