package bankaccounts.transactions

import currency.CurrencyAmount
import java.time.LocalDateTime

abstract class Transaction(val description: String, val amount: CurrencyAmount,
                           val date: LocalDateTime) {
  if (description == null)
    throw new NullPointerException("Description must not be null")
  if (amount == null) throw new NullPointerException("Amount must not be null")
  if (date == null) throw new NullPointerException("Date must not be null")

  override def toString: String =
    s"${this.description} of ${this.amount.toString} on ${this.date.toString}"

}
