import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * For now we will focus only two of the GLEventListeners init() and display().
 */
public class TestCard implements GLEventListener {

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

        gl.glViewport(0, 0, 1000, 500);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, 1000, 0.0, 500);
    }

    /**
     * Take care of drawing here.
     */
    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(25.0f);
        drawRectangles(gl);

        gl.glPointSize(12.0f);
        drawGrid(gl);

        gl.glPointSize(3.0f);
        drawSpiral(gl, 100, 100);
        
        gl.glPushMatrix();
        gl.glPointSize(2.0f);
        gl.glColor3f(0, 1, 0);
        gl.glTranslated(150, 250, 0);
        gl.glScaled(0.5, 0.5, 1);
        
        drawLine(gl, 400, 350, 600, 350);
        gl.glColor3f(1, 0, 0);
        drawLine(gl, 400, 350, 600, 450);
        gl.glColor3f(0, 1, 0);
        drawLine(gl, 400, 350, 600, 350);
        gl.glColor3f(0, 0, 1);
        drawLine(gl, 400, 350, 400, 450);
        gl.glColor3f(0, 1, 1);
        drawLine(gl, 400, 350, 600, 354);
        gl.glColor3f(1, 1, 0);
        drawLine(gl, 300, 250, 500, 450);
        gl.glColor3f(0, 1, 0);
        drawLine(gl, 400, 350, 600, 350);
        gl.glPopMatrix();
        
        // bresn
        
        gl.glPushMatrix();
        gl.glColor3f(0, 1, 0);
        gl.glTranslated(350, 250, 0);
        gl.glScaled(0.5, 0.5, 1);
        drawBresnams(gl, 400, 350, 600, 350);
        gl.glColor3f(1, 0, 0);
        drawBresnams(gl, 400, 350, 600, 450);
        gl.glColor3f(0, 1, 0);
        drawBresnams(gl, 400, 350, 600, 350);
        gl.glColor3f(0, 0, 1);
        drawBresnams(gl, 400, 350, 400, 450);
        gl.glColor3f(0, 1, 1);
        drawBresnams(gl, 400, 350, 600, 354);
        gl.glColor3f(1, 1, 0);
        drawBresnams(gl, 300, 250, 500, 450);
        gl.glColor3f(0, 1, 0);
        drawBresnams(gl, 400, 350, 600, 350);
        gl.glPopMatrix();
        
        //star
        
        gl.glPushMatrix();
        gl.glColor3f(0, 1, 0);
        gl.glTranslated(275, 100, 0);
        gl.glScaled(0.5, 0.5, 1);
        drawBresnams(gl, 400, 400, 600, 400);
        gl.glColor3f(1, 0, 0);
        drawBresnams(gl, 400, 400, 600, 600);
        gl.glColor3f(0, 1, 0);
        drawBresnams(gl, 400, 400, 400, 600);
        gl.glColor3f(0, 0, 1);
        drawBresnams(gl, 400, 400, 400, 200);
        gl.glColor3f(0, 1, 1);
        drawBresnams(gl, 400, 400, 200, 200);
        gl.glColor3f(1, 1, 0);
        drawBresnams(gl, 400, 400, 600, 200);
        gl.glColor3f(0, 1, 0);
        drawBresnams(gl, 400, 400, 200, 600);
        gl.glColor3f(0, 1, 0);
        drawBresnams(gl, 400, 400, 200, 400);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        
        
        drawCurves(gl, 400, 400, 600, 400);
        gl.glPopMatrix();
        
        
        gl.glPushMatrix();
        gl.glTranslated(0, -30, 0);
        drawArm(gl, 50, 0, 30, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(400, -50, 0);
        gl.glScaled(0.5, 0.5, 1);
        drawPeacock(gl);
        gl.glPopMatrix();

    }

    public void drawRectangles(GL gl) {

        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2i(40, 450);

        gl.glColor3f(0, 1, 0);
        gl.glVertex2i(70, 450);

        gl.glColor3f(0, 0, 1);
        gl.glVertex2i(100, 450);

        gl.glEnd();
    }

    public void drawGrid(GL gl) {
        for (int i = 3; i < 16; i++) {
            for (int y = 3; y < 16; y++) {
                if (i % 2 == 0) {
                    gl.glColor3f(0, 1, 0);
                } else {
                    gl.glColor3f(1, 0, 0);
                }
                gl.glBegin(GL.GL_POINTS);
                gl.glVertex2i((i * 16) - 13, (y * 16) + 170);
            }
        }
        gl.glEnd();
    }

    public void drawSpiral(GL gl, int x, int y) {
        gl.glBegin(GL.GL_POINTS);

        for (int ang = 0; ang <= 236; ang++) {

            double angle = 0.08 * ang;
            if (ang <= 200) {
                gl.glColor3f(0f, 0f, 1f);
            }
            if (ang <= 158) {
                gl.glColor3f(0f, 1f, 0f);
            }
            if (ang <= 82) {
                gl.glColor3f(1f, 0f, 0f);
            }
            gl.glVertex2d(x + Math.cos(angle) * (4 * angle), y + Math.sin(angle) * (4 * angle));

        }
        gl.glEnd();
    }

    public void drawLine(GL gl, int x1, int y1, int x2, int y2) {
        double dy = y2 - y1;
        double dx = x2 - x1;
        double m = dy / dx;
        double c = y1 - m * x1;

        gl.glBegin(GL.GL_POINTS);

        for (int x = x1; x <= x2; ++x) {
            double y = m * x + c;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    public void drawBresnams(GL gl, int x1, int y1, int x2, int y2) {
        gl.glBegin(GL.GL_POINTS);
        int w = x2 - x1;
        int h = y2 - y1;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
        if (w < 0) {
            dx1 = -1;
        } else if (w > 0) {
            dx1 = 1;
        }
        if (h < 0) {
            dy1 = -1;
        } else if (h > 0) {
            dy1 = 1;
        }
        if (w < 0) {
            dx2 = -1;
        } else if (w > 0) {
            dx2 = 1;
        }
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) {
                dy2 = -1;
            } else if (h > 0) {
                dy2 = 1;
            }
            dx2 = 0;
        }
        int numerator = longest >> 1;
        for (int i = 0; i <= longest; i++) {
            gl.glVertex2d(x1, y1);
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x1 += dx1;
                y1 += dy1;
            } else {
                x1 += dx2;
                y1 += dy2;
            }
        }
        gl.glEnd();
    }

    public void drawCurves(GL gl, int x1, int y1, int x2, int y2) {
        gl.glPointSize(10f);
        gl.glBegin(GL.GL_POINTS);
        int w = x2 - x1;
        int h = y2 - y1;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
        if (w < 0) {
            dx1 = -1;
        } else if (w > 0) {
            dx1 = 1;
        }
        if (h < 0) {
            dy1 = -1;
        } else if (h > 0) {
            dy1 = 1;
        }
        if (w < 0) {
            dx2 = -1;
        } else if (w > 0) {
            dx2 = 1;
        }
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) {
                dy2 = -1;
            } else if (h > 0) {
                dy2 = 1;
            }
            dx2 = 0;
        }
        int numerator = longest >> 1;
        for (int i = 0; i <= longest; i++) {
                        gl.glColor3f(1, 0, 0);
            gl.glVertex2d(x1, (Math.sin((double) x1 / 60.0) * 100.0) + 80);

            gl.glColor3f(0, 1, 0);
            gl.glVertex2d(x1, (Math.cos((double) x1 / 60.0) * 100.0) + 80);

            
            if (x1 < 453)
            {
            
            gl.glColor3f(0, 0, 1);
            gl.glVertex2d(x1, (Math.tan((double) x1 / 60.0) * 40.0) + 80);
            }
            
            if (x1 > 490)
            {
            gl.glColor3f(0, 0, 1);
            gl.glVertex2d(x1, (Math.tan((double) x1 / 60.0) * 40.0) + 80);
            }
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x1 += dx1;
                y1 += dy1;
            } else {
                x1 += dx2;
                y1 += dy2;
            }
        }
        gl.glEnd();
    }

    

    private void drawTriangle(GL gl, int x1, int y1, int x2, int y2, int x3, int y3) {

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2i(x1, y1);
        gl.glVertex2i(x2, y2);
        gl.glVertex2i(x3, y3);

        gl.glEnd();

    }

    private void drawArm(GL gl, int offset, int angle0, int angle1, int angle2) {

        gl.glPushMatrix();
        gl.glColor3f(1, 0, 0);
        gl.glRotatef(angle0, 0f, 0f, 10f);
        drawTriangle(gl, 695, 400, 695, 420, 795, 410);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 1, 0);
        gl.glRotatef(angle1, 0f, 0f, 1f);
        gl.glTranslatef(80.0f, -40f, 0.0f);
        drawTriangle(gl, 800, -5, 800, 15, 900, 5);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 0, 1);
        gl.glRotatef(angle2, 0f, 0f, 1f);
        gl.glTranslatef(170.0f, -40f, 0.0f);
        drawTriangle(gl, 795, -5, 795, 15, 895, 5);
        gl.glPopMatrix();


    }

    private void drawPeacock(GL gl) {


        gl.glPushMatrix();
        gl.glColor3f(178, 178, 0);
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(140, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(135, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(130, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(800f, 200f, 0.0f);
        gl.glRotatef(125, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();
        // second part

        gl.glPushMatrix();
        gl.glTranslatef(725f, 280f, 0.0f);
        gl.glRotatef(175, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(725f, 280f, 0.0f);
        gl.glRotatef(155, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(725f, 280f, 0.0f);
        gl.glRotatef(135, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(725f, 280f, 0.0f);
        gl.glRotatef(115, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();
  
        // third part
        gl.glPushMatrix();
        gl.glTranslatef(560f, 285f, 0.0f);
        gl.glRotatef(175, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(560f, 345f, 0.0f);
        gl.glRotatef(155, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(580f, 410f, 0.0f);
        gl.glRotatef(135, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(630f, 450f, 0.0f);
        gl.glRotatef(115, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

// right side
        gl.glPushMatrix();
        gl.glColor3f(178, 178, 0);
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(40, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(35, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(30, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(815f, 190f, 0.0f);
        gl.glRotatef(30, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

// second part
        gl.glPushMatrix();
        gl.glTranslatef(885f, 240f, 0.0f);
        gl.glRotatef(-15, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(885f, 240f, 0.0f);
        gl.glRotatef(5, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(885f, 240f, 0.0f);
        gl.glRotatef(25, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(885f, 240f, 0.0f);
        gl.glRotatef(45, 0f, 0f, 1f);
        gl.glScaled(2, 2, 2);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        //third part
        gl.glPushMatrix();
        gl.glTranslatef(1005f, 380f, 0.0f);
        gl.glRotatef(45, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1030f, 320f, 0.0f);
        gl.glRotatef(25, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1050f, 265f, 0.0f);
        gl.glRotatef(5, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1065f, 205f, 0.0f);
        gl.glRotatef(-15, 0f, 0f, 1f);
        drawTriangle(gl, 0, 0, 0, 20, 100, 10);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 255, 255);
        gl.glTranslatef(820f, 200f, 0.0f);
        gl.glRotatef(80, 0f, 0f, 1f);
        gl.glScaled(1, 2, 1);
        drawTriangle(gl, 0, 0, 0, 20, 330, 33);
        gl.glPopMatrix();

        drawRedSqr(gl, 450, 285);

        drawRedSqr(gl, 470, 380);

        drawRedSqr(gl, 490, 475);

        drawRedSqr(gl, 585, 535);

        drawRedSqr(gl, 1060, 455);

        drawRedSqr(gl, 1105, 370);

        drawRedSqr(gl, 1160, 280);

        drawRedSqr(gl, 1160, 195);

        drawOrangeSqr(gl, 810, 540);

    }

    private void drawRedSqr(GL gl, int x, int y) {
        gl.glPointSize(20);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2i(x, y);
        gl.glEnd();
    }

    private void drawOrangeSqr(GL gl, int x, int y) {
        gl.glPointSize(60);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(1, 0.5f, 0f);
        gl.glVertex2i(x, y);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

}
