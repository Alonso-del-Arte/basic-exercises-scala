package textops

import scala.collection.immutable.HashMap

class CharacterCounter(val text: String) {
  private var charMap: HashMap[Char, Int] = new HashMap[Char, Int]
  for (ch <- text.toList) {
    if (this.charMap.contains(ch)) {
      val count = this.charMap(ch) + 1
      this.charMap += (ch -> count)
    } else {
      this.charMap += (ch -> 1)
    }
  }

  private def queryCaseSensitive(ch: Char): Int = {
    if (this.charMap.contains(ch)) this.charMap(ch) else 0
  }

  def query(ch: Char, caseSensitivity: Boolean = true): Int = {
    if (caseSensitivity || !ch.isLetter) queryCaseSensitive(ch) else {
      val lower = ch.toLower
      val upper = ch.toUpper
      queryCaseSensitive(lower) + queryCaseSensitive(upper)
    }
  }

  def results: HashMap[Char, Int] = this.charMap

}
