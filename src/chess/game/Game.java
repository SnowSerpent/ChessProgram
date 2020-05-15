package chess.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import chess.game.pieces.Alliance;
import chess.game.pieces.Piece;
import chess.game.pieces.PieceManager;
import chess.game.pieces.Type;
import chess.game.pieces.units.Bishop;
import chess.game.pieces.units.King;
import chess.game.pieces.units.Knight;
import chess.game.pieces.units.Pawn;
import chess.game.pieces.units.Queen;
import chess.game.pieces.units.Rook;

public class Game {
    
    private PieceManager pieceManager;
    private Board board;

    public Game() {
        pieceManager = new PieceManager();
        board = new Board();

        // TODO: Might want to have this look at a saved game
        init();
    }

    public void init() {
        // TODO: Temporary for testing, this would set up the board
        makePiece(0, 0, Type.QUEEN, Alliance.BLACK);
    }

    public BufferedImage renderBoard() {

        // TODO: Set the board size based on the screen size (take in parameters for the board size)
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        // TODO: Draw the board texture and the piece textures
        // g.setColor(Color.GREEN);
        // g.fillRect(20, 20, 40, 40);

        board.drawBoard(g);
        pieceManager.drawPieces(g);

        g.dispose();
        return image;
    }

    public void makePiece(int x, int y, Type type, Alliance alliance) {

        Piece piece = null;

        // TODO: Change the piece type to create the right class type
        switch (type) {
            case PAWN: piece = new Pawn(x, y, alliance); break;
            case BISHOP: piece = new Bishop(x, y, alliance); break;
            case KING: piece = new King(x, y, alliance); break;
            case KNIGHT: piece = new Knight(x, y, alliance); break;
            case QUEEN: piece = new Queen(x, y, alliance); break;
            case ROOK: piece = new Rook(x, y, alliance); break;
            default: break; // TODO: Add a handle to this?
        }

        board.register(x, y, piece);
        pieceManager.register(piece);
    }

    public void move(int fromX, int fromY, int toX, int toY) {
        // TODO: make this
    }
}