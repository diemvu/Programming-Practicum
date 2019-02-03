
package application;
import controller.Controller;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class Main {

    public static void main(String[] args) {
        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Controller().createAndShowGUI();
                // // GraphicFrame frame = new GraphicFrame();
                // frame.setSize(new Dimension(750, 600));
                // frame.setContentPane(new TrackPanel());
                // frame.setVisible(true);
            }
        });

    }
}
