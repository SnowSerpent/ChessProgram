package chess.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import chess.mechanics.display.Window;

public class MouseManager implements MouseListener {

    // TODO: Implement -
    // Select a piece when it clicks it
    // Move a piece when they move it
    // Highlight when moving over the game
    // Hide the mouse and display a fake mouse when in the window (only when IN the window)
    // Clicking fast doesnt seem to work, (ex: click on a piece then click on a square to move really fast and it wont register)
    // ^ this might be because window drops a few frame updates to regulate the speed, so maybe have engine handle it

    private Window window;

    public MouseManager(Window window) {
        this.window = window;
    }

    public void mouseClicked(MouseEvent e) {
        
        // Sends a click to the window
        window.click(e.getX(), e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        //
        //System.out.println("MouseManager: ENTER");
    }

    public void mouseExited(MouseEvent e) {
        //
        //System.out.println("MouseManager: EXIT");
    }

    public void mousePressed(MouseEvent e) {
        //
        //System.out.println("MouseManager: PRESS");
    }

    public void mouseReleased(MouseEvent e) {
        //
        //System.out.println("MouseManager: RELEASE");
    }
}