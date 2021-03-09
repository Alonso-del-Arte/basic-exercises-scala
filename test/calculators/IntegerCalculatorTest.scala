package calculators

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class IntegerCalculatorTest {

  @Test def testLongDivReciprocalOneHalf(): Unit = {
    println("longDivReciprocal")
    val expected = List(5, 0, 0, 0, 0)
    val actual = IntegerCalculator.longDivReciprocal(2, 5)
    assertEquals(expected, actual)
  }

  @Test def testLongDivReciprocalOneSeventh(): Unit = {
    val expected = List(1, 4, 2, 8, 5, 7)
    val actual = IntegerCalculator.longDivReciprocal(7, 6)
    assertEquals(expected, actual)
  }

  @Test def testGCDSameNumber(): Unit = {
    println("gcd")
    val expected = 10
    val actual = IntegerCalculator.gcd(expected, expected)
    assertEquals(expected, actual)
  }

  @Test def testGCDANegative(): Unit = {
    val expected = 12
    val actual = IntegerCalculator.gcd(-expected, expected)
    assertEquals(expected, actual)
  }

  @Test def testGCDEvenAndDoublyEven(): Unit = {
    val expected = 2
    val actual = IntegerCalculator.gcd(12, 14)
    assertEquals(expected, actual)
  }

  @Test def testGCDBothNegative(): Unit = {
    val expected = 3
    val actual = IntegerCalculator.gcd(-42, -15)
    assertEquals(expected, actual)
  }

  /**
   * Another test of the gcd function of object IntegerCalculator. The sum of
   * any fourteen consecutive Fibonacci numbers is always divisible by 29.
   * Therefore, the sum of the Fibonacci numbers from Fibonacci(1) to
   * Fibonacci(14) and the sum of the Fibonacci numbers from Fibonacci(2) to
   * Fibonacci(15) should have 29 as their greatest common divisor, and
   * likewise for the sum of Fibonacci(3) to Fibonacci(16), etc.
   */
  @Test def testGCDFibonacciNumbers(): Unit = {
    lazy val fibo: LazyList[Long] = 0L #:: 1L #:: fibo.zip(fibo.tail).map{
      n => n._1 + n._2
    }
    val fiboList = fibo.take(40).toList
    val subLists = fiboList.sliding(14, 1).toList
    val sums = subLists.map(_.sum)
    val expected = List(29L)
    val actual = sums.scanLeft(29L)(IntegerCalculator.gcd).distinct
    assertEquals(expected, actual)
  }

  @Test def testIsPrime(): Unit = {
    val expected = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    val actual = (0 to 99).filter(IntegerCalculator.isPrime)
    assertEquals(expected, actual)
  }

  @Test def testIterDigitProd(): Unit = {
    val expected = 2
    val actual = IntegerCalculator.iterDigitProd(1729)
    assertEquals(expected, actual)
  }

  @Test def testIsPrimeDigit(): Unit = {
    assert(IntegerCalculator.isPrimeDigit(5), "5 should be considered a prime digit")
  }

  @Test def testIsNotPrimeDigit(): Unit = {
    assert(IntegerCalculator.isPrimeDigit(9), "9 should not be considered a prime digit")
  }

  @Test def testMultDigRootOEISSeq(): Unit = {
    val expected = List(2, 3, 5, 7, 12, 13, 15, 17, 21, 26, 31, 34, 35, 37, 43,
      51, 53, 57, 62, 71, 73, 75)
    val actual = (1 to 100).filter(n => IntegerCalculator.isPrimeDigit(IntegerCalculator.iterDigitProd(n)))
    assertEquals(expected, actual)
  }

  @Test def testReverseDigits(): Unit = {
    val expected = List(99, 1, 101, 201, 301, 401, 501, 601, 701, 801, 901, 11, 111, 211)
    val actual = (99 to 112).map(IntegerCalculator.reverseDigits)
    assertEquals(expected, actual)
  }

  @Test def testFindReversiblePrimes(): Unit = {
    val expected = List(2, 3, 5, 7, 11, 13, 14, 16, 17, 20, 30, 31, 32, 34, 35, 37, 38, 50, 70, 71, 73, 74, 76, 79, 91, 92, 95, 97, 98)
    val actual = (1 to 100).filter(n => IntegerCalculator.isPrime(IntegerCalculator.reverseDigits(n)))
    assertEquals(expected, actual)
  }

  @Test def testFind153SolFor3(): Unit = {
    val expected = List(1, 3)
    val actual = IntegerCalculator.find153Sol(3)
    assertEquals(expected, actual)
  }

  @Test def testFind153SolForUnreachable(): Unit = {
    val expected = List()
    val actual = IntegerCalculator.find153Sol(15)
    assertEquals(expected, actual)
  }

  @Test def testFind153SolFor8(): Unit = {
    val expected = List(1, 3, 8)
    val actual = IntegerCalculator.find153Sol(8)
    assertEquals(expected, actual)
  }

  @Test def testCollatz(): Unit = {
    val expected = List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
    val actual = IntegerCalculator.iterFn(IntegerCalculator.collatz, 13)
    assertEquals(expected, actual)
  }

  @Test def testTernCollatz(): Unit = {
    val expected = List(-38, -75, -25, 51, 17, -33, -11, -21, -7, 15, 5, -9, -3, -1, 3, 1)
    val actual = IntegerCalculator.iterFn(IntegerCalculator.ternCollatz, -38)
    assertEquals(expected, actual)
  }

  @Test def testFizzBuzz(): Unit = {
    val expected = List("Buzz", 11, "Fizz", 13, 14, "FizzBuzz", 16, 17, "Fizz", 19)
    val actual = (10 to 19).map(IntegerCalculator.fizzBuzz).toList
    assertEquals(expected, actual)
  }

  @Test def testNegativeFizzBuzz(): Unit = {
    val expected = List(-19, "Fizz", -17, -16, "FizzBuzz", -14, -13, "Fizz", -11, "Buzz")
    val actual = (-19 to -10).map(IntegerCalculator.fizzBuzz).toList
    assertEquals(expected, actual)
  }

  @Test def test18IsFizz(): Unit = {
    val expected = "Fizz"
    val actual = IntegerCalculator.fizzBuzz(18)
    assertEquals(expected, actual)
  }

}
