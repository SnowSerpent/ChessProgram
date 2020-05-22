package chess.game.aspects.pieces.units;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Queen extends Piece {

    public Queen(int x, int y, Alliance alliance, Board board, PieceManager manager) {
        super(x, y, Type.QUEEN, alliance, board, manager);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        // TODO: Make this

        return true;
    } 
}