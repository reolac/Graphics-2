import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class FileReader implements GLEventListener {

    /**
     * Interface to the GLU library.
     */
    private GLU glu;
    private VolumetricDataSet ds = null;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        try {
            ds = new VolumetricDataSet(new File("BostonTeapot.raw"), 256, 256, 178);

            GL gl = drawable.getGL();
            glu = new GLU();

            gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

            gl.glViewport(0, 0, 500, 300);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        if (ds == null) {
            return;
        }

        //VolumetricDataSet ds = new VolumetricDataSet(FileReader.class.getResourceAsStream("/marschnerlobb.raw"), 41, 41, 41);
        int[][][] allDimensions = ds.getVolumeData();

        int[] dimensions = ds.getDimensions();

        int x = dimensions[0];
        int y = dimensions[1];
        int z = dimensions[2];

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

//            gl.glColor3f(0.94f, 0.94f, 0.94f);
//            gl.glBegin(GL.GL_POLYGON);
//            gl.glVertex2f(330, 0);
//            gl.glVertex2f(330, 720);
//            gl.glVertex2f(333, 0);
//            gl.glVertex2f(333, 720);
//            gl.glEnd();
//
//            gl.glBegin(GL.GL_POLYGON);
//            gl.glVertex2f(165, 0);
//            gl.glVertex2f(165, 720);
//            gl.glVertex2f(168, 0);
//            gl.glVertex2f(168, 720);
//            gl.glEnd();
//            gl.glPushMatrix();
//            gl.glTranslated(-200.0, 0.0, 0.0);
        gl.glBegin(GL.GL_QUADS);

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                float col = (float) allDimensions[j][100][i] / 255f;
                System.out.println(allDimensions[100][j][i] + ": " + col);
                gl.glColor3f(col, col, col);

                gl.glVertex2d(i, j);
                gl.glVertex2d((i + 1), j);
                gl.glVertex2d((i + 1), (j + 1));
                gl.glVertex2d(i, (j + 1));
                System.out.println("x " + i + ": y " + j);
            }

        }
        gl.glEnd();
            //gl.glPopMatrix();

//            gl.glPushMatrix();
//            gl.glTranslated(0.0, 0.0, 0.0);
//            gl.glBegin(GL.GL_POLYGON);
//
//            for (int i = 1; i < 41; i++) {
//                for (int j = 0; j < 41; j++) {
//                    if (allDimensions[j][i][0] <= 225) {
//                        gl.glColor3f(0, 1, 0);
//                    } else {
//                        gl.glColor3f(1, 1, 1);
//                    }
//
//                    gl.glVertex2d(allDimensions[0][j][i], allDimensions[0][i][j]);
//                }
//
//            }
//            gl.glEnd();
//            gl.glPopMatrix();
        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

}
