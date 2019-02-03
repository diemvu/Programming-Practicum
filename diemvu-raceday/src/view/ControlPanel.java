
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_PARTICIPANT_LIST;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LEADER_BOARD;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Participant;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class ControlPanel extends JPanel implements PropertyChangeListener {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;
    /**
     * 
     */
    // private Map<Integer,Color> myColorMap;
    private static final Dimension CONTROL_SIZE = new Dimension(200, 400);
    // private List<Participant> myParticipantList;
    // private List<JButton> myParticipantButton;
    /**
     * 
     */
    private Map<Integer, String> myMapOfParticipant;
    /**
     * 
     */
    private ColorMap myColorMap;

    /**
     * 
     */

    public ControlPanel() {
        super();
        this.setPreferredSize(CONTROL_SIZE);
        this.setVisible(true);
        myMapOfParticipant = new HashMap<>();
        // myColorMap = new HashMap<>();
        // myColorMap = new ColorMap();
    }

    /**
     * 
     * @param theLeaderBoard leaderBoard
     */
    private void createComponent(final List<Integer> theLeaderBoard) {
        if (this.getComponentCount() != 0) {
            this.removeAll();
        }
        this.setLayout(new GridLayout(theLeaderBoard.size(), 1));
        for (Integer racerID : theLeaderBoard) {
            // final String a = myMapOfParticipant.get(racerID);
            final String s = racerID + " : " + myMapOfParticipant.get(racerID);
            final JButton b = new JButton(s);
            // Color a = myTrackPanel.getco
            b.setBackground(myColorMap.getColorMap().get(racerID));
            // b.setBackground(myTrackPanel.getColorMap().get(racerID));
            this.add(b);
            revalidate();

        }

    }

    /**
     * 
     * @param theParticipantList nothing
     */
    private void participantListToMap(final List<Participant> theParticipantList) {
        myMapOfParticipant = new HashMap<>();
        for (Participant p : theParticipantList) {
            final int id = Integer.valueOf(p.getMyRacerID());
            final String name = p.getMyRacerName();
            myMapOfParticipant.put(id, name);
        }
    }

    /**
     * 
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if (PROPERTY_PARTICIPANT_LIST.equals(theEvt.getPropertyName())) {
            // myParticipantList = new ArrayList<Participant>();
            @SuppressWarnings("unchecked")
            final List<Participant> participantList = (List<Participant>) theEvt.getNewValue();
            myColorMap = new ColorMap();
            participantListToMap(participantList);

        }
        if (PROPERTY_LEADER_BOARD.equals(theEvt.getPropertyName())) {
            @SuppressWarnings("unchecked")
            final List<Integer> pL = (List<Integer>) theEvt.getNewValue();
            createComponent(pL);
            // this.removeAll();

        }

    }
}
