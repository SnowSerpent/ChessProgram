package chess.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import chess.game.aspects.Board;
import chess.game.aspects.Player;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.PieceManager;
import chess.game.aspects.pieces.Type;

public class Game {
    
    private PieceManager pieceManager;
    private Board board;

    // TODO: Have a Boolean turn variable to decide who's turn it is then have a function to getCurrentPlayer() that returns the player based on the turn
    private Player player1;
    private Player player2;
    private Boolean turn;

    public Game() {

        // TODO: Make player classes to store what player is the alliance from, etc.
        // TODO: Add a win detection (maybe in Board)

        // Sets up the aspects of the game
        player1 = new Player(Alliance.WHITE);
        player2 = new Player(Alliance.BLACK);

        board = new Board(this);
        pieceManager = new PieceManager(board);

        // Sets up the board
        createBoard();
    }

    private void createBoard() {
        // TODO: Make this set up an existing game if they open a previously played game

        pieceManager.makePiece(0, 7, Type.ROOK, Alliance.WHITE);
        pieceManager.makePiece(1, 7, Type.KNIGHT, Alliance.WHITE);
        pieceManager.makePiece(2, 7, Type.BISHOP, Alliance.WHITE);
        pieceManager.makePiece(3, 7, Type.QUEEN, Alliance.WHITE);
        pieceManager.makePiece(4, 7, Type.KING, Alliance.WHITE);
        pieceManager.makePiece(5, 7, Type.BISHOP, Alliance.WHITE);
        pieceManager.makePiece(6, 7, Type.KNIGHT, Alliance.WHITE);
        pieceManager.makePiece(7, 7, Type.ROOK, Alliance.WHITE);

        pieceManager.makePiece(0, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(1, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(2, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(3, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(4, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(5, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(6, 6, Type.PAWN, Alliance.WHITE);
        pieceManager.makePiece(7, 6, Type.PAWN, Alliance.WHITE);

        pieceManager.makePiece(0, 0, Type.ROOK, Alliance.BLACK);
        pieceManager.makePiece(1, 0, Type.KNIGHT, Alliance.BLACK);
        pieceManager.makePiece(2, 0, Type.BISHOP, Alliance.BLACK);
        pieceManager.makePiece(3, 0, Type.QUEEN, Alliance.BLACK);
        pieceManager.makePiece(4, 0, Type.KING, Alliance.BLACK);
        pieceManager.makePiece(5, 0, Type.BISHOP, Alliance.BLACK);
        pieceManager.makePiece(6, 0, Type.KNIGHT, Alliance.BLACK);
        pieceManager.makePiece(7, 0, Type.ROOK, Alliance.BLACK);

        pieceManager.makePiece(0, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(1, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(2, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(3, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(4, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(5, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(6, 1, Type.PAWN, Alliance.BLACK);
        pieceManager.makePiece(7, 1, Type.PAWN, Alliance.BLACK);

        // Sets the player's turn
        turn = true;
    }

    private Player getCurrentPlayer() {
        if (turn) {
            return player1;
        } else {
            return player2;
        }
    }

    public BufferedImage getRenderedGame() {
        // TODO: Render sizes based on what the window size is (take in parameters for the board)
        // TODO: Maybe add a background just in case

        // Creates the image
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        // Draws aspects
        board.drawBoard(g);
        pieceManager.drawPieces(g);

        // Returns the image
        g.dispose();
        return image;
    }

    public Board getBoard() {
        return board;
    }

    public void clickCoordinates(int x, int y) {
        // TODO: If the piece is moved, track it's movement (save move history)
        // TODO: Add a check to make sure they aren't clicking outside of the board
        
        // TODO: Have a variable for the tile size so I dont have to use "45"
        // Gets the tile coordinates
        int tileX = (x - board.offsetX) / 45;
        int tileY = (y - board.offsetY) / 45;

        board.selectCoordinates(tileX, tileY, getCurrentPlayer().getAlliance());
    }

    public void nextTurn() {
        // TODO: Add timer that switches to the person's turn

        turn = !turn;
    }
}