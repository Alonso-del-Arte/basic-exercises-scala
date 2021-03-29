package textops

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TextCalculatorTest {

  @Test def testChangeByteOrder(): Unit = {
    println("changeByteOrder")
    val expected = "\u5400\u6500\u7300\u7400"
    val actual = "Test".map(TextCalculator.changeByteOrder)
    assertEquals(expected, actual)
    println("\"" + actual + "\"")
  }

  @Test def testAnagram(): Unit = {
    println("anagram")
    val source = "snag a ram".replace(" ", "")
    val target = "anagrams"
    val msg = "\"" + source + "\" should be an anagram of \"" + target + "\""
    assert(TextCalculator.anagram(source, target), msg)
  }

  @Test def testNotAnagram(): Unit = {
    val source = "shear ram".replace(" ", "")
    val target = "anagrams"
    val msg = "\"" + source + "\" should not be an anagram of \"" + target + "\""
    assert(!TextCalculator.anagram(source, target), msg)
  }

  // TODO: Tests for anagram() case-insensitive

  @Test def testAnagrammable(): Unit = {
    println("anagrammable")
    val source = "snag a ram"
    val target = "anagrams"
    val msg = "\"" + target + "\" should be anagrammable from \"" + source + "\""
    assert(TextCalculator.anagrammable(source, target), msg)
  }

  @Test def testNotAnagrammable(): Unit = {
    val source = "Can't make that word from this source"
    val target = "anagrams"
    val msg = "\"" + target + "\" should NOT be anagrammable from \"" + source + "\""
    assert(!TextCalculator.anagrammable(source, target), msg)
  }

  @Test def testNotAnagrammableBecauseOfExcessiveTargetLength(): Unit = {
    val source = "Source too short"
    val target = "This target requires greater length source"
    val msg = "\"" + target + "\" should NOT be anagrammable from \"" + source + "\""
    assert(!TextCalculator.anagrammable(source, target), msg)
  }

  // TODO: Tests for anagrammable() case-insensitive

}
