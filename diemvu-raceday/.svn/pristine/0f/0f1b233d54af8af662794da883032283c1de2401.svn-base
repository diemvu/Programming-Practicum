
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MESSAGE_CHANGE;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_PARTICIPANT_LIST;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_HEIGHT;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_WIDTH;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_LENGTH;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import model.Message;
import model.Participant;
import model.TelemetryMessage;
import track.VisibleRaceTrack;

/**
 * A demo of Observable/Observer.
 * 
 * @author Charles Bryan
 * @version Autumn 2015
 */
public class TrackPanel extends JPanel implements PropertyChangeListener {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;

    /** The size of the Race Track Panel. */
    private static final Dimension TRACK_SIZE = new Dimension(500, 400);

    /** The x and y location of the Track. */
    private static final int OFF_SET = 40;

    /** The stroke width in pixels. */
    private static final int STROKE_WIDTH = 25;

    /** The size of participants moving around the track. */
    private static final int OVAL_SIZE = 20;

    /** The visible track. */
    private VisibleRaceTrack myTrack;

    /**
     * 
     */
    /**
     * 
     */
    private Map<Integer, Ellipse2D> myCircleMap;
    /**
     * 
     */
    private int myHeight;
    /**
     * 
     */
    private int myWidth;
  
    /**
     * 
     */
    private int myLength;
    /**
     * 
     */
    private ColorMap myColorMap;

    /**
     * Construct a Time Panel.
     */
    public TrackPanel() {

        super();
        // TrackPanel trackPanel = new TrackPanel();
        // myCircleList = new ArrayList<>();
        setPreferredSize(TRACK_SIZE);
        myCircleMap = new HashMap<>();
    }

    /**
     * Setup and layout components.
     */
    private void setupComponents() {

        final int raceWidth = myWidth * 100 - (OFF_SET * 2);
        final int raceHeight = myHeight * 100 - (OFF_SET * 2);
        final int x = OFF_SET;
        final int y = (int) TRACK_SIZE.getHeight() / 2 - raceHeight / 2;

        myTrack = new VisibleRaceTrack(x, y, raceWidth, raceHeight, myLength);
        // myTrack = new VisibleRaceTrack(x, y, raceWidth, raceHeight, theLength)
    }

    /**
     * Paints the VisibleTrack with a single ellipse moving around it.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        if (myTrack != null) {
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(STROKE_WIDTH));
            g2d.draw(myTrack);
        }
        if (!myCircleMap.equals(null)) {
            for (Integer racerID : myCircleMap.keySet()) {
                g2d.setPaint(myColorMap.getColorMap().get(racerID));
                // g2d.setPaint(myColorMap.get(racerID));
                g2d.setStroke(new BasicStroke(1));
                g2d.fill(myCircleMap.get(racerID));
            }
        }

    }

    /**
     * 
     * @param theParticipantList participant List
     */
    private void createCircleMap(final List<Participant> theParticipantList) {
        myCircleMap.clear();
        myCircleMap = new HashMap<>();
        for (Participant p : theParticipantList) {
            final int id = Integer.valueOf(p.getMyRacerID());
            final Point2D start =
                            myTrack.getPointAtDistance(Double.valueOf(p.getMyRacerDistance()));
            final Ellipse2D circle = new Ellipse2D.Double(start.getX() - OVAL_SIZE / 2,
                                                          start.getY() - OVAL_SIZE / 2,
                                                          OVAL_SIZE, OVAL_SIZE);

            myCircleMap.put(id, circle);
        }
    }

    /**
     * 
     * @param theTM telemetryMessage
     */
    private void alterCircleMap(final TelemetryMessage theTM) {
        final double dt = theTM.getMyDistance();
        final int id = theTM.getMyRacerID();
        final Point2D current = myTrack.getPointAtDistance(dt);
        myCircleMap.get(id).setFrame(current.getX() - OVAL_SIZE / 2,
                                     current.getY() - OVAL_SIZE / 2, OVAL_SIZE, OVAL_SIZE);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        // if (PROPERTY_TIMER_RUN.equals(theEvent.getPropertyName())) {
        // myCurrentTime = (Integer) theEvent.getNewValue();
        // }
        if (PROPERTY_MESSAGE_CHANGE.equals(theEvent.getPropertyName())) {
            final Message m = (Message) theEvent.getNewValue();
            if (m.getMessageType().equals("$T")) {
                final TelemetryMessage tm = (TelemetryMessage) m;
                alterCircleMap(tm);
                repaint();
            }
        }
        if (PROPERTY_PARTICIPANT_LIST.equals(theEvent.getPropertyName())) {
            final List<Participant> participantList =
                            (List<Participant>) theEvent.getNewValue();
            myColorMap = new ColorMap();
            final TitledBorder titled = new TitledBorder("Race Track");
            this.setBorder(titled);
            // createColorMap(participantList);
            createCircleMap(participantList);

            repaint();
        }
        if (PROPERTY_HEIGHT.equals(theEvent.getPropertyName())) {
            myHeight = (Integer) theEvent.getNewValue();
        }
        if (PROPERTY_WIDTH.equals(theEvent.getPropertyName())) {
            myWidth = (Integer) theEvent.getNewValue();
        }
        if (PROPERTY_LENGTH.equals(theEvent.getPropertyName())) {
            myLength = (Integer) theEvent.getNewValue();
            setupComponents();
        }
    }
}
