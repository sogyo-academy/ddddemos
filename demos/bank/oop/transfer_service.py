from demos.bank.oop.bank_account import BankAccount


class TransferService:
    def __init__(self, source_account: BankAccount, target_account: BankAccount):
        self.source_account = source_account
        self.target_account = target_account

    def transfer(self, amount: float) -> None:
        self.source_account.withdraw(amount)
        self.target_account.deposit(amount)
        # Transactionality is hard! What happens if these two lines are swapped?
