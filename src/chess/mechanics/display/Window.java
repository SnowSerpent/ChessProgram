package chess.mechanics.display;

import java.awt.Canvas;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import chess.listeners.KeyManager;
import chess.listeners.MouseManager;
import chess.mechanics.engine.Engine;

public class Window extends Canvas {

    private static final long serialVersionUID = 2251578562383054784L;

    private JFrame frame;
    private Display display;

    private Engine engine;

    public Window(int width, int height, String title) {

        //Creates a window and a panel inside
        frame = new JFrame(title);
        display = new Display(width, height);
        frame.getContentPane().add(display);

        // Edits the preferances of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // TODO: May want to save data when closing
        frame.setSize(width, height);

        // Pops up in the center of the screen
        frame.setLocationRelativeTo(null);

        // Adds listeners to the window
        frame.addKeyListener(new KeyManager());
        frame.addMouseListener(new MouseManager(this));
        frame.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                // Runs when the window has been resized
                display.setDisplaySize(frame.getWidth(), frame.getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // Runs when the window has been moved
                // TODO: Make this
            }
        });

        // Shows the window
        frame.setVisible(true);
    }

    public void setEngine(Engine engine) {
        // TODO: Might want to edit this to make it better
        this.engine = engine;
        display.setGameManager(engine.gameManager);
    }

    public void render() {
        display.repaint();
    }

    public void click(int x, int y) {
        // TODO: Test to make sure it's clicked on the board, in the future add a Setup.java class to calculate things like if they click on settings or pause timer or a piece
        // TODO: Figure out if I want the -8 and -31 to be variables or something (this is the offset of the top bar and the resize window zone)
        engine.gameManager.getGame().clickCoordinates(x - 8, y - 31);
    }
}