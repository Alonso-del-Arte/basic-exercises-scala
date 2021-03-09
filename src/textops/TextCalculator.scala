package textops

object TextCalculator {

  def changeByteOrder(ch: Char): Char = ch match {
    case '\uFEFF' => ' '
    case _ =>  val urCode = ch.toInt
      val urHi = urCode >>> 8
      val urLo = urCode % 256
      (urLo * 256 + urHi).toChar
  }

  def anagram(source: String, target: String,
              caseSensitive: Boolean = false): Boolean = {
    val s = (if (caseSensitive) source else source.toUpperCase).toSeq.sorted.unwrap
    val t = (if (caseSensitive) target else target.toUpperCase).toSeq.sorted.unwrap
    s == t
  }

  def anagrammable(source: String, target: String,
                   caseSensitive: Boolean = false): Boolean = true

}
