package playingcards

abstract sealed class Suit(val ch: Char) {

  class Spades extends Suit('\u2660')

  class Diamonds extends Suit('\u2666')

  class Clubs extends Suit('\u2663')

  class Hearts extends Suit('\u2665')

}
