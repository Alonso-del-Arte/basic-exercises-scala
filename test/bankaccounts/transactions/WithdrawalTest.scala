package bankaccounts.transactions

import currency.CurrencyAmount

import java.time.LocalDateTime

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class WithdrawalTest {

  @Test def testToString(): Unit = {
    println("toString")
    val amount = new CurrencyAmount(-TransactionTest.RANDOM.nextInt(5000) - 1,
      TransactionTest.DOLLARS)
    val date = LocalDateTime.now.minusHours(14)
    val withdrawal = new Withdrawal(amount, date)
    val expected = s"Withdrawal of ${amount.toString} on ${date.toString}"
    val actual = withdrawal.toString
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testToStringCustomLabel(): Unit = {
    val label = "Custom Type Withdrawal"
    val amount = new CurrencyAmount(-TransactionTest.RANDOM.nextInt(5000) - 1,
      TransactionTest.DOLLARS)
    val date = LocalDateTime.now.minusHours(13)
    val withdrawal = new Withdrawal(amount, date, label)
    val expected = s"$label of ${amount.toString} on ${date.toString}"
    val actual = withdrawal.toString
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testConstructorRejectsZeroDollars(): Unit = {
    val zeroDollars = new CurrencyAmount(0, TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badWithdrawal = new Withdrawal(zeroDollars, LocalDateTime.now)
      println("Should not have been able to create " + badWithdrawal.toString)
    })
    println("Trying to use " + zeroDollars.toString
      + " for withdrawal amount correctly caused IllegalArgumentException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsPositiveAmount(): Unit = {
    val cents = TransactionTest.RANDOM.nextInt(50000) + 1
    val positiveAmount = new CurrencyAmount(cents, TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badWithdrawal = new Withdrawal(positiveAmount, LocalDateTime.now)
      println("Should not have been able to create " + badWithdrawal.toString)
    })
    println("Trying to use " + positiveAmount.toString
      + " for withdrawal amount correctly caused IllegalArgumentException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

}
