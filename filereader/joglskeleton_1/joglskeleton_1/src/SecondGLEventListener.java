import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;


/**
 * For now we will focus only two of the GLEventListeners
 *         init() and display().
 */
public class SecondGLEventListener implements GLEventListener {

    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        glu = new GLU();
        
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
    }
    
    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        


        
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
 int height) {}

    public void displayChanged(GLAutoDrawable drawable, 
boolean modeChanged, boolean deviceChanged) {}

}