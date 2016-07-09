import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class Lab3 implements GLEventListener {

    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of setup here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glViewport(0, 0, 1000, 600);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
    }

    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glColor3f(1, 1, 1); drawLine(gl, 0, 0, 100, 100);

        gl.glColor3f(1,0,0); drawLine(gl, 0,0,200,100);
        gl.glColor3f(0,1,0); drawLine(gl, 0,0,200,0);
        gl.glColor3f(0,0,1); drawLine(gl, 0,0,2,100);
        gl.glColor3f(0,1,1); drawLine(gl, 0,0,200,4);
        gl.glColor3f(1,1,0); drawLine(gl, -100,-100,100,100);
        gl.glColor3f(1,1,0); drawLine(gl, 0,0,-130,-130);
        //drawCurves(gl, 0, 150, 250, 50);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

    public void drawLine(GL gl, int x1, int y1, int x2, int y2) {
        double dy = y2 - y1;
        double dx = x2 - x1;
        double m = dy / dx;
        double c = y1 - m * x1;

        gl.glPointSize(5.0f);
        gl.glBegin(GL.GL_POINTS);

        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);

        for (int x = x1; x <= x2; ++x) {
            double y = m * x + c;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();

    }

    public void drawCurves(GL gl, int x1, int y1, int x2, int y2) {
        double dy = y2 - y1;
        double dx = x2 - x1;
        double m = dy / dx;
        double c = y1 - m * x1;

        gl.glPointSize(10.0f);
        gl.glBegin(GL.GL_POINTS);

        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);

        for (int x = x1; x <= x2; ++x) {

            gl.glColor3f(1, 0, 0);
            gl.glVertex2d(x, (Math.sin((double) x / 100.0) * 100.0));
            
            gl.glColor3f(0, 1, 0);
            gl.glVertex2d(x, (Math.cos((double) x / 100.0) * 100.0));

            gl.glColor3f(0, 0, 1);
            gl.glVertex2d(x, (Math.tan((double) x / 120.0) * 120.0));

        }
        gl.glEnd();

    }
}
