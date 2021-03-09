package fractions

import calculators.IntegerCalculator

object Fraction {

  import scala.language.implicitConversions

  @inline implicit def IntToFraction(n: Int): Fraction = new Fraction(n)

}

class Fraction(numer: Long, denom: Long = 1L) extends Ordered[Fraction] {
  if ((denom & Long.MaxValue) == 0L) {
    val excMsg = "Denominator " + denom.toString + " is invalid or unavailable"
    throw new ArithmeticException(excMsg)
  }
  private val adjustment = IntegerCalculator.gcd(numer, denom) * denom.sign
  val numerator: Long = numer / adjustment
  val denominator: Long = denom / adjustment

  override def toString: String = {
    this.numerator.toString + (if (this.denominator == 1L) "" else ("/"
      + this.denominator.toString))
  }

  override def equals(obj: Any): Boolean = obj match {
    case other: Fraction => this.numerator == other.numerator &&
      this.denominator == other.denominator
    case _ => false
  }

  // STUB TO FAIL THE FIRST TEST
  override def hashCode(): Int = 0

  def +(addend: Fraction): Fraction = {
    val crossNumerA = this.numerator * addend.denominator
    val crossNumerB = addend.numerator * this.denominator
    val crossDenom = this.denominator * addend.denominator
    new Fraction(crossNumerA + crossNumerB, crossDenom)
  }

  def unary_-(): Fraction = new Fraction(-this.numerator, this.denominator)

  def -(subtrahend: Fraction): Fraction = this + (-subtrahend)

  def *(multiplicand: Fraction) =
    new Fraction(this.numerator * multiplicand.numerator,
      this.denominator * multiplicand.denominator)

  def reciprocal: Fraction = new Fraction(this.denominator, this.numerator)

  def /(divisor: Fraction): Fraction = this * divisor.reciprocal

  def numericApproximation: Double = this.numerator.toDouble / this.denominator

  override def compare(that: Fraction): Int = {
    val diff = this - that
    diff.numerator.sign.toInt
  }

}
