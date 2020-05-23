package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Bishop extends Piece {

    public Bishop(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.BISHOP, alliance, board, manager);
    }

    @Override
    public boolean canMoveTo(int x, int y) {

        // Makes sure it's not moving onto one of it's own pieces
        if (board.getPiece(x, y) != null) {
            if (board.getPiece(x, y).getAlliance() == alliance) {
                return false;
            }
        }

        // Gets the distance values
        int distX = x - posX;
        int distY = y - posY;

        // Moving diagonally
        if (Math.abs(distX) == Math.abs(distY)) {

            // Makes sure the piece isnt jumping over another piece
            for (int i = 1; i < Math.abs(distX); i++) {

                if (board.getPiece(posX + i * (int) Math.signum(distX), posY + i * (int) Math.signum(distY)) != null) {
                    return false;
                }
            }

            // If conditions are met, it will return true
            return true;
        }

        // If conditions are not met, it will return false
        return false;
    }
}