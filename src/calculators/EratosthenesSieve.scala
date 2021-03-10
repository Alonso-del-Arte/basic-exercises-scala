package calculators

class EratosthenesSieve(val threshold: Int,
                        val criterion: Int => Boolean = IntegerCalculator.isPrime,
                        val resume: Int => Int = IntegerCalculator.square) {

  // STUB TO FAIL THE FIRST TEST
  def results: List[Int] = List()

}
