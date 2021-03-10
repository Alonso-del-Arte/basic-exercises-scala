package numerics

object ComplexNumber {

  import scala.language.implicitConversions

  implicit def doubleToComplexNumber(x: Double): ComplexNumber =
    new ComplexNumber(x)

}

class ComplexNumber(val re: Double, val im: Double = 0.0) {
  if (!re.isFinite || !im.isFinite) {
    val excMsg = "Both real and imaginary should be finite (re = " +
      re.toString + ", im = " + im.toString + ")"
    throw new ArithmeticException(excMsg)
  }

  def conjugate: ComplexNumber = new ComplexNumber(this.re, -this.im)

  def +(addend: ComplexNumber): ComplexNumber =
    new ComplexNumber(this.re + addend.re, this.im + addend.im)

  def unary_-(): ComplexNumber = new ComplexNumber(-this.re, -this.im)

  def -(subtrahend: ComplexNumber): ComplexNumber = this + (-subtrahend)

  def *(multiplicand: ComplexNumber): ComplexNumber =
    new ComplexNumber(this.re * multiplicand.re - this.im * multiplicand.im,
      this.re * multiplicand.im + this.im * multiplicand.re)

  def /(divisor: ComplexNumber): ComplexNumber = {
    if (divisor.abs == 0.0) {
      val excMsg = "Can't divide " + this.toString + " by 0"
      throw new IllegalArgumentException(excMsg)
    }
    val prelim = this * divisor.conjugate
    val divNorm = divisor.re * divisor.re + divisor.im * divisor.im
    new ComplexNumber(prelim.re / divNorm, prelim.im / divNorm)
  }

  def abs: Double = Math.sqrt(this.re * this.re + this.im * this.im)

  override def toString: String = (this.re.toString + " + "
    + this.im.toString + "i").replace(" + -", " - ")

  override def equals(other: Any): Boolean = other match {
    case that: ComplexNumber => this.re == that.re && this.im == that.im
    case _ => false
  }

  override def hashCode: Int = 0//{
//    val state = Seq(re, im)
//    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
//  }

}