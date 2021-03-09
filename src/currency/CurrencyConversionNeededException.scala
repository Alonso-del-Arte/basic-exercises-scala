package currency

class CurrencyConversionNeededException(msg: String, amountA: CurrencyAmount,
                                        amountB: CurrencyAmount)
  extends RuntimeException(msg) {

}
