package chess.game.pieces.units;

import chess.game.pieces.Alliance;
import chess.game.pieces.Piece;
import chess.game.pieces.Type;

public class Bishop extends Piece {

    public Bishop(int x, int y, Alliance alliance) {
        super(x, y, Type.BISHOP, alliance);
    }

    @Override
    public boolean canMoveTo(int x, int y) {

        // TODO: Make this to test if the piece can move to a position
        return true;
    }
}