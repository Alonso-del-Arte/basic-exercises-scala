package playingcards

abstract sealed class Rank(symbol: String) {

  class Ace extends Rank("A")

  class Two extends Rank("2")

  class Three extends Rank("3")

  class Four extends Rank("4")

  class Five extends Rank("5")

  class Six extends Rank("6")

  class Seven extends Rank("7")

  class Eight extends Rank("8")

  class Nine extends Rank("9")

  class Ten extends Rank("10")

  class Jack extends Rank("J")

  class Queen extends Rank("Q")

  class King extends Rank("K")

}
