package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Pawn extends Piece {

    private Boolean firstMove;
    private int direction;

    public Pawn(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.PAWN, alliance, board, manager);

        firstMove = true;

        // TODO: Might have the directions switched up
        if (alliance == Alliance.WHITE) {
            direction = -1;
        } else {
            direction = 1;
        }
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        // TODO: Make en passant
        // TODO: When it reaches the end, it can replace itself with a new piece

        // Makes sure it's not moving onto one of it's own pieces
        if (board.getPiece(x, y) != null) {
            if (board.getPiece(x, y).getAlliance() == alliance) {
                return false;
            }
        }

        // Move forward
        if (posX == x && posY + direction == y && board.getPiece(x, y) == null) {
            return true;
        }

        // Move forward * 2
        if (firstMove && posX == x && posY + direction * 2 == y && board.getPiece(x, y - direction) == null && board.getPiece(x, y) == null) {
            firstMove = false;
            return true;
        }

        // Capture
        if ((posX == x + 1 || posX == x - 1) && posY + direction == y && board.getPiece(x, y) != null) {
            return true;
        }

        // If conditions are not met, it will return false
        return false;
    }  
}