package currency

import java.util.Currency

object CurrencyConverter {

  // STUB TO FAIL THE FIRST TEST
  def convert(amount: CurrencyAmount, currency: Currency): CurrencyAmount =
    new CurrencyAmount(-100, Currency.getInstance("XCD"))

}
