// finish (and comment) me!

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.Filter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;

/**
 * 
 * @author ???
 * @version ???
 */
public class SnapShopGUI {
    /**
     * MYWIDTH the minimum width of the GUI window.
     */
    private static final int MYWIDTH = 200;
    /**
     * MYLENGTH the minimum length of the GUI window.
     */
    private static final int MYLENGTH = 110;
    /**
     * X x position of window.
     */
    private static final int X = 250;
    /**
     * Y y position of window.
     */
    private static final int Y = 100;
    /**
     * myFrame the main frame.
     */
    private JFrame myFrame;
    /**
     * myNorthPanel the panel contains all filter buttons.
     */
    private JPanel myNorthPanel;
    /**
     * mySouthPanel the panel contains all option buttons.
     */
    private JPanel mySouthPanel;
    /**
     * myCenterPanel the panel contains the image.
     */
    private JPanel myCenterPanel;
    /**
     * myButtons list of all buttons.
     */
    private List<JButton> myButtons;
    /**
     * myOpen my open button.
     */
    private JButton myOpen;
    /**
     * mySave my save button.
     */
    private JButton mySave;
    /**
     * myClose my close button.
     */
    private JButton myClose;
    /**
     * myFile my chosen file.
     */
    private JFileChooser myFile;
    /**
     * myImage Image of the choose file.
     */
    private PixelImage myImage;
    /**
     * myFilters list of all the filters.
     */
    private List<Filter> myFilters;
    /**
     * myLabel the Label of the chosen file.
     */
    private JLabel myLabel;
    
    /**
     * the program start from here.
     */
    public void start() {
        createFrame();

    }
    /**
     * create frame.
     */
    private void createFrame() {
        myFrame = new JFrame();
        myFrame.setTitle("TCSS 305 Assignment 4");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setResizable(true);
        myFrame.setMinimumSize(new Dimension(MYWIDTH, MYLENGTH));
        myFrame.setLocation(X, Y);
        createPanel();
        myFrame.add(myNorthPanel, BorderLayout.NORTH);
        myFrame.add(mySouthPanel, BorderLayout.SOUTH);
        myFrame.add(myCenterPanel, BorderLayout.CENTER);
        myFrame.pack();

    }
    /**
     * create north, center and south panel.
     */
    private void createPanel() {
        myNorthPanel = new JPanel();
        myCenterPanel = new JPanel();
        mySouthPanel = new JPanel();
        createButtons();
    }
    /**
     * create open button.
     */
    private void createOpenButton() {
        myOpen = new JButton("Open ...");
        myLabel = new JLabel();
        myFile = new JFileChooser();
        myFile.setCurrentDirectory(new File("."));
        myOpen.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final int x = myFile.showOpenDialog(myFrame);
                final File file = myFile.getSelectedFile();
                if (file != null && x == JFileChooser.APPROVE_OPTION) {
                    try {
                        myImage = PixelImage.load(file);
                        myLabel.setIcon(new ImageIcon(myImage));
                        myCenterPanel.removeAll();
                        myCenterPanel.add(myLabel);
                        myFrame.pack();
                        enableButtons();
                    } catch (final IOException e1) {
                        JOptionPane.showMessageDialog(null,
                                                      file.getName() + " is not an image");
                    }
                }
            }
        });
        mySouthPanel.add(myOpen);
    }
    /**
     * make all buttons appear.
     */
    private void enableButtons() {
        for (int i = 0; i < myButtons.size(); i++) {
            myButtons.get(i).setEnabled(true);
        }
    }
    /**
     * create save button.
     */
    private void createSaveButton() {
        mySave = new JButton("Save As ...");

        mySave.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFile.showSaveDialog(myFrame);

                if (myFile.getSelectedFile() != null) {
                    final File file = myFile.getSelectedFile();
                    try {
                        myImage.save(file);
                    } catch (final IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        mySave.setEnabled(false);
        mySouthPanel.add(mySave);
    }
    /**
     * Create close button.
     */
    private void createCloseButton() {
        myClose = new JButton("Close Image");
        myClose.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                for (int i = 0; i < myButtons.size(); i++) {
                    myButtons.get(i).setEnabled(false);
                }
                myOpen.setEnabled(true);
                myCenterPanel.removeAll();
                myFrame.pack();
            }
        });
        myClose.setEnabled(false);
        mySouthPanel.add(myClose);
    }
    /**
     * Create filters.
     */
    private void createFilters() {
        myFilters = new ArrayList<>();
        myFilters.add(new EdgeDetectFilter());
        myFilters.add(new EdgeHighlightFilter());
        myFilters.add(new FlipHorizontalFilter());
        myFilters.add(new FlipVerticalFilter());
        myFilters.add(new GrayscaleFilter());
        myFilters.add(new SharpenFilter());
        myFilters.add(new SoftenFilter());

    }
    /**
     * create filter buttons.
     */
    private void createFilterButtons() {
        createFilters();
        for (int i = 0; i < myFilters.size(); i++) {
            final JButton button = createFilterButton(myFilters.get(i));
            myButtons.add(button);
            myNorthPanel.add(button);
            button.setEnabled(false);
        }
    }
    /**
     * 
     * @param theFilter type of filter the button represent.
     * @return JButton
     */
    private JButton createFilterButton(final Filter theFilter) {
        final JButton button = new JButton(theFilter.getDescription());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                theFilter.filter(myImage);
                myLabel.setIcon(new ImageIcon(myImage));
                myCenterPanel.removeAll();
                myCenterPanel.add(myLabel);
                myFrame.pack();
            }
        });
        return button;
    }
    /**
     * create all the buttons.
     */
    private void createButtons() {
        myButtons = new ArrayList<>();
        createFilterButtons();
        createOpenButton();
        createSaveButton();
        createCloseButton();
        myButtons.add(myOpen);
        myButtons.add(mySave);
        myButtons.add(myClose);

    }

}
