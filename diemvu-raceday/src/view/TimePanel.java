
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_MOVE_SLIDER;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * A demo of Observable/Observer.
 * 
 * @author Charles Bryan
 * @version Autumn 2015
 */
public class TimePanel extends JLabel implements PropertyChangeListener {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;

    /** Padding for the border around the label. */
    private static final int PADDING = 5;

    /** A label to display time. */
    // private final JLabel myLabel;

    /**
     * Construct a Time Panel.
     */
    public TimePanel() {
        super(TimeFormat.formatTime(0));

        setupComponents();
        //addPropertyChangeListener(PROPERTY_MOVE_SLIDER, this);
    }

    /**
     * Setup and layout components.
     */
    private void setupComponents() {
        setBorder(BorderFactory
                        .createCompoundBorder(BorderFactory.createEtchedBorder(),
                                              BorderFactory.createEmptyBorder(PADDING, PADDING,
                                                                              PADDING,
                                                                              PADDING)));

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            this.setText(TimeFormat.formatTime((Integer) theEvent.getNewValue()));
        }
        if (PROPERTY_MOVE_SLIDER.equals(theEvent.getPropertyName())) {
            this.setText(TimeFormat.formatTime((Integer) theEvent.getNewValue()));
        }

    }

}
