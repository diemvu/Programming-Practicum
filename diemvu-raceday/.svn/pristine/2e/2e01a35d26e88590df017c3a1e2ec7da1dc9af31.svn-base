
package model;

import java.beans.PropertyChangeListener;

/**
 * Defines behaviors allowing PropertyChangeListeners to be added or removed from a
 * RaceControls object. Implementing classes should inform PropertyChangeListeners when methods
 * defined in RaceControls mutate the state of the Race.
 * 
 * Defines a set of Properties that may be listened too. Implementing class may further define
 * more Properties.
 * 
 * @author Charles Bryan
 * @version Fall 2018
 *
 */
public interface PropertyChangeEnabledRaceControls extends RaceControls {

    /*
     * Add your own constant Property values here.
     */

    /**
     * A property name for an example. Use this as a template for your own Property values.
     */
    String PROPERTY_EXAMPLE = " THIS IS AN EXAMPLE";

    /**
     * A property name for the current time step in the simulation.
     */
    String PROPERTY_TIME = "the time step";
    /**
     * 
     */
    String PROPERTY_TOTAL_TIME = "the total time";
    /**
     * 
     */
    String PROPERTY_RACE_INFO = "race info";
    /**
     * 
     */
    String PROPERTY_LOADING_MESSAGES = "update messages";
    /**
     * 
     */
    String PROPERTY_LEADER_BOARD = "leading racer";
    /**
     * 
     */
    String PROPERTY_MOVE_SLIDER = "update slider";
    /**
     * 
     */
    String PROPERTY_PARTICIPANT_LIST = "update participants list";
    /**
     * 
     */
    String PROPERTY_TIMER_RUN = " slider move when timer run";
    /**
     * 
     */
    String PROPERTY_MESSAGE_CHANGE = " update message List";
    /**
     * 
     */
    String PROPERTY_END_RACE = " end of race";
    /**
     * 
     */
    String PROPERTY_COLOR_LIST = "create a list of color for participant";
    /**
     * 
     */
    String PROPERTY_HEIGHT = "race height";
    /**
     * 
     */
    String PROPERTY_WIDTH = " race width";
    /**
     * 
     */
    String PROPERTY_LENGTH = " race length";

    /**
     * Add a PropertyChangeListener to the listener list. The listener is registered for all
     * properties. The same listener object may be added more than once, and will be called as
     * many times as it is added. If listener is null, no exception is thrown and no action is
     * taken.
     * 
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Add a PropertyChangeListener for a specific property. The listener will be invoked only
     * when a call on firePropertyChange names that specific property. The same listener object
     * may be added more than once. For each property, the listener will be invoked the number
     * of times it was added for that property. If propertyName or listener is null, no
     * exception is thrown and no action is taken.
     * 
     * @param thePropertyName The name of the property to listen on.
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(String thePropertyName, PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener from the listener list. This removes a
     * PropertyChangeListener that was registered for all properties. If listener was added
     * more than once to the same event source, it will be notified one less time after being
     * removed. If listener is null, or was never added, no exception is thrown and no action
     * is taken.
     * 
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener for a specific property. If listener was added more than
     * once to the same event source for the specified property, it will be notified one less
     * time after being removed. If propertyName is null, no exception is thrown and no action
     * is taken. If listener is null, or was never added for the specified property, no
     * exception is thrown and no action is taken.
     * 
     * @param thePropertyName The name of the property that was listened on.
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(String thePropertyName,
                                      PropertyChangeListener theListener);
}
