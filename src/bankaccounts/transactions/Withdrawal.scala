package bankaccounts.transactions

import currency.CurrencyAmount

import java.time.LocalDateTime

class Withdrawal(amount: CurrencyAmount, date: LocalDateTime,
                 description: String = "Withdrawal")
  extends Transaction(description, amount, date) {
  if (amount.amountInCents > -1) {
    val excMsg = s"Amount ${amount.toString} is not negative"
    throw new IllegalArgumentException(excMsg)
  }

}
