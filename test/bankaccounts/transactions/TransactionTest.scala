package bankaccounts.transactions

import currency.CurrencyAmount

import java.time.LocalDateTime
import java.util.{Currency, Locale, Random}

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

object TransactionTest {

  val RANDOM = new Random

  val DOLLARS: Currency = Currency.getInstance(Locale.US)

}

class TransactionTest {

  @Test def testToString(): Unit = {
    println("toString")
    val description = "Example Transaction"
    val amount = new CurrencyAmount(TransactionTest.RANDOM.nextInt(5000),
      TransactionTest.DOLLARS)
    val date = LocalDateTime.now.minusHours(12)
    val transaction = new Transaction(description, amount, date) {}
    val expected = s"$description of ${amount.toString} on ${date.toString}"
    val actual = transaction.toString
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testConstructorRejectsNullDescription(): Unit = {
    val amount = new CurrencyAmount(TransactionTest.RANDOM.nextInt(5000),
      TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[NullPointerException], () => {
      val badTransaction = new Transaction(null, amount, LocalDateTime.now) {}
      println("Should not have been able to create bad transaction "
        + badTransaction.toString + " with null description")
    })
    println("Trying to use null description correctly caused NullPointerException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsNullAmount(): Unit = {
    val exception = assertThrows(classOf[NullPointerException], () => {
      val badTransaction = new TransactionImpl(null, LocalDateTime.now())
      println("Should not have been able to create bad transaction "
        + badTransaction.toString + " with null amount")
    })
    println("Trying to use null amount correctly caused NullPointerException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsNullDate(): Unit = {
    val amount = new CurrencyAmount(TransactionTest.RANDOM.nextInt(5000),
      TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[NullPointerException], () => {
      val badTransaction = new TransactionImpl(amount, null)
      println("Should not have been able to create bad transaction "
        + badTransaction.toString + " with null date")
    })
    println("Trying to use null date correctly caused NullPointerException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

  private class TransactionImpl(amount: CurrencyAmount, dateTime: LocalDateTime)
    extends Transaction("Test implementation", amount, dateTime)

}
