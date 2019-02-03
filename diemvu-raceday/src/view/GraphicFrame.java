
package view;

// import static model.PropertyChangeEnabledRaceControls.PROPERTY_PARTICIPANT_LIST;
// import static model.PropertyChangeEnabledRaceControls.PROPERTY_LEADER_BOARD;
// import static model.PropertyChangeEnabledRaceControls.PROPERTY_LENGTH;
// import static model.PropertyChangeEnabledRaceControls.PROPERTY_MESSAGE_CHANGE;
// import static model.PropertyChangeEnabledRaceControls.PROPERTY_HEIGHT;
// import static model.PropertyChangeEnabledRaceControls.PROPERTY_WIDTH;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.PropertyChangeEnabledRaceControls;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class GraphicFrame extends JFrame implements PropertyChangeListener {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;

    /** The size of the Race Track Panel. */
    // private static final Dimension FRAME_SIZE = new Dimension(600, 300);
    // private static final Dimension TRACK_SIZE = new Dimension(400, 300);
    // private static final Dimension CONTROL_SIZE = new Dimension(200, 600);

    /** The x and y location of the Track. */
    private static final int OFF_SET = 500;

    /**
     * 
     */

    private TrackPanel myTrackPanel;
    /**
     * 
     */
    private ControlPanel myControlPanel;
    /**
     * 
     */
    private JPanel myPanel;
    /**
     * 
     */
    private JPanel myStatusBar;
    /**
     * 
     */
    private JLabel myTimeLabel;
    /**
     * 
     */
    private ColorMap myColorMap;

    /**
     * 
     * @param theModel RaceModel
     */
    public GraphicFrame(final PropertyChangeEnabledRaceControls theModel) {
        super("Race Track");
        this.setVisible(true);
        myPanel = new JPanel();

        myStatusBar = new JPanel();
        myStatusBar.setBackground(Color.GRAY);
        myTimeLabel = new JLabel();
        myTimeLabel.setText(TimeFormat.formatTime(0));
        this.add(myPanel, BorderLayout.NORTH);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(FRAME_SIZE);

        createPanel();
        addPropertyChangeListener(theModel);
    }

    /**
     * 
     */
    private void createPanel() {
        setLocation(OFF_SET, OFF_SET);
        myTrackPanel = new TrackPanel();
        myControlPanel = new ControlPanel();
        myPanel.add(myTrackPanel);
        myPanel.add(myControlPanel);
        myColorMap = new ColorMap();
        myStatusBar.add(myTimeLabel, BorderLayout.EAST);
        this.add(myStatusBar, BorderLayout.SOUTH);

        this.setResizable(false);

    }

    /**
     * 
     * @param theModel RaceModel
     */
    private void addPropertyChangeListener(final PropertyChangeEnabledRaceControls theModel) {
        theModel.addPropertyChangeListener(myTrackPanel);
        theModel.addPropertyChangeListener(myControlPanel);
        theModel.addPropertyChangeListener(this);
        theModel.addPropertyChangeListener(myColorMap);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            final int time = (Integer) theEvent.getNewValue();
            myTimeLabel.setText(TimeFormat.formatTime(time));

        }

    }
}
