package chess.game.pieces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PieceManager {

    private ArrayList<Piece> pieces;

    public PieceManager() {
        pieces = new ArrayList<>();
    }

    public void register(Piece piece) {
        pieces.add(piece);
    }

    public void drawPieces(Graphics g) {
        //
        for (int i = 0; i < pieces.size(); i++) {
            BufferedImage t = pieces.get(i).texture;
            //TODO: Draw positioned with - pieces.get(i).tileX

            // Draws the image of the piece
            g.drawImage(t, 0, 0, null);
        }
    }
}