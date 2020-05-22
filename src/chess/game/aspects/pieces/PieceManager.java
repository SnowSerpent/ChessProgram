package chess.game.aspects.pieces;

import java.awt.Graphics;
import java.util.ArrayList;

import chess.game.aspects.Board;
import chess.game.aspects.pieces.units.Bishop;
import chess.game.aspects.pieces.units.King;
import chess.game.aspects.pieces.units.Knight;
import chess.game.aspects.pieces.units.Pawn;
import chess.game.aspects.pieces.units.Queen;
import chess.game.aspects.pieces.units.Rook;

public class PieceManager {

    private ArrayList<Piece> pieces;
    
    private Board board;

    public PieceManager(Board board) {

        this.board = board;
        pieces = new ArrayList<>();
    }

    public void makePiece(int x, int y, Type type, Alliance alliance) {
        
        // The piece being created
        Piece piece = null;

        // Creates the piece
        switch (type) {
            case PAWN: piece = new Pawn(x, y, alliance, board, this); break;
            case BISHOP: piece = new Bishop(x, y, alliance, board, this); break;
            case KING: piece = new King(x, y, alliance, board, this); break;
            case KNIGHT: piece = new Knight(x, y, alliance, board, this); break;
            case QUEEN: piece = new Queen(x, y, alliance, board, this); break;
            case ROOK: piece = new Rook(x, y, alliance, board, this); break;
            default: break; // TODO: Add a handle to this?
        }

        // Adds the piece to the list
        pieces.add(piece);
    }

    public void drawPieces(Graphics g) {
        
        // TODO: Add a method to kill a piece so it wont display/interact anymore

        for (int i = 0; i < pieces.size(); i++) {

            // Gets the piece
            Piece p = pieces.get(i);

            // TODO: Have a way to set the square size of the board so I don't have to use "45"
            // Draws the image of the piece
            g.drawImage(p.getTexture(), board.offsetX + p.posX * 45, board.offsetY + p.posY * 45, null);
        }
    }

    public void capturePiece(Piece piece) {
        // TODO: Maybe add it to a seperate list or do something different with it
        pieces.remove(piece);
    }
}