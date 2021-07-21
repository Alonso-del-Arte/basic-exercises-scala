package calculators

import scala.collection.mutable
import scala.collection.mutable.Stack

class ReversePolishCalculator {
  private val stack: mutable.Stack[Double] = mutable.Stack()

  // STUB TO FAIL FIRST TEST
  def history: String = "1 1 +\n= 2\n"

  // STUB TO FAIL FIRST TEST
  def calculate(expression: String): Double = 2.0

}
