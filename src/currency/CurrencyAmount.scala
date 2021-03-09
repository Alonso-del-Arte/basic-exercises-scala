package currency

import java.util.Currency

class CurrencyAmount(val amountInCents: Long, val currency: Currency)
  extends Ordered[CurrencyAmount] {
  private val centPlaces = this.currency.getDefaultFractionDigits

  override def toString: String = this.currency.getSymbol + {
    var str = Math.abs(this.amountInCents).toString
    if (str.length < this.centPlaces + 1) {
      val zeroPad = "0" * (this.centPlaces - str.length + 1)
      str = zeroPad + str
    }
    if (this.amountInCents < 0) str = s"-$str"
    val (units, cents) = str.splitAt(str.length - this.centPlaces)
    units + '.' + cents
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[CurrencyAmount]

  override def equals(other: Any): Boolean = other match {
    case that: CurrencyAmount =>
      (that canEqual this) &&
        amountInCents == that.amountInCents &&
        currency == that.currency
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(amountInCents, currency)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  def +(addend: CurrencyAmount): CurrencyAmount = if (this.currency
         == addend.currency) {
    new CurrencyAmount(this.amountInCents + addend.amountInCents, this.currency)
  } else {
    val excMsg = "Currency conversion needed to add " + this.toString +
      " to " + addend.toString
    throw new CurrencyConversionNeededException(excMsg, this, addend)
  }

  def unary_- = new CurrencyAmount(-this.amountInCents, this.currency)

  def -(subtrahend: CurrencyAmount): CurrencyAmount = this + (-subtrahend)

  def *(multiplicand: Int): CurrencyAmount = new CurrencyAmount(0,
    this.currency)

  def /(divisor: Int): CurrencyAmount = new CurrencyAmount(0, this.currency)

  override def compare(that: CurrencyAmount): Int = {
    val diff = this - that
    diff.amountInCents.sign.toInt
  }

}
