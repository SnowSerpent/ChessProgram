package chess.game.pieces;

import java.awt.image.BufferedImage;

import chess.mechanics.display.SpriteManager;

public abstract class Piece {

    // TODO: Do I need the tiles?
    protected int tileX;
    protected int tileY;

    protected Type type;
    protected Alliance alliance;

    protected BufferedImage texture;

    public Piece(int x, int y, Type type, Alliance alliance) {

        this.tileX = x;
        this.tileY = y;

        this.type = type;
        this.alliance = alliance;

        generateTexture();
    }

    // TODO: Temporary, dont know what I want to do currently
    public abstract boolean canMoveTo(int x, int y);

    public void setX(int x) {
        tileX = x;
    }

    public void setY(int y) {
        tileY = y;
    }

    public int getX() {
        return tileX;
    }

    public int getY() {
        return tileY;
    }

    // TODO: Might not need this
    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    private void generateTexture() {

        int height = 45;
        int width = 45;

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

        int yPix = 0;
        switch (alliance) {
            case WHITE: yPix = height * 0; break;
            case BLACK: yPix = height * 1; break;
            default: break;
        }

        texture = SpriteManager.pieces.getSubimage(xPix, yPix, width, height);
    }

    public BufferedImage getTexture() {
        return texture;
    }
}