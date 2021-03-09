package calculators

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PrimeListerTest {

  @Test def testListPrimes(): Unit = {
    println("listPrimes")
    val expected = List(2, 3, 5, 7)
    val actual = PrimeLister.listPrimes(4)
    assertEquals(expected, actual)
  }

  @Test def testList25Primes(): Unit = {
    val expected = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
      53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    val actual = PrimeLister.listPrimes(25)
    assertEquals(expected, actual)
  }

}
