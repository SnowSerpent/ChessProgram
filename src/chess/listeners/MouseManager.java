package chess.listeners;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    // TODO: Might need to add some stuff to this to make it work better
    // TODO: Remake this

    public static int mouseX;
    public static int mouseY;

    public void mouseClicked(MouseEvent e) {
        
        Point mouseP = MouseInfo.getPointerInfo().getLocation();
        mouseX = mouseP.x;
        mouseY = mouseP.y;

        // TODO: Remove this log
        System.out.println("Mouse clicked at (" + mouseX + ", " + mouseY + ")");
    }

    public void mouseEntered(MouseEvent e) {
        //
    }

    public void mouseExited(MouseEvent e) {
        //
    }

    public void mousePressed(MouseEvent e) {
        //
    }

    public void mouseReleased(MouseEvent e) {
        //
    }
}