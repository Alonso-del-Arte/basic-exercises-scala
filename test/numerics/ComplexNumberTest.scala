package numerics

import postal.ZIPCode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class ComplexNumberTest {

  @Test def testToString(): Unit = {
    println("toString")
    val omega = new ComplexNumber(-0.5, Math.sqrt(3))
    val expected = "-0.5+" + Math.sqrt(3).toString + "i"
    val actual = omega.toString.replace(" ", "")
    assertEquals(expected, actual)
  }

  @Test def testToStringNegativeImaginaryPart(): Unit = {
    val omega = new ComplexNumber(0.5, -Math.sqrt(3))
    val expected = "0.5-" + Math.sqrt(3).toString + "i"
    val actual = omega.toString.replace(" ", "")
    assertEquals(expected, actual)
  }

  @Test def testReferentialEquality(): Unit = {
    val someNumber = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    assertEquals(someNumber, someNumber)
  }

  @Test def testNotEqualsNull(): Unit = {
    val someNumber = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    assertNotEquals(someNumber, null)
  }

  @Test def testEquals(): Unit = {
    println("equals")
    val someNumber = new ComplexNumber(0.5, 14.134725141734695)
    val sameNumber = new ComplexNumber(0.5, 14.134725141734695)
    assertEquals(someNumber, sameNumber)
  }

  @Test def testNotEqualsDiffClass(): Unit = {
    val someNumber = new ComplexNumber(90210.0, 4817.0)
    val zipCode = new ZIPCode(90210, 4817)
    assertNotEquals(someNumber, zipCode)
  }

  @Test def testNotEqualsDiffRealPart(): Unit = {
    val re = Math.random
    val someNumber = new ComplexNumber(re, 0.5)
    val diffNumber = new ComplexNumber(-re, 0.5)
    assertNotEquals(someNumber, diffNumber)
  }

  @Test def testNotEqualsDiffImagPart(): Unit = {
    val im = Math.random
    val someNumber = new ComplexNumber(0.5, im)
    val diffNumber = new ComplexNumber(0.5, -im)
    assertNotEquals(someNumber, diffNumber)
  }

  // TODO: Write hash code tests

  @Test def testConjugate(): Unit = {
    println("conjugate")
    val omega = new ComplexNumber(-0.5, Math.sqrt(3)/2)
    val expected = new ComplexNumber(-0.5, -Math.sqrt(3)/2)
    val actual = omega.conjugate
    assertEquals(expected, actual)
  }

  @Test def testConjugatePurelyRealIsTheSame(): Unit = {
    val expected = new ComplexNumber(Math.random * 100)
    val actual = expected.conjugate
    assertEquals(expected, actual)
  }

  @Test def testPlus(): Unit = {
    println("+")
    val addendA = new ComplexNumber(0.5, 0.0)
    val addendB = new ComplexNumber(0.0, 14.134725141734695)
    val expected = new ComplexNumber(0.5, 14.134725141734695)
    val actual = addendA + addendB
    assertEquals(expected, actual)
  }

  @Test def testPlusCommutative(): Unit = {
    val addendA = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    val addendB = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    val expected = addendA + addendB
    val actual = addendB + addendA
    assertEquals(expected, actual)
  }

  @Test def testNegate(): Unit = {
    println("unary_-")
    val omega = new ComplexNumber(-0.5, Math.sqrt(3))
    val expected = new ComplexNumber(0.5, -Math.sqrt(3))
    val actual = -omega
    assertEquals(expected, actual)
  }

  @Test def testNegateTwiceIsPositive(): Unit = {
    val expected = new ComplexNumber(Math.random, Math.random)
    val actual = -(-expected)
    assertEquals(expected, actual)
  }

  @Test def testMinus(): Unit = {
    println("-")
    val minuend = new ComplexNumber(-7.5, 3.25)
    val subtrahend = new ComplexNumber(1.0, 2.025)
    val expected = new ComplexNumber(-8.5, 1.225)
    val actual = minuend - subtrahend
    assertEquals(expected, actual)
  }

  @Test def testMinusSameNumber(): Unit = {
    val someNumber = new ComplexNumber(Math.random * 4, Math.random * 7)
    val expected = new ComplexNumber(0.0)
    val actual = someNumber - someNumber
    assertEquals(expected, actual)
  }

  @Test def testTimes(): Unit = {
    println("times")
    val imaginaryUnit = new ComplexNumber(0.0, 1.0)
    val expected = new ComplexNumber(-1.0, 0.0)
    val actual = imaginaryUnit * imaginaryUnit
    assertEquals(expected, actual)
  }

  @Test def testTimesCommutative(): Unit = {
    val multiplicandA = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    val multiplicandB = new ComplexNumber(Math.random - 0.5, Math.random - 0.5)
    val expected = multiplicandA * multiplicandB
    val actual = multiplicandB * multiplicandA
    assertEquals(expected, actual)
  }

  @Test def testDivisionByZeroCausesException(): Unit = {
    val someNumber = new ComplexNumber(Math.random * 58, -Math.random * 73)
    val zero = new ComplexNumber(-0.0)
    try {
      val badNumber = someNumber / zero
      val msg = "Trying to divide " + someNumber.toString + " by " +
        zero.toString + " should have caused an exception, not given result " +
        badNumber.toString
      fail(msg)
    } catch {
      case iae: IllegalArgumentException => println("Trying to divide " +
        someNumber.toString + " by " + zero.toString +
        " correctly caused IllegalArgumentException")
        println("\"" + iae.getMessage + "\"")
      case ae: ArithmeticException =>
        println("ArithmeticException is adequate for trying to divide " +
          someNumber.toString + " by " + zero.toString)
        println("\"" + ae.getMessage + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception to throw for trying to divide " +
        someNumber.toString + " by " + zero.toString
        fail(msg)
    }
  }

  @Test def testDivides(): Unit = {
    println("/")
    val dividend = new ComplexNumber(53.0)
    val divisor = new ComplexNumber(2.0, 7.0)
    val expected = new ComplexNumber(2.0, -7.0)
    val actual = dividend / divisor
    assertEquals(expected, actual)
  }

  @Test def testDivideRecoversOtherMultiplicand(): Unit = {
    val randomRe = Math.floor((Math.random - 0.5) * 512) + 0.5
    val randomIm = Math.floor((Math.random - 0.5) * 512) + 0.25
    val dividend = new ComplexNumber(randomRe, randomIm)
    val expected = new ComplexNumber(-randomRe / 4, randomIm / 8)
    val divisor = dividend / expected
    val actual = dividend / divisor
    val delta = 0.00001
    assertEquals(expected.re, actual.re, delta)
    assertEquals(expected.im, actual.im, delta)
  }

  @Test def testAbs(): Unit = {
    println("abs")
    val fiveFactor = new ComplexNumber(2.0, -1.0)
    val expected = Math.sqrt(5)
    val actual = fiveFactor.abs
    val delta = 0.0000001
    assertEquals(expected, actual, delta)
  }

  @Test def testAbsPurelyReal(): Unit = {
    val negativeTwo = new ComplexNumber(-2.0, 0.0)
    val expected = 2.0
    val actual = negativeTwo.abs
    val delta = 0.0000001
    assertEquals(expected, actual, delta)
  }

  @Test def testAbsPurelyImaginary(): Unit = {
    val imagUnit = new ComplexNumber(0.0, 1.0)
    val expected = 1.0
    val actual = imagUnit.abs
    val delta = 0.0000001
    assertEquals(expected, actual, delta)
  }

  @Test def testImplicitConversion(): Unit = {
    val imaginaryUnit = new ComplexNumber(0.0, 1.0)
    val expected = new ComplexNumber(0.0, Math.PI)
    val actual = Math.PI * imaginaryUnit
    assertEquals(expected, actual)
  }

}
