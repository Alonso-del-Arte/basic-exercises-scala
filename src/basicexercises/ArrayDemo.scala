package basicexercises

object ArrayDemo {

  def main(args: Array[String]): Unit = {
    val numbers = Array(43, -7, 8, 21, 58)
    for (i <- 0 to 4) println(numbers(i))
  }

}
