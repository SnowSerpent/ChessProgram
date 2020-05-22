package chess.game.aspects.pieces;

import java.awt.image.BufferedImage;

import chess.game.aspects.Board;
import chess.mechanics.display.SpriteManager;

public abstract class Piece {

    protected BufferedImage texture;

    protected Type type;
    protected Alliance alliance;
    protected Board board;
    protected PieceManager manager;

    protected int posX;
    protected int posY;

    public Piece(int x, int y, Type type, Alliance alliance, Board board, PieceManager manager) {

        this.type = type;
        this.alliance = alliance;
        this.board = board;
        this.manager = manager;

        // Sets the piece on the board
        posX = x;
        posY = y;
        board.setPiece(posX, posY, this);

        // Creates the texture of this piece
        generateTexture();
    }

    // TODO: Currently not needed
    // Function to figure out if the piece can move to a square
    public abstract boolean canMoveTo(int x, int y);
    
    private void generateTexture() {

        // TODO: Maybe get a sprite class to store each individual piece so I dont have to do this

        // Sets the width and height of the images
        int height = 45;
        int width = 45;

        // Gets the x position of the texture
        int xPix = 0;
        switch (type) {
            case KING: xPix = width * 0; break;
            case QUEEN: xPix = width * 1; break;
            case BISHOP: xPix = width * 2; break;
            case KNIGHT: xPix = width * 3; break;
            case ROOK: xPix = width * 4; break;
            case PAWN: xPix = width * 5; break;
            default: break;
        }

        // Gets the y position of the texture
        int yPix = 0;
        switch (alliance) {
            case WHITE: yPix = height * 0; break;
            case BLACK: yPix = height * 1; break;
            default: break;
        }

        // Sets the texture
        texture = SpriteManager.pieces.getSubimage(xPix, yPix, width, height);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void move(int x, int y) {

        // Moves the piece on the board
        board.movePiece(posX, posY, x, y);

        // Sets the new piece position
        posX = x;
        posY = y;
    }

    public void capture() {
        //PieceManager.removePiece()
        manager.capturePiece(this);
    }
}