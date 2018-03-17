package input;

import base.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

//record events from mouse for everything
public class MouseMotionInput implements MouseMotionListener {

    public static MouseMotionInput instance = new MouseMotionInput();

    public Vector2D position;

    private MouseMotionInput(){
        this.position = new Vector2D();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(e.getX(), e.getY());
    }
}
