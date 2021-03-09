package fractions

import java.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class FractionTest {
  private val random: Random = new Random

  @Test def testToString(): Unit = {
    println("toString")
    val oneHalf = new Fraction(1, 2)
    val expected = "1/2"
    val actual = oneHalf.toString.replace(" ", "")
    assertEquals(expected, actual)
  }

  @Test def testToStringIntegerOmitsDenomOne(): Unit = {
    val number = new Fraction(1729)
    val expected = "1729"
    val actual = number.toString.replace(" ", "")
    assertEquals(expected, actual)
  }

  @Test def testReferentialEquality(): Unit = {
    val numer = random.nextInt
    val denom = 43 * numer + 1
    val fraction = new Fraction(numer, denom)
    assertEquals(fraction, fraction)
  }

  @Test def testNotEqualsNull(): Unit = {
    val numer = random.nextInt
    val denom = 58 * numer + 1
    val fraction = new Fraction(numer, denom)
    assertNotEquals(fraction, null)
  }

  @Test def testNotEqualsDiffClass(): Unit = {
    val numer = random.nextInt
    val integer = new Fraction(numer)
    assertNotEquals(integer, numer)
  }

  @Test def testNotEqualsDiffNumer(): Unit = {
    val numer = random.nextInt
    val denom = 29 * numer + 1
    val fractionA = new Fraction(numer, denom)
    val fractionB = new Fraction(numer + 1, denom)
    assertNotEquals(fractionA, fractionB)
  }

  @Test def testNotEqualsDiffDenom(): Unit = {
    val numer = random.nextInt
    val denom = 29 * numer + 1
    val fractionA = new Fraction(numer, denom)
    val fractionB = new Fraction(numer, denom * 2)
    assertNotEquals(fractionA, fractionB)
  }

  @Test def testEquals(): Unit = {
    println("equals")
    val someFraction = new Fraction(6, 8)
    val sameFraction = new Fraction(12, 16)
    assertEquals(someFraction, sameFraction)
  }

  // TODO: Write hash code test

  @Test def testCompare(): Unit = {
    println("compare")
    val negativeOneHalf = new Fraction(-1, 2)
    val zero = new Fraction(0)
    val eApprox = new Fraction(106, 39)
    val piApprox = new Fraction(22, 7)
    val ten = new Fraction(10)
    val unsorted = List(piApprox, zero, negativeOneHalf, ten, eApprox)
    val expected = List(negativeOneHalf, zero, eApprox, piApprox, ten)
    val actual = unsorted.sorted
    assertEquals(expected, actual)
  }

  @Test def testPlusSameDenom(): Unit = {
    val fractionA = new Fraction(7, 13)
    val fractionB = new Fraction(5, 13)
    val expected = new Fraction(12, 13)
    val actual = fractionA + fractionB
    assertEquals(expected, actual)
  }

  @Test def testPlus(): Unit = {
    println("+")
    val fractionA = new Fraction(7, 12)
    val fractionB = new Fraction(5, 16)
    val expected = new Fraction(43, 48)
    val actual = fractionA + fractionB
    assertEquals(expected, actual)
  }

  // TODO: Tests for /

  @Test def testNegate(): Unit = {
    println("negate")
    val oneHalf = new Fraction(1, 2)
    val expected = new Fraction(-1, 2)
    val actual = -oneHalf
    assertEquals(expected, actual)
  }

  @Test def testMinus(): Unit = {
    println("-")
    val minuend = new Fraction(5, 12)
    val subtrahend = new Fraction(7, 12)
    val expected = new Fraction(-1, 6)
    val actual = minuend - subtrahend
    assertEquals(expected, actual)
  }

  @Test def testMinusNotCommutative(): Unit = {
    val denom = random.nextInt(65536) + 1
    val numer = 109 * denom + 1
    val fractionA = new Fraction(numer, denom)
    val fractionB = new Fraction(numer + 1, denom * 3)
    val differenceA = fractionA - fractionB
    val differenceB = fractionB - fractionA
    assertNotEquals(differenceA, differenceB)
  }

  @Test def testTimes(): Unit = {
    println("*")
    val fractionA = new Fraction(3, 16)
    val fractionB = new Fraction(1, 5)
    val expected = new Fraction(3, 80)
    val actual = fractionA * fractionB
    assertEquals(expected, actual)
  }

  @Test def testTimesCommutative(): Unit = {
    val fractionA = new Fraction(random.nextInt, 56L)
    val fractionB = new Fraction(44, random.nextInt | 1L)
    val expected = fractionA * fractionB
    val actual = fractionB * fractionA
    assertEquals(expected, actual)
  }

  @Test def testReciprocal(): Unit = {
    println("reciprocal")
    val threeEighths = new Fraction(3, 8)
    val expected = new Fraction(8, 3)
    val actual = threeEighths.reciprocal
    assertEquals(expected, actual)
  }

  @Test def testNoReciprocalForZero(): Unit = {
    val zero = new Fraction(0)
    try {
      val badReciprocal = zero.reciprocal
      val msg = "Trying to take reciprocal of " + zero.toString +
        " should have caused an exception, not given result " +
        badReciprocal.toString
      fail(msg)
    } catch {
      case iae: IllegalArgumentException =>
        println("Trying to take reciprocal of " + zero.toString
          + " correctly caused IllegalArgumentException")
        println("\"" + iae.getMessage + "\"")
      case ae: ArithmeticException =>
        println("ArithmeticException is adequate for trying to take reciprocal of "
          + zero.toString)
        println("\"" + ae.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
        " is the wrong exception to throw for trying to take reciprocal of " +
        zero.toString
        fail(msg)
    }
  }

  @Test def testDivides(): Unit = {
    println("/")
    val dividend = new Fraction(7, 55)
    val divisor = new Fraction(1, 8)
    val expected = new Fraction(56, 55)
    val actual = dividend / divisor
    assertEquals(expected, actual)
  }

  @Test def testDivisionByZero(): Unit = {
    val dividend = new Fraction(random.nextLong, 84)
    val zero = new Fraction(0)
    try {
      val badDivision = dividend / zero
      val msg = "Trying to divide " + dividend.toString +
        " should have caused an exception, not given result " +
        badDivision.toString
      fail(msg)
    } catch {
      case iae: IllegalArgumentException =>
        println("Trying to divide " + dividend.toString
          + " by 0 correctly caused IllegalArgumentException")
        println("\"" + iae.getMessage + "\"")
      case ae: ArithmeticException =>
        println("ArithmeticException is adequate for trying to divide "
          + dividend.toString + " by 0")
        println("\"" + ae.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
        " is the wrong exception to throw for trying to divide " +
        dividend.toString + " by 0"
        fail(msg)
    }
  }

  @Test def testNumericApproximation(): Unit = {
    println("numericApproximation")
    val oneSeventh = new Fraction(1, 7)
    val expected = 0.14285714
    val actual = oneSeventh.numericApproximation
    val delta = 1E-8
    assertEquals(expected, actual, delta)
  }

  @Test def testNumericApproximationOfInteger(): Unit = {
    val integer = random.nextInt
    val fraction = new Fraction(integer)
    val expected = integer.toDouble
    val actual = fraction.numericApproximation
    val delta = 0.0001
    assertEquals(expected, actual, delta)
  }

  @Test def testImplicitConversion(): Unit = {
    val someFraction = new Fraction(-7, 12)
    val expected = new Fraction(5, 12)
    val actual = 1 + someFraction
    assertEquals(expected, actual)
  }

  @Test def testConstructorTurnsNegativeDenomPositive(): Unit = {
    val numer = random.nextInt(131072) + 1
    val denom = -127 * numer + 1
    val fraction = new Fraction(numer, denom)
    val msg = "Fraction " + fraction.toString +
      " should have positive denominator"
    val expected = -denom
    val actual = fraction.denominator
    assertEquals(expected, actual, msg)
  }

  @Test def testConstructorRejectsDenomZero(): Unit = {
    try {
      val badFraction = new Fraction(random.nextInt, 0)
      val msg = "Should not have been able to create " + badFraction.toString
      fail(msg)
    } catch {
      case iae: IllegalArgumentException =>
        println("IllegalArgumentException is preferable for denominator zero")
        println("\"" + iae.getMessage + "\"")
      case ae: ArithmeticException =>
        println("ArithmeticException is acceptable for denominator zero")
        println("\"" + ae.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
          " is the wrong exception to throw for denominator zero"
        fail(msg)
    }
  }

  @Test def testConstructorRejectsDenomLongMinValue(): Unit = {
    try {
      val badFraction = new Fraction(random.nextInt, Long.MinValue)
      val msg = "Should not have been able to create " + badFraction.toString +
        " with denominator " + Long.MinValue
      fail(msg)
    } catch {
      case ae: ArithmeticException =>
        println("ArithmeticException correctly occurred for denominator " +
          Long.MinValue)
        println("\"" + ae.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
        " is the wrong exception to throw for denominator " + Long.MinValue
        fail(msg)
    }
  }

}
