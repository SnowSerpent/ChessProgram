package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class King extends Piece {

    public King(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.KING, alliance, board, manager);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        // TODO: Cant move into danger

        // Makes sure it's not moving onto one of it's own pieces
        if (board.getPiece(x, y) != null) {
            if (board.getPiece(x, y).getAlliance() == alliance) {
                return false;
            }
        }

        // Move 1 square away
        if (Math.abs(x - posX) <= 1 && Math.abs(y - posY) <= 1) {
            return true;
        }

        // If conditions are not met, it will return false
        return false;
    }
}