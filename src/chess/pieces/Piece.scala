package chess.pieces

sealed abstract class Piece {

  val notation: String

}

class King extends Piece {

  override val notation: String = "K"

}

class Queen extends Piece {

  override val notation: String = "Q"

}

class Bishop extends Piece {

  override val notation: String = "B"

}

class Knight extends Piece {

  override val notation: String = "N"

}

class Rook extends Piece {

  override val notation: String = "R"

}

abstract class Pawn extends Piece
