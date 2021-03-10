package bankaccounts

import bankaccounts.transactions.{Deposit, Transaction}
import currency.CurrencyAmount
import entities.Entity

class SavingsAccount(primaryAccountHolder: Entity, initialDeposit: Deposit)
  extends Account(primaryAccountHolder, initialDeposit)  {
// TODO: Write test class
}
