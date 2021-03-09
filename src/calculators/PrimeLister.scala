package calculators

import scala.collection.mutable.ArrayBuffer

object PrimeLister {

  def listPrimes(quantity: Int): List[Int] = {
    var primes: ArrayBuffer[Int] = new ArrayBuffer(quantity)
    primes += 2
    var currNum = 3
    var currPi = 1
    while (currPi < quantity) {
      val squareRoot = java.lang.Math.sqrt(currNum)
      var coPrimeFlag = false
      var currIndex = 0
      var currPrime = 1
      do {
        currPrime = primes(currIndex)
        coPrimeFlag = !(currNum % currPrime == 0)
        currIndex += 1
      } while (coPrimeFlag && currPrime <= squareRoot)
      if (coPrimeFlag) {
        primes += currNum
        currPi += 1
      }
      currNum += 2
    }
    primes.toList
  }

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis
    val primes = listPrimes(1000000)
    val finishTime = System.currentTimeMillis
    val elapsedTime = finishTime - startTime
    println("Operation took " + elapsedTime + " milliseconds")
    val powersOf10 = List.fill(6)(10).scanLeft(1)(_ * _).drop(1)
    for (index <- powersOf10) {
      println(index.toString + "th prime is " + primes(index - 1))
    }
  }

}
