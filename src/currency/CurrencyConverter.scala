package currency

import java.util.Currency

object CurrencyConverter {

  def convert(amount: CurrencyAmount, currency: Currency): CurrencyAmount = {
    val diff = amount.currency.getNumericCode - currency.getNumericCode
    val cents = diff match {
      case -111 => Math.floor(2.7 * amount.amountInCents).toInt
      case 0 => amount.amountInCents
      case 111 => Math.floor(0.37373737 * amount.amountInCents).toInt
      case _ => -100
    }
    new CurrencyAmount(cents, currency)
  }

}
