package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Rook extends Piece {

    public Rook(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.ROOK, alliance, board, manager);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        // TODO: Castle
        // TODO: Revise to match Bishop's code

        // Makes sure it's not moving onto one of it's own pieces
        if (board.getPiece(x, y) != null) {
            if (board.getPiece(x, y).getAlliance() == alliance) {
                return false;
            }
        }

        // Vertical movement
        if (x == posX) {

            // Sets distance and direction
            int distance = Math.abs(y - posY);
            int direction = y - posY > 0 ? 1 : -1;

            // Makes sure the piece isnt jumping over another piece
            for (int i = 1; i < distance; i++) {
                if (board.getPiece(posX, posY + i * direction) != null) {
                    return false;
                }
            }

            return true;
        }

        // Horrizontal movement
        if (y == posY) {

            // Sets distance and direction
            int distance = Math.abs(x - posX);
            int direction = x - posX > 0 ? 1 : -1;

            // Makes sure the piece isnt jumping over another piece
            for (int i = 1; i < distance; i++) {
                if (board.getPiece(posX + i * direction, posY) != null) {
                    return false;
                }
            }

            return true;
        }

        // If conditions are not met, it will return false
        return false;
    }
}