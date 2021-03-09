package textops

object PalindromeChecker {
  var caseSensitive: Boolean = true

  def isPalindromic(s: String, caseSensitivity: Boolean = true): Boolean = {
    val str = if (caseSensitivity) s else s.toLowerCase
    val reverse = str.reverse
    str == reverse
  }

  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      print("\"" + arg + "\" ")
      arg.toLowerCase match {
        case "-case" => this.caseSensitive = true
          println("Case sensitivity is on")
        case "-nocase" => this.caseSensitive = false
          println("Case sensitivity is off")
        case _ => if (isPalindromic(arg, this.caseSensitive)) {
          println("IS palindromic")
        } else {
          println("is NOT palindromic")
        }

      }
    }
  }

}
