package currency

import java.util.Currency

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class CurrencyConversionNeededExceptionTest {

  @Test def testConvertAToBCurrency(): Unit = {
    println("convertAToBCurrency")
    val centsA = Random.nextInt(50000) + 1
    val centsB = Random.nextInt(50000) + 1
    val amountA = new CurrencyAmount(centsA, CurrencyAmountTest.DOLLARS)
    val amountB = new CurrencyAmount(centsB, CurrencyAmountTest.EUROS)
    val exception =
      new CurrencyConversionNeededException("For testing purposes only",
        amountA, amountB)
    val expected = CurrencyConverter.convert(amountA, amountB.currency)
    val actual = exception.convertAToBCurrency
    assertEquals(expected, actual)
  }

  @Test def testConvertBToACurrency(): Unit = {
    println("convertBToACurrency")
    val centsA = Random.nextInt(50000) + 1
    val centsB = Random.nextInt(50000) + 1
    val amountA = new CurrencyAmount(centsA, CurrencyAmountTest.DOLLARS)
    val amountB = new CurrencyAmount(centsB, CurrencyAmountTest.EUROS)
    val exception =
      new CurrencyConversionNeededException("For testing purposes only",
        amountA, amountB)
    val expected = CurrencyConverter.convert(amountB, amountA.currency)
    val actual = exception.convertBToACurrency
    assertEquals(expected, actual)
  }

}
