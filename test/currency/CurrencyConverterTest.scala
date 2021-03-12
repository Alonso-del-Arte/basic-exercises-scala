package currency

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class CurrencyConverterTest {

  @Test def testNoConversionForSameCurrency(): Unit = {
    val cents = Random.nextInt(10000) + 1
    val expected = new CurrencyAmount(cents, CurrencyAmountTest.DOLLARS)
    val actual = CurrencyConverter.convert(expected, CurrencyAmountTest.DOLLARS)
    assertEquals(expected, actual)
  }

  @Test def testUSDollarsToEastCaribbeanDollars(): Unit = {
    val amount = new CurrencyAmount(100, CurrencyAmountTest.DOLLARS)
    val expected = new CurrencyAmount(270,
      CurrencyAmountTest.EAST_CARIBBEAN_DOLLARS)
    val actual = CurrencyConverter.convert(amount,
      CurrencyAmountTest.EAST_CARIBBEAN_DOLLARS)
    assertEquals(expected, actual)
  }

  @Test def testEastCaribbeanDollarsToUSDollars(): Unit = {
    val amount = new CurrencyAmount(270,
      CurrencyAmountTest.EAST_CARIBBEAN_DOLLARS)
    val expected = new CurrencyAmount(100, CurrencyAmountTest.DOLLARS)
    val actual = CurrencyConverter.convert(amount, CurrencyAmountTest.DOLLARS)
    assertEquals(expected, actual)
  }

}
