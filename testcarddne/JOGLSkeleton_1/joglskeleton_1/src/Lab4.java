import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class Lab4 implements GLEventListener {

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

        gl.glViewport(0, 0, 1200, 800);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 1200, 0.0, 800);
    }

    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        //x1 y1 x2 y2  x3   y3
        //gl.glColor3f(1, 0, 0);
        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        //gl.glColor3f(0, 1, 0);
        //drawTriangle(gl, 100, 0, 100, 20, 200, 10);
        //gl.glColor3f(0, 0, 1);
        //drawTriangle(gl, 200, 0, 200, 20, 300, 10);
        gl.glTranslatef(800.0f, 500f, 0.0f);
        gl.glScalef(1.5f, 1.5f, 1f);
        drawArm(gl, 50, 0, 30, 30);
        gl.glPopMatrix();
        gl.glPushMatrix();

        drawPeacock(gl);

        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        //gl.glRotatef(30f, 0f, 0f, 1f);
        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        //gl.glRotatef(30f, 0f, 0f, 1f);
        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        //gl.glRotatef(30f, 0f, 0f, 1f);
        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        //gl.glRotatef(30f, 0f, 0f, 1f);
        //drawTriangle(gl, 0, 0, 0, 20, 100, 10);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

    private void drawTriangle(GL gl, int x1, int y1, int x2, int y2, int x3, int y3) {

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2i(x1, y1);
        gl.glVertex2i(x2, y2);
        gl.glVertex2i(x3, y3);

        gl.glEnd();

    }

    private void drawArm(GL gl, int offset, int angle0, int angle1, int angle2) {
        gl.glPopMatrix();
        gl.glPushMatrix();

        gl.glColor3f(1, 0, 0);
        gl.glRotatef(angle0, 0f, 0f, 10f);
        //x1 y1 x2 y2   x3  y3
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);

        gl.glPopMatrix();
        gl.glPushMatrix();

        gl.glColor3f(0, 1, 0);
        gl.glRotatef(angle1, 0f, 0f, 1f);
        gl.glTranslatef(80.0f, -40f, 0.0f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);

        gl.glPopMatrix();
        gl.glPushMatrix();

        gl.glColor3f(0, 0, 1);
        gl.glRotatef(angle2, 0f, 0f, 1f);
        gl.glTranslatef(170.0f, -40f, 0.0f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);

        gl.glPopMatrix();
        gl.glPushMatrix();
    }

    private void drawPeacock(GL gl) {

        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3f(178, 178, 0);
        gl.glRotatef(30, 0f, 0f, 1f);
        gl.glTranslatef(80.0f, -40f, 0.0f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);

    }
}
