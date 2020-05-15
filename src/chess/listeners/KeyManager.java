package chess.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    // TODO: Might need to add some stuff to this to make it work better
    // TODO: Remake this

    public static boolean leftPressed = false;
    public static boolean rightPressed = false;
    public static boolean upPressed = false;
    public static boolean downPressed = false;

    public void keyPressed(KeyEvent e) {
        changeKeyPressed(e, true);
    }

    public void keyReleased (KeyEvent e) {
        changeKeyPressed(e, false);
    }

    private void changeKeyPressed(KeyEvent e, boolean state) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) { upPressed = state; }
        if (key == KeyEvent.VK_S) { downPressed = state; }
        if (key == KeyEvent.VK_A) { leftPressed = state; }
        if (key == KeyEvent.VK_D) { rightPressed = state; }
    }

    public void keyTyped (KeyEvent e) {
        // TODO: When ready, send typed keys to a TextHandler class to be used for things like interaction detection or typing
    }
}