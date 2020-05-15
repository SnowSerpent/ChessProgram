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

        // Sets the dimensions when it starts up
        setSize(width, height);
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void setSize(int width, int height) {

        // Sets dimensions
        this.width = width;
        this.height = height;

        // Resizes the screen
        content = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    }

    public void loadScreen() {

        // TODO: Make this display depending on if I'm in or outside of a game

        // Creates the graphics
        Graphics g = content.getGraphics();

        // TODO: Check to make sure the person is in a game before trying to access the game they're in
        BufferedImage board = gameManager.getGame().renderBoard();

        // TODO: Temporary, draws the board
        g.drawImage(board, 0, 0, null);

        // Disposes the graphics
        g.dispose();
    }

    public void paintComponent(Graphics gfx) {

        // Loads the content of the window
        loadScreen();

        // Draws an image to the window
        gfx.drawImage(content, 0, 0, null);
    }
}