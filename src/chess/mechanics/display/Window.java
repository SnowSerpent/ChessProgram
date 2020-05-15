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
        frame.addMouseListener(new MouseManager());
        frame.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                // Runs when the window has been resized
                display.setSize(frame.getWidth(), frame.getHeight());
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
        display.setGameManager(engine.gameManager);
    }

    public void render() {
        display.repaint();
    }
}