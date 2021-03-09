package bankaccounts

import bankaccounts.transactions.{Deposit, Transaction}
import currency.CurrencyAmount
import entities.Entity

abstract class Account(val primaryAccountHolder: Entity,
                       val initialDeposit: Deposit) {
  private var history: List[Transaction] = List(initialDeposit)
  private var balance: CurrencyAmount = initialDeposit.amount
  private var secondaryAccountHolder: Entity = _

  def setSecondaryAccountHolder(entity: Entity): Unit = {
    this.secondaryAccountHolder = entity
  }

  def getSecondaryAccountHolder: Option[Entity] = {
    Option(this.secondaryAccountHolder)
  }

  def getBalance: CurrencyAmount = this.balance

  def processTransaction(transaction: Transaction): Unit = {
    this.history ::= transaction
    this.balance += transaction.amount
  }

}
