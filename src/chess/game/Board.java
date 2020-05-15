package chess.game;

import java.awt.Color;
import java.awt.Graphics;

import chess.game.pieces.Piece;

public class Board {

    private Piece[][] tileMap;
    
    public Board() {
        tileMap = new Piece[8][8];
    }

    public void register(int x, int y, Piece piece) {
        tileMap[x][y] = piece;
    }

    public void drawBoard(Graphics g) {

        // TODO: Temporary for drawing the board
        g.setColor(Color.RED);
        g.fillRect(20, 20, 40, 40);
    }
}