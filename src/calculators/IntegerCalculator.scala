package calculators

import scala.collection.mutable.ListBuffer

object IntegerCalculator {

  // STUB TO FAIL THE FIRST TEST
  def square(n: Int): Int = -1

  // STUB TO FAIL THE FIRST TEST
  def divisors(n: Int): List[Int] = List()

  def longDivReciprocal(n: Int, places: Int = 100): List[Int] = {
    val pow10 = java.lang.Math.pow(10,
      java.lang.Math.ceil(java.lang.Math.log10(java.lang.Math.abs(n)))).toInt
    val digits = new ListBuffer[Int]()
    var quotient = pow10
    var remainder = 0
    while (digits.size < places) {
      remainder = quotient % n
      quotient /= n
      digits += quotient
      quotient = remainder * 10
    }
    digits.toList
  }

  @scala.annotation.tailrec
  def gcd(a: Long, b: Long): Long = b match {
    case 0L => java.lang.Math.abs(a)
    case _ => gcd(b, a % b)
  }

  @scala.annotation.tailrec
  def isPrime(number: Int): Boolean = number match {
    case n if n < 0 => isPrime(-n)
    case 0 => false
    case 1 => false
    case n =>  !((2 until n - 1) exists (n % _ == 0))
  }

  @scala.annotation.tailrec
  def iterDigitProd(n: Int): Int = n.toString.length match {
    case 1 => n
    case _ => iterDigitProd {
      n.toString.toCharArray.map(_ - 48).scanRight(1)(_ * _).head
    }
  }

  def isPrimeDigit(n: Int): Boolean = List(2, 3, 5, 7).contains(n)

  def reverseDigits(n: Int): Int = Integer.parseInt(n.toString.reverse)

  def find153Sol(n: Int): List[Int] = {
    def recur153(curr: Int, history: List[Int]): List[Int] = {
      if (curr == n) {
        history.drop(1) :+ n
      } else if (curr > n) {
        List()
      } else {
        val add5Branch = recur153(curr + 5, history :+ curr)
        if (add5Branch.nonEmpty) {
          add5Branch
        } else recur153(curr * 3, history :+ curr)
      }
    }
    recur153(1, List(1))
  }

  def collatz(n: Int): Int = n % 2 match {
    case 0 => n / 2
    case _ => 3 * n + 1
  }

  def ternCollatz(n: Int): Int = n % 3 match {
    case 0 => n / 3
    case -2 | 1 => 2 * n + 1
    case _ => -2 * n + 1
  }

  def iterFn(fn: Int => Int, start: Int, stop: Int = 1): List[Int] = {
    var list = List(start)
    var curr = start
    while (curr != stop) {
      curr = fn(curr)
      list = list :+ curr
    }
    list
  }

  def fizzBuzz(n: Int): Any = (n % 3, n % 5) match {
    case (0, 0) => "FizzBuzz"
    case (0, _) => "Fizz"
    case (_, 0) => "Buzz"
    case _ => n
  }
}
