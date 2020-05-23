package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Knight extends Piece {

    public Knight(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.KNIGHT, alliance, board, manager);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        
        // Makes sure it's not moving onto one of it's own pieces
        if (board.getPiece(x, y) != null) {
            if (board.getPiece(x, y).getAlliance() == alliance) {
                return false;
            }
        }

        // Gets the distance it moved
        int distX = Math.abs(x - posX);
        int distY = Math.abs(y - posY);

        // Moves if the position change of (x == 2 and y == 1) or (x == 1 and y == 2)
        if ((distX == 1 && distY == 2) || (distX == 2 && distY == 1)) {
            return true;
        }

        // If conditions are not met, it will return false
        return false;
    }
}