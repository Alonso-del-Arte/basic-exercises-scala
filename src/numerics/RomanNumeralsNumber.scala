package numerics

object RomanNumeralsNumber {

  private[numerics] def parse(digit: Int, power: Int): String = digit * power match {
    case 0 => ""
    case 1 => "I"
    case 2 => "II"
    case 3 => "III"
    case 4 => "IV"
    case 5 => "V"
    case 9 => "IX"
    case 10 => "X"
    case 20 => "XX"
    case 30 => "XXX"
    case 40 => "XL"
    case 50 => "L"
    case 90 => "XC"
    case 100 => "C"
    case 200 => "CC"
    case 300 => "CCC"
    case 400 => "CD"
    case 500 => "D"
    case 900 => "CM"
    case 1000 => "M"
    case 2000 => "MM"
    case 3000 => "MMM"
    case _ => "Unknown digit power combination"
  }

  def apply(number: Int): RomanNumeralsNumber = new RomanNumeralsNumber(number)

}

class RomanNumeralsNumber(number: Int) extends Ordered[RomanNumeralsNumber] {
  if (number < 1 || number > 3999) {
    val excMsg = "The number " + number.toString +
      " is outside the range 1 to 3999"
    throw new IllegalArgumentException(excMsg)
  }
  val n: Short = number.toShort

  override def toString: String = {
    var curr = this.n.toInt
    var power = 1
    var s = ""
    while (curr > 0) {
      val digit = curr % 10
      if (digit > 4 && digit < 9) {
        s = RomanNumeralsNumber.parse(5, power) +
          RomanNumeralsNumber.parse(digit - 5, power) + s
      } else s = RomanNumeralsNumber.parse(digit, power) + s
      curr /= 10
      power *= 10
    }
    s
  }

  override def equals(obj: Any): Boolean = obj match {
    case other: RomanNumeralsNumber => this.n == other.n
    case _ => false
  }

  override def hashCode(): Int = this.n

  // STUB TO FAIL THE FIRST TEST
  def +(addend: RomanNumeralsNumber): RomanNumeralsNumber =
    new RomanNumeralsNumber(1)

  // STUB TO FAIL THE FIRST TEST
  def -(subtrahend: RomanNumeralsNumber) : RomanNumeralsNumber =
    new RomanNumeralsNumber(3999)

  // STUB TO FAIL THE FIRST TEST
  def *(multiplicand: RomanNumeralsNumber): RomanNumeralsNumber =
    new RomanNumeralsNumber(1)

  // STUB TO FAIL THE FIRST TEST
  def %(modulo: RomanNumeralsNumber): RomanNumeralsNumber =
    new RomanNumeralsNumber(1)

  // STUB TO FAIL THE FIRST TEST
  def /(divisor: RomanNumeralsNumber): RomanNumeralsNumber =
    new RomanNumeralsNumber(3999)

  // STUB TO FAIL THE FIRST TEST

  // STUB TO FAIL THE FIRST TEST

  // STUB TO FAIL THE FIRST TEST

  // STUB TO FAIL THE FIRST TEST
  override def compare(that: RomanNumeralsNumber): Int = 0

}
