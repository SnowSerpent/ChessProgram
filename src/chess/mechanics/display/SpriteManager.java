package chess.mechanics.display;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteManager {

    public static BufferedImage pieces;
    
    public SpriteManager() {
        pieces = loadSheet("pieces");
    }

    private BufferedImage loadSheet(String path) {

        // Gets the image
        File file = new File("gfx/" + path + ".png");
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) { }

        // Returns the sheet
        return img;
    }
}