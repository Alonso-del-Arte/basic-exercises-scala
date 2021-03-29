package textops

import scala.collection.immutable.HashMap

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class CharacterCounterTest {

  @Test def testQuery(): Unit = {
    println("query")
    val text = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
    val counter = new CharacterCounter(text)
    assertEquals(25, counter.query(' '))
    for (ch <- 'A' to 'Z') assertEquals(1, counter.query(ch))
  }

  @Test def testQueryNotPresent(): Unit = {
    val text = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
    val counter = new CharacterCounter(text)
    for (ch <- 'a' to 'z') assertEquals(0, counter.query(ch))
  }

  @Test def testQueryCaseInsensitive(): Unit = {
    val text = "The quick brown fox jumps over the lazy dog"
    val counter = new CharacterCounter(text)
    for (ch <- 'A' to 'Z') {
      val msg = "The letter '" + ch + "' appears at least once in \"" + text +
        "\" when case is ignored"
      assert(counter.query(ch) > 0, msg)
    }
  }

  @Test def testResults(): Unit = {
    println("results")
    val text = "ABC"
    val counter = new CharacterCounter(text)
    val expected = HashMap('A' -> 1, 'B' -> 1, 'C' -> 1)
    val actual = counter.results
    assertEquals(expected, actual)
  }

}
