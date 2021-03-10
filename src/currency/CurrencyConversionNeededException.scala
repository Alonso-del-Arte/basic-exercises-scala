package currency

class CurrencyConversionNeededException(msg: String,
                                        val amountA: CurrencyAmount,
                                        val amountB: CurrencyAmount)
  extends RuntimeException(msg) {

  // STUB TO FAIL THE FIRST TEST
  def convertAToBCurrency: CurrencyAmount = this.amountA

  // STUB TO FAIL THE FIRST TEST
  def convertBToACurrency: CurrencyAmount = this.amountB

}
