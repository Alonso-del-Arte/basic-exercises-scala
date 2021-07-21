package currency

class CurrencyConversionNeededException(msg: String,
                                        val amountA: CurrencyAmount,
                                        val amountB: CurrencyAmount)
  extends RuntimeException(msg) {

  def convertAToBCurrency: CurrencyAmount =
    CurrencyConverter.convert(this.amountA, this.amountB.currency)

  def convertBToACurrency: CurrencyAmount =
    CurrencyConverter.convert(this.amountB, this.amountA.currency)

}
