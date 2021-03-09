package bankaccounts.transactions

import currency.CurrencyAmount

import java.time.LocalDateTime

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class DepositTest {

  @Test def testToString(): Unit = {
    println("toString")
    val amount = new CurrencyAmount(TransactionTest.RANDOM.nextInt(5000) + 1,
      TransactionTest.DOLLARS)
    val date = LocalDateTime.now.minusHours(13)
    val deposit = new Deposit(amount, date)
    val expected = s"Deposit of ${amount.toString} on ${date.toString}"
    val actual = deposit.toString
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testToStringCustomLabel(): Unit = {
    val label = "Custom Type Deposit"
    val amount = new CurrencyAmount(TransactionTest.RANDOM.nextInt(5000) + 1,
      TransactionTest.DOLLARS)
    val date = LocalDateTime.now.minusHours(13)
    val deposit = new Deposit(amount, date, label)
    val expected = s"$label of ${amount.toString} on ${date.toString}"
    val actual = deposit.toString
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testConstructorRejectsZeroDollars(): Unit = {
    val zeroDollars = new CurrencyAmount(0, TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badDeposit = new Deposit(zeroDollars, LocalDateTime.now)
      println("Should not have been able to create " + badDeposit.toString)
    })
    println("Trying to use " + zeroDollars.toString
      + " for deposit amount correctly caused IllegalArgumentException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testConstructorRejectsNegativeAmount(): Unit = {
    val cents = TransactionTest.RANDOM.nextInt(50000) + 1
    val negativeAmount = new CurrencyAmount(-cents, TransactionTest.DOLLARS)
    val exception = assertThrows(classOf[IllegalArgumentException], () => {
      val badDeposit = new Deposit(negativeAmount, LocalDateTime.now)
      println("Should not have been able to create " + badDeposit.toString)
    })
    println("Trying to use " + negativeAmount.toString
      + " for deposit amount correctly caused IllegalArgumentException")
    val excMsg = exception.getMessage
    assert(excMsg != null, "Exception message should not be null")
    println("\"" + excMsg + "\"")
  }

}
