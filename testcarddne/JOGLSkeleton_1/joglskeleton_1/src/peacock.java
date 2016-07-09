import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class peacock implements GLEventListener {

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
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        drawPeacock(gl);
        


    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

    private void drawRedSqr(GL gl, int x, int y) {
        gl.glPointSize(20);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2i(x, y);
        gl.glEnd();
    }
    
    private void drawOrangeSqr(GL gl, int x, int y){
        gl.glPointSize(60);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(1, 0.5f, 0f);
        gl.glVertex2i(x, y);
        gl.glEnd();
    }

    private void drawTriangle(GL gl, int x1, int y1, int x2, int y2, int x3, int y3) {

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2i(x1, y1);
        gl.glVertex2i(x2, y2);
        gl.glVertex2i(x3, y3);

        gl.glEnd();

    }

    private void drawPeacock(GL gl) {

        gl.glPushMatrix();
        gl.glColor3f(178, 178, 0);
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(120, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(115, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(110, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(105, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();
        // second part

        gl.glPushMatrix();
        gl.glTranslatef(760f, 310f, 0.0f);
        gl.glRotatef(160, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(760f, 310f, 0.0f);
        gl.glRotatef(140, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(760f, 310f, 0.0f);
        gl.glRotatef(120, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(760f, 310f, 0.0f);
        gl.glRotatef(100, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        // third part
        gl.glPushMatrix();
        gl.glTranslatef(570f, 370f, 0.0f);
        gl.glRotatef(160, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(610f, 425f, 0.0f);
        gl.glRotatef(140, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(650f, 480f, 0.0f);
        gl.glRotatef(120, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(715f, 500f, 0.0f);
        gl.glRotatef(100, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

// right side
        gl.glPushMatrix();
        gl.glColor3f(178, 178, 0);
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(120 - 60, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(115 - 60, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(110 - 60, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(105 - 60, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

// second part
        gl.glPushMatrix();
        gl.glTranslatef(880f, 270f, 0.0f);
        gl.glRotatef(160 - 90, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(880f, 270f, 0.0f);
        gl.glRotatef(140 - 90, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(880f, 270f, 0.0f);
        gl.glRotatef(120 - 90, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(880f, 270f, 0.0f);
        gl.glRotatef(100 - 90, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        //third part
        gl.glPushMatrix();
        gl.glTranslatef(930f, 440f, 0.0f);
        gl.glRotatef(160 - 90, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(980f, 410f, 0.0f);
        gl.glRotatef(140 - 90, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1030f, 370f, 0.0f);
        gl.glRotatef(120 - 90, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1065f, 315f, 0.0f);
        gl.glRotatef(100 - 90, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 255, 255);
        gl.glTranslatef(820f, 200f, 0.0f);
        gl.glRotatef(80, 0f, 0f, 1f);
        gl.glScaled(1, 2, 1);
        drawTriangle(gl, 0, 0, 0, 20, 330, 33);
        gl.glPopMatrix();

        gl.glPopMatrix();
        
                drawRedSqr(gl, 475, 395);
        
        drawRedSqr(gl, 525, 485);
        
        drawRedSqr(gl, 590, 565);
        
        drawRedSqr(gl, 692, 595);
        
        drawRedSqr(gl, 955, 545);
        
        drawRedSqr(gl, 1035, 495);
        
        drawRedSqr(gl, 1110, 425);
        
        drawRedSqr(gl, 1150, 340);
        
        drawOrangeSqr(gl, 810, 540);

    }
}
