package currency

import java.util.{Currency, Locale}

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

object CurrencyAmountTest {

  val RANDOM: Random = new Random

  val DINARS: Currency = Currency.getInstance(Locale.forLanguageTag("ar-LY"))
  val DOLLARS: Currency = Currency.getInstance(Locale.US)
  val EUROS: Currency = Currency.getInstance("EUR")
  val YEN: Currency = Currency.getInstance(Locale.JAPAN)

}

class CurrencyAmountTest {

  @Test def testToString(): Unit = {
    println("toString")
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "499.89"
    val amount = new CurrencyAmount(49989, CurrencyAmountTest.DOLLARS)
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringOtherAmount(): Unit = {
    val amount = new CurrencyAmount(104250, CurrencyAmountTest.DOLLARS)
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "1042.50"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringCentAmount(): Unit = {
    val amount = new CurrencyAmount(5, CurrencyAmountTest.DOLLARS)
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "0.05"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringOtherCentAmount(): Unit = {
    val amount = new CurrencyAmount(42, CurrencyAmountTest.DOLLARS)
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "0.42"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringNegativeCentAmount(): Unit = {
    val amount = new CurrencyAmount(-8, CurrencyAmountTest.DOLLARS)
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "-0.08"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringOtherNegativeCentAmount(): Unit = {
    val amount = new CurrencyAmount(-82, CurrencyAmountTest.DOLLARS)
    val expected = CurrencyAmountTest.DOLLARS.getSymbol + "-0.82"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringEuroAmount(): Unit = {
    val amount = new CurrencyAmount(7320, CurrencyAmountTest.EUROS)
    val expected = CurrencyAmountTest.EUROS.getSymbol + "73.20"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringDinarAmount(): Unit = {
    val amount = new CurrencyAmount(29505, CurrencyAmountTest.DINARS)
    val expected = CurrencyAmountTest.DINARS.getSymbol + "29.505"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringDirhamAmount(): Unit = {
    val arJordan = Locale.forLanguageTag("ar-JO")
    val jordanianDinars = Currency.getInstance(arJordan)
    val amount = new CurrencyAmount(709, jordanianDinars)
    val expected = jordanianDinars.getSymbol + "0.709"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testToStringYenAmount(): Unit = {
    val amount = new CurrencyAmount(20167, CurrencyAmountTest.YEN)
    val expected = CurrencyAmountTest.YEN.getSymbol + "20167"
    val actual = amount.toString
    assertEquals(expected, actual)
  }

  @Test def testPlus(): Unit = {
    println("+")
    val addendA = new CurrencyAmount(1225, CurrencyAmountTest.DOLLARS)
    val addendB = new CurrencyAmount(1275, CurrencyAmountTest.DOLLARS)
    val expected = new CurrencyAmount(2500, CurrencyAmountTest.DOLLARS)
    val actual = addendA + addendB
    assertEquals(expected, actual)
  }

  @Test def testPlusRandomAmounts(): Unit = {
    val centsA = CurrencyAmountTest.RANDOM.nextInt(100000)
    val centsB = CurrencyAmountTest.RANDOM.nextInt(100000)
    val addendA = new CurrencyAmount(centsA, CurrencyAmountTest.EUROS)
    val addendB = new CurrencyAmount(centsB, CurrencyAmountTest.EUROS)
    val expected = new CurrencyAmount(centsA + centsB, CurrencyAmountTest.EUROS)
    val actual = addendA + addendB
    println(addendA.toString + " + " + addendB.toString + " is said to be "
      + actual.toString)
    assertEquals(expected, actual)
  }

  @Test def testPlusDiffCurrency(): Unit = {
    val addendA = new CurrencyAmount(1225, CurrencyAmountTest.DOLLARS)
    val addendB = new CurrencyAmount(1275, CurrencyAmountTest.YEN)
    try {
      val result = addendA + addendB
      val msg = "Trying to add " + addendA.toString + " to " + addendB.toString +
        " should have caused an exception, not given result " + result.toString
      fail(msg)
    } catch {
      case curConvNeedExc: CurrencyConversionNeededException =>
        println("Trying to add " + addendA.toString + " to " + addendB.toString +
          " correctly caused CurrencyConversionNeededException")
        println("\"" + curConvNeedExc.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
        " is the wrong exception to throw for trying to add " + addendA.toString +
        " to " + addendB.toString
        fail(msg)
    }
  }

  @Test def testNegate(): Unit = {
    println("unary_-")
    val amount = new CurrencyAmount(39989, CurrencyAmountTest.DOLLARS)
    val expected = new CurrencyAmount(-39989, CurrencyAmountTest.DOLLARS)
    val actual = -amount
    assertEquals(expected, actual)
  }

  @Test def testMinus(): Unit = {
    println("-")
    val minuend = new CurrencyAmount(2500, CurrencyAmountTest.DOLLARS)
    val subtrahend = new CurrencyAmount(1225, CurrencyAmountTest.DOLLARS)
    val expected = new CurrencyAmount(1275, CurrencyAmountTest.DOLLARS)
    val actual = minuend - subtrahend
    assertEquals(expected, actual)
  }

  @Test def testMinusRandomAmounts(): Unit = {
    val centsA = CurrencyAmountTest.RANDOM.nextInt(125000)
    val centsB = CurrencyAmountTest.RANDOM.nextInt(150000)
    val minuend = new CurrencyAmount(centsA, CurrencyAmountTest.DINARS)
    val subtrahend = new CurrencyAmount(centsB, CurrencyAmountTest.DINARS)
    val expected = new CurrencyAmount(centsA - centsB,
      CurrencyAmountTest.DINARS)
    val actual = minuend - subtrahend
    println(minuend.toString + " - " + subtrahend.toString + " is said to be "
      + actual.toString)
    assertEquals(expected, actual)
  }

  @Test def testMinusDiffCurrency(): Unit = {
    val minuend = new CurrencyAmount(2500, CurrencyAmountTest.DOLLARS)
    val subtrahend = new CurrencyAmount(1275, CurrencyAmountTest.YEN)
    try {
      val result = minuend - subtrahend
      val failMsg = "Trying to subtract " + subtrahend.toString + " from " + minuend.toString + " should have caused an exception, not given result " + result.toString
      fail(failMsg)
    } catch {
      case curConvNeedExc: CurrencyConversionNeededException => println("Trying to subtract " + subtrahend.toString + " from " + minuend.toString + " correctly caused CurrencyConversionNeededException")
        println("\"" + curConvNeedExc.getMessage + "\"")
      case e: Exception => val failMsg = e.getClass.getName + " is the wrong exception to throw for trying to subtract " + subtrahend.toString + " from " + minuend.toString
        fail(failMsg)
    }
  }

  @Test def testCompareThruCollectionSort(): Unit = {
    val amountA = new CurrencyAmount(1275, CurrencyAmountTest.DOLLARS)
    val amountB = new CurrencyAmount(1225, CurrencyAmountTest.DOLLARS)
    val amountC = new CurrencyAmount(2500, CurrencyAmountTest.DOLLARS)
    val hundredBucks = new CurrencyAmount(10000, CurrencyAmountTest.DOLLARS)
    val negTwenty = new CurrencyAmount(-2000, CurrencyAmountTest.DOLLARS)
    val unsorted = List(amountA, negTwenty, amountB, hundredBucks, amountC)
    val expected = List(negTwenty, amountB, amountA, amountC, hundredBucks)
    val actual = unsorted.sorted
    assertEquals(expected, actual)
  }

  @Test def testConstructorRejectsNullCurrency(): Unit = {
    try {
      val badAmount = new CurrencyAmount(0, null)
      val msg = "Should not have been able to create amount with " +
        badAmount.amountInCents + " cents and null currency"
      fail(msg)
    } catch {
      case npe: NullPointerException =>
        println("Trying to use null amount correctly caused exception")
        println("\"" + npe.getMessage + "\"")
      case e: Exception => val msg = e.getClass.getName +
        " is the wrong exception to throw for null currency"
        fail(msg)
    }
  }

}
