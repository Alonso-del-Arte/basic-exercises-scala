package basicexercises

class ToyExample(initialCounter: Int) {
  private[this] var counter = initialCounter
  private[basicexercises] val someField = ~initialCounter

  private def getCounter: Int = counter

  def attemptAccess(someObject: SomeClass): Unit = {
//    println(someObject.getLabel) // ERROR!!!
  }

}
