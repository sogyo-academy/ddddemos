from typing import Tuple

from demos.fp.bank.bank_account import BankAccount

type SourceAccount = BankAccount
type TargetAccount = BankAccount


def transfer(
    source_account: SourceAccount,
    target_account: TargetAccount,
    amount: float
) -> Tuple[SourceAccount, TargetAccount]:
    return source_account.withdraw(amount), target_account.deposit(amount)
