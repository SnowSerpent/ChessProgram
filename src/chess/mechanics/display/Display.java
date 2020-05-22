package chess.mechanics.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import chess.game.GameManager;

public class Display extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private BufferedImage content;
    private GameManager gameManager;

    private int width;
    private int height;

    public Display(int width, int height) {
        setDisplaySize(width, height);
    }

    public void setGameManager(GameManager gameManager) {
        // TODO: Might want to edit this to make it better
        this.gameManager = gameManager;
    }

    public void paintComponent(Graphics gfx) {

        // Loads the content of the window
        loadScreen();

        // Draws an image to the window
        gfx.drawImage(content, 0, 0, null);
    }

    private void loadScreen() {
        // TODO: Make this display depending on the location of the user (in or out of a game)

        // Creates the graphics
        Graphics g = content.getGraphics();

        // TODO: Check to make sure the person is in a game before trying to access the game they're in
        BufferedImage board = gameManager.getGame().getRenderedGame();

        // TODO: Temporary, draws the board
        g.drawImage(board, 0, 0, null);

        // Disposes the graphics
        g.dispose();
    }

    public void setDisplaySize(int width, int height) {

        this.width = width;
        this.height = height;

        // Resizes the screen
        content = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    }
}