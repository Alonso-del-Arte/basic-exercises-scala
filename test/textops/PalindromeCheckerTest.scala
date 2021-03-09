package textops

import org.junit.jupiter.api.Test

class PalindromeCheckerTest {

  @Test def testIsPalindromic(): Unit = {
    println("isPalindromic")
    val word = "kayak"
    val msg = "The word \"" + word + "\" should be found to be palindromic"
    assert(PalindromeChecker.isPalindromic(word), msg)
  }

  @Test def testIsNotPalindromic(): Unit = {
    val word = "kayaks"
    val msg = "The word \"" + word + "\" should NOT be found to be palindromic"
    assert(!PalindromeChecker.isPalindromic(word), msg)
  }

  @Test def testCaseSensitivityCanBeSwitchedOff(): Unit = {
    val word = "Level"
    val msg1 = "The word \"" + word +
      "\" should NOT be found to be palindromic with case sensitivity on"
    assert(!PalindromeChecker.isPalindromic(word), msg1)
    val msg2 = "The word \"" + word +
      "\" should be found to be palindromic with case sensitivity off"
    assert(PalindromeChecker.isPalindromic(word, caseSensitivity = false), msg2)
  }

}
