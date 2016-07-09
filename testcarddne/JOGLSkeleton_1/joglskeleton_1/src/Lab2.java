import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class Lab2 implements GLEventListener {

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
    @Override
    public void display(GLAutoDrawable drawable) {

        float red = 1.0f;
        float green = 0.0f;
        float blue = 0.0f;

        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(25.0f);
        gl.glColor3f(red, green, blue);

        gl.glBegin(GL.GL_POINTS);
        /**
         * gl.glVertex2i(20, 30); red = 0.0f; green = 1.0f; gl.glColor3f(red,
         * green, blue); gl.glVertex2i(50, 30); green = 0.0f; blue = 1.0f;
         * gl.glColor3f(red, green, blue); gl.glVertex2i(80, 30); gl.glEnd();
         * gl.glPointSize(12.0f);
         *
         * int y = 100; for (int i = 5; i < 16; i++) {
         *
         * for (y = 5; y < 16; y++) {
         *
         * if (i % 2 == 0) { red = 0.0f; green = 1.0f; blue = 0.0f;
         * gl.glColor3f(red, green, blue); } else { red = 1.0f; green = 0.0f;
         * blue = 0.0f; gl.glColor3f(red, green, blue); } gl.glColor3f(red,
         * green, blue); gl.glBegin(GL.GL_POINTS); gl.glVertex2i((i * 16), (y *
         * 16)); gl.glEnd(); } }
         *
         *
         * double radius = 10000; gl.glPointSize(10.0f); radius =
         * Math.toRadians(radius);
         *
         * for (int i = 0; i < 30; i++) { double degInRad = i * radius;
         * degInRad++;
         *
         *
         * gl.glBegin(GL.GL_POINTS); gl.glColor3f(0, 0, 1);
         *
         * gl.glVertex2d(Math.cos(degInRad) * radius + 300, Math.sin(degInRad) *
         * radius + 100); gl.glEnd(); }
         */

        float r = 1;
        int maxseg = 20;
        for (int segments = 0; segments < maxseg * 50; segments++) {
            float angle = segments / maxseg;
            gl.glVertex3d(r * Math.cos(angle), r * Math.sin(angle), 0);
            r *= 0.9;
        }
        

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

}
