package entities

class Person(val firstName: String) extends Entity {

  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        firstName == that.firstName
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(firstName)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
  
}
