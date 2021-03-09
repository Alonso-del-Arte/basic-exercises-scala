package bankaccounts.transactions

import currency.CurrencyAmount

import java.time.LocalDateTime

class Deposit(amount: CurrencyAmount, date: LocalDateTime,
              description: String = "Deposit")
  extends Transaction(description, amount, date) {
  if (amount.amountInCents < 1) {
    val excMsg = s"Amount ${amount.toString} is not positive"
    throw new IllegalArgumentException(excMsg)
  }

}
