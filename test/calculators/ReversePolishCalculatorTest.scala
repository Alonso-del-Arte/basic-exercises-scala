package calculators

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class ReversePolishCalculatorTest {

  val TEST_DELTA: Double = 0.00000001

  @Test def testHistory(): Unit = {
    println("history")
    val revPolCalc = new ReversePolishCalculator
    var expected = ""
    var actual = revPolCalc.history
    assertEquals(expected, actual)
    val expression = "1 1 +"
    revPolCalc.calculate(expression)
    expected = expression + "\n= 2\n"
    actual = revPolCalc.history
    assertEquals(expected, actual)
  }

  @Test def testCalculate(): Unit = {
    println("calculate")
    val revPolCalc = new ReversePolishCalculator
    val expression = "1 1 +"
    val expected = 2.0
    val actual = revPolCalc.calculate(expression)
    assertEquals(expected, actual, TEST_DELTA)
  }

  // TODO: Write more tests

}
