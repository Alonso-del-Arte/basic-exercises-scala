package numerics

import scala.collection.immutable.HashSet
import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class RomanNumeralsNumberTest {

  @Test def testConstructorRejectsNegativeNumber(): Unit = {
    val negativeNumber = -Random.nextInt(1024) - 1
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badNumeral = new RomanNumeralsNumber(negativeNumber)
      println("Should not have been able to create " + badNumeral.toString
        + " with negative number " + negativeNumber)
    })
    val excMsg = exception.getMessage
    assert(excMsg != null, "Message should not be null")
    println("Trying to create Roman numeral with " + negativeNumber.toString
      + " correctly caused IllegalArgumentException")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsZero(): Unit = {
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badNumeral = new RomanNumeralsNumber(0)
      println("Should not have been able to create " + badNumeral.toString
        + " with0")
    })
    val excMsg = exception.getMessage
    assert(excMsg != null, "Message should not be null")
    println("0 for Roman numeral correctly caused IllegalArgumentException")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsNumberOver3999(): Unit = {
    val excessiveNumber = Random.nextInt(4000) + 4000
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badNumeral = new RomanNumeralsNumber(excessiveNumber)
      println("Should not have been able to create " + badNumeral.toString
        + " with excessive number " + excessiveNumber)
    })
    val excMsg = exception.getMessage
    assert(excMsg != null, "Message should not be null")
    println("Trying to create Roman numeral with " + excessiveNumber.toString
      + " correctly caused IllegalArgumentException")
    println("\"" + excMsg + "\"")
  }

  @Test def testToString(): Unit = {
    println("toString")
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(n)
      val expected = "I" * n
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringFour(): Unit = {
    val four = new RomanNumeralsNumber(4)
    assertEquals("IV", four.toString)
  }

  @Test def testToStringFive(): Unit = {
    val five = new RomanNumeralsNumber(5)
    assertEquals("V", five.toString)
  }

  @Test def testToStringSixSevenEight(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(5 + n)
      val expected = "V" + ("I" * n)
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringNine(): Unit = {
    val nine = new RomanNumeralsNumber(9)
    assertEquals("IX", nine.toString)
  }

  @Test def testToStringTenTwentyThirty(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(10 * n)
      val expected = "X" * n
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringForty(): Unit = {
    val forty = new RomanNumeralsNumber(40)
    assertEquals("XL", forty.toString)
  }

  @Test def testToStringFifty(): Unit = {
    val fifty = new RomanNumeralsNumber(50)
    assertEquals("L", fifty.toString)
  }

  @Test def testToStringSixtySeventyEighty(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(50 + 10 * n)
      val expected = "L" + ("X" * n)
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringNinety(): Unit = {
    val ninety = new RomanNumeralsNumber(90)
    assertEquals("XC", ninety.toString)
  }

  @Test def testToStringTensPlusSingles(): Unit = {
    for (tens <- 10 to 90 by 10) {
      val tensNumeral = new RomanNumeralsNumber(tens)
      for (ones <- 1 to 9) {
        val onesNumeral = new RomanNumeralsNumber(ones)
        val numeral = new RomanNumeralsNumber(tens + ones)
        val expected = tensNumeral.toString + onesNumeral.toString
        val actual = numeral.toString
        assertEquals(expected, actual)
      }
    }
  }

  @Test def testToStringOneHundredTwoHundredThreeHundred(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(100 * n)
      val expected = "C" * n
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringFourHundred(): Unit = {
    val fourHundred = new RomanNumeralsNumber(400)
    assertEquals("CD", fourHundred.toString)
  }

  @Test def testToStringFiveHundred(): Unit = {
    val fiveHundred = new RomanNumeralsNumber(500)
    assertEquals("D", fiveHundred.toString)
  }

  @Test def testToStringSixHundredSevenHundredEightHundred(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(500 + 100 * n)
      val expected = "D" + ("C" * n)
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringNineHundred(): Unit = {
    val nineHundred = new RomanNumeralsNumber(900)
    assertEquals("CM", nineHundred.toString)
  }

  @Test def testToStringHundredsPlusSingles(): Unit = {
    for (hundreds <- 100 to 900 by 100) {
      val hundredsNumeral = new RomanNumeralsNumber(hundreds)
      for (ones <- 1 to 99) {
        val onesNumeral = new RomanNumeralsNumber(ones)
        val numeral = new RomanNumeralsNumber(hundreds + ones)
        val expected = hundredsNumeral.toString + onesNumeral.toString
        val actual = numeral.toString
        assertEquals(expected, actual)
      }
    }
  }

  @Test def testToStringOneThousandTwoThousandThreeThousand(): Unit = {
    for (n <- 1 to 3) {
      val numeral = new RomanNumeralsNumber(1000 * n)
      val expected = "M" * n
      val actual = numeral.toString
      assertEquals(expected, actual)
    }
  }

  @Test def testToStringThousandsPlusSingles(): Unit = {
    for (thousands <- 1000 to 3000 by 1000) {
      val thousandsNumeral = new RomanNumeralsNumber(thousands)
      for (ones <- 1 to 999) {
        val onesNumeral = new RomanNumeralsNumber(ones)
        val numeral = new RomanNumeralsNumber(thousands + ones)
        val expected = thousandsNumeral.toString + onesNumeral.toString
        val actual = numeral.toString
        assertEquals(expected, actual)
      }
    }
  }

  @Test def testReferentialEquality(): Unit = {
    val numeral = new RomanNumeralsNumber(1728)
    assertEquals(numeral, numeral)
  }

  @Test def testNotEqualsNull(): Unit = {
    val numeral = new RomanNumeralsNumber(1729)
    assertNotEquals(numeral, null)
  }

  @Test def testNotEqualsDiffClass(): Unit = {
    val numeral = new RomanNumeralsNumber(1730)
    val number = new ComplexNumber(1730.0, 0.0)
    assertNotEquals(numeral, number)
  }

  @Test def testNotEqualsDiffNumeral(): Unit = {
    val someNumeral = new RomanNumeralsNumber(1731)
    val diffNumeral = new RomanNumeralsNumber(1732)
    assertNotEquals(someNumeral, diffNumeral)
  }

  @Test def testEquals(): Unit = {
    println("equals")
    val someNumeral = new RomanNumeralsNumber(1733)
    val sameNumeral = new RomanNumeralsNumber(1733)
    assertEquals(someNumeral, sameNumeral)
  }

  @Test def testHashCode(): Unit = {
    println("hashCode")
    var numerals: HashSet[RomanNumeralsNumber] = HashSet()
    var hashes: HashSet[Int] = HashSet()
    for (n <- 1 to 3999) {
      val numeral = new RomanNumeralsNumber(n)
      numerals = numerals + numeral
      hashes = hashes + numeral.hashCode()
    }
    val msg = "Set of numerals should be the same size as set of hash codes"
    assertEquals(numerals.size, hashes.size, msg)
  }

  @Test def testApply(): Unit = {
    println("apply")
    val n = Random.nextInt(3999) + 1
    val expected = new RomanNumeralsNumber(n)
    val actual = RomanNumeralsNumber(n)
    assertEquals(expected, actual)
  }

  @Test def testPlus(): Unit = {
    println("+")
    val a = Random.nextInt(2000) + 1
    val b = Random.nextInt(1999) + 1
    val addendA = new RomanNumeralsNumber(a)
    val addendB = new RomanNumeralsNumber(b)
    val expected = new RomanNumeralsNumber(a + b)
    val actual = addendA + addendB
    assertEquals(expected, actual)
  }

  @Test def testMinus(): Unit = {
    println("-")
    val a = Random.nextInt(3999) + 2
    val b = Random.nextInt(a - 1) + 1
    val minuend = new RomanNumeralsNumber(a)
    val subtrahend = new RomanNumeralsNumber(b)
    val expected = new RomanNumeralsNumber(a - b)
    val actual = minuend - subtrahend
    assertEquals(expected, actual)
  }

  @Test def testTimes(): Unit = {
    println("*")
    val a = Random.nextInt(63) + 1
    val b = Random.nextInt(63) + 1
    val multiplicandA = new RomanNumeralsNumber(a)
    val multiplicandB = new RomanNumeralsNumber(b)
    val expected = new RomanNumeralsNumber(a * b)
    val actual = multiplicandA * multiplicandB
    assertEquals(expected, actual)
  }

  // TODO: Write remainder (operator%) test

  @Test def testDivides(): Unit = {
    println("/")
    val a = Random.nextInt(62) + 1
    val b = a * a + a
    val dividend = new RomanNumeralsNumber(b)
    val divisor = new RomanNumeralsNumber(a + 1)
    val expected = new RomanNumeralsNumber(a)
    val actual = dividend / divisor
    assertEquals(expected, actual)
  }

  // TODO: Write test for a / b with gcd(a, b) = 1

  @Test def testCompare(): Unit = {
    println("compare")
    val a = Random.nextInt(800) + 1
    val b = a + Random.nextInt(800) + 1
    val c = b + Random.nextInt(800) + 1
    val d = c + Random.nextInt(800) + 1
    val e = d + Random.nextInt(799) + 1
    val sorted = List(a, b, c, d, e)
    val unsorted = List(c, d, a, e, b)
    val toBeSorted = unsorted.map(new RomanNumeralsNumber(_))
    val expected = sorted.map(new RomanNumeralsNumber(_))
    val actual = toBeSorted.sorted
    assertEquals(expected, actual)
  }

}
