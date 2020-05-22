package chess.game.aspects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import chess.game.Game;
import chess.game.aspects.pieces.Alliance;
import chess.game.aspects.pieces.Piece;
import chess.mechanics.display.SpriteManager;

public class Board {

    // TODO: Have a way to set a piece to a map tile

    private Game game;

    private BufferedImage texture;

    private Piece[][] pieceMap;
    private Piece selectedPiece;

    // TODO: Edit these values somehow when the window is resized, Maybe make this a function to get the values?
    public int offsetX;
    public int offsetY;
    
    public Board(Game game) {

        this.game = game;

        texture = SpriteManager.board;
        pieceMap = new Piece[8][8];
        selectedPiece = null;

        // TODO: Get a better way to set this up
        offsetX = 100;
        offsetY = 40;
    }

    public void drawBoard(Graphics g) {

        // Draws the board
        g.drawImage(texture, offsetX, offsetY, null);
    }

    public void setPiece(int x, int y, Piece piece) {
        pieceMap[x][y] = piece;
    }

    public void movePiece(int fromX, int fromY, int toX, int toY) {

        // Gets the pieces
        Piece movedPiece = getPiece(fromX, fromY);
        Piece capturedPiece = getPiece(toX, toY);

        // Captures the piece
        if (capturedPiece != null) {
            capturedPiece.capture();
        }

        // Sets the current position to null
        setPiece(fromX, fromY, null);

        // Places the piece in a new position
        setPiece(toX, toY, movedPiece);
    }

    // TODO: Might not need getPiece
    public Piece getPiece(int x, int y) {
        // TODO: Maybe return a Ghost piece if there is no piece in the spot (a ghost piece has all the same functions, but has a null alliance, null position, etc.)
        return pieceMap[x][y];
    }

    public void selectCoordinates(int x, int y, Alliance currentAlliance) {
        // TODO: Keep track of movement history
        // TODO: Add visuals for a selected piece
        // TODO: Make this
        // TODO: Visuals might help because sometimes the click doesnt register or something?
        // TODO: Add a check to make sure they aren't clicking outside of the board
        
        // Gets the piece
        Piece p = pieceMap[x][y];

        // Logic for piece selection and movement
        if (selectedPiece != null) {
            if (selectedPiece.canMoveTo(x, y)) {

                // Moves the piece
                selectedPiece.move(x, y);

                // Next person's turn
                game.nextTurn();
            }
            selectedPiece = null;
        }
        if (p != null) {
            if (p.getAlliance() == currentAlliance) {
                selectedPiece = p;
            }
        }
    }
}