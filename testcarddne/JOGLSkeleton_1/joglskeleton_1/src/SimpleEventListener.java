//package test;
import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;

/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
public class SimpleEventListener implements GLEventListener {
    
    /**
     * Constructor here.
     */
    public SimpleEventListener() {
    
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {    
    }
    
    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        
    }
    
    /**
     * Called when the GLAutoDrawable (GLCanvas or GLJPanel) has changed in size. We won't
     * need this, but you will eventually need it -- just not yet.
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
    
    /**
     * If the display depth is changed while the program is running this method is called.
     * Nowadays this doesn't happen much, unless a programmer has his program do it.
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
}