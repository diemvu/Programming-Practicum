
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_PARTICIPANT_LIST;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Participant;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class ColorMap implements PropertyChangeListener {
    /**
     * 
     */
    private static Map<Integer, Color> myColorMap;
    /**
     * 
     */
    private List<Participant> myParticipantList;

    /**
     * 
     */
    public ColorMap() {
        myColorMap = new HashMap<>();
        myParticipantList = new ArrayList<>();
        // createColorMap();
    }

    /**
     * 
     */
    private void createColorMap() {
        for (Participant p : myParticipantList) {
            final Color color = createRandomColor();
            final Integer racerID = Integer.valueOf(p.getMyRacerID());
            myColorMap.put(racerID, color);
        }

    }

    /**
     * 
     * @return colorMap
     */
    public Map<Integer, Color> getColorMap() {
        return myColorMap;

    }

    /**
     * 
     * @return random Color
     */
    private Color createRandomColor() {
        final int r = (int) (Math.random() * 255);
        final int g = (int) (Math.random() * 255);
        final int b = (int) (Math.random() * 255);
        final Color randomColor = new Color(r, g, b);
        return randomColor.brighter();
    }

    /**
     * theEvent event.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_PARTICIPANT_LIST.equals(theEvent.getPropertyName())) {
            myParticipantList = (List<Participant>) theEvent.getNewValue();
            createColorMap();
        }

    }

}
