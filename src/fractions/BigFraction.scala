package fractions

object BigFraction {

  import scala.language.implicitConversions

  // STUB TO FAIL THE FIRST TEST
  def apply(fraction: Fraction): BigFraction = new BigFraction(-1: BigInt, 2: BigInt)

  // STUB TO FAIL THE FIRST TEST
  @inline implicit def BigIntToBigFraction(n: BigInt): BigFraction =
    new BigFraction(n, -2: BigInt)

}

class BigFraction(numer: BigInt, denom: BigInt) {
  // TODO: Put into lowest terms
  val numerator = numer
  val denominator = denom

}
