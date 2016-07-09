//:if expand("%") == ""|browse confirm w|else|confirm w|endif
//package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

//import test.*;
/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class Simple extends JFrame {

    public static void main(String[] args) {
        final Simple app = new Simple();

        // show what we've done
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        app.setVisible(true);
                    }
                }
        );
    }

    public Simple() {
        //set the JFrame title
        super("File Reader");

        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FileReader fileReader = new FileReader();

        //only two JOGL lines of code ... and here they are 
        GLCanvas glcanvas = new GLCanvas();
        JPanel bottomOuterPanel = new JPanel();

        JPanel bottomLeftPanel = new JPanel();
        JPanel bottomCenterPanel = new JPanel();
        JPanel bottomRightPanel = new JPanel();

        JSlider xSlider = new JSlider(JSlider.HORIZONTAL, 0, 41, 0);
        
        JSlider ySlider = new JSlider(JSlider.HORIZONTAL, 0, 41, 0);
        JSlider zSlider = new JSlider(JSlider.HORIZONTAL, 0, 41, 0);

        xSlider.setMajorTickSpacing(10);
        xSlider.setMinorTickSpacing(1);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        
        ySlider.setMajorTickSpacing(10);
        ySlider.setMinorTickSpacing(1);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        
        zSlider.setMajorTickSpacing(10);
        zSlider.setMinorTickSpacing(1);
        zSlider.setPaintTicks(true);
        zSlider.setPaintLabels(true);        

        JLabel xLabel = new JLabel("                                             "
                + "           Slice through X");
        JLabel yLabel = new JLabel("                                             "
                + "           Slice through Y");
        JLabel zLabel = new JLabel("                                             "
                + "           Slice through Z");

        bottomOuterPanel.setLayout(new GridLayout(1, 3));

        bottomOuterPanel.add(bottomLeftPanel);
        bottomOuterPanel.add(bottomCenterPanel);
        bottomOuterPanel.add(bottomRightPanel);
        
        bottomLeftPanel.setLayout(new GridLayout(2, 1));
        
        bottomLeftPanel.add(xLabel);
        
        bottomLeftPanel.add(xSlider);
        
        bottomCenterPanel.setLayout(new GridLayout(2, 1));
        
        bottomCenterPanel.add(yLabel);
        
        bottomCenterPanel.add(ySlider);
        
        bottomRightPanel.setLayout(new GridLayout(2, 1));
        
        bottomRightPanel.add(zLabel);
        
        bottomRightPanel.add(zSlider);
        
        glcanvas.addGLEventListener(fileReader);

        //add the GLCanvas just like we would any Component
        getContentPane().add("Center", glcanvas);
        getContentPane().add("South", bottomOuterPanel);
        setSize(1280, 720);

        //center the JFrame on the screen
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}
