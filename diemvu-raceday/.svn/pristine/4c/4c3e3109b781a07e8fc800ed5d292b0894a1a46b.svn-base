
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * 
 * @author diemvu
 * @version Autumn 2018
 */
public class ToggleAction extends AbstractAction {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 1234567890L;

    /** A flag for the toggle. */
    private boolean myFlag;
    /**
     * 
     */
    private String myFirstIcon;
    /**
     * 
     */
    private String mySecondIcon;
    /**
     * 
     */
    private String myFirstText;
    /**
     * 
     */
    private String mySecondText;
    /**
     * 
     */
    private Runnable myFirstAction;
    /**
     * 
     */
    private Runnable mySecondAction;

    /**
     * 
     * @param theFirstText firstText
     * @param theSecondText firstText
     * @param theFirstIcon firstText
     * @param theSecondIcon firstText
     * @param theFirstAction firstText
     * @param theSecondAction firstText
     */
    ToggleAction(final String theFirstText, final String theSecondText,
                 final String theFirstIcon, final String theSecondIcon,
                 final Runnable theFirstAction, final Runnable theSecondAction) {
        super(theFirstText);
        myFirstIcon = theFirstIcon;
        mySecondIcon = theSecondIcon;
        myFirstText = theFirstText;
        mySecondText = theSecondText;
        myFirstAction = theFirstAction;
        mySecondAction = theSecondAction;
        setIcon(new ImageIcon(myFirstIcon));
        myFlag = false;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // Look at the text on the button. Check if it is Start or if it is Stop.
        if (myFlag) {
            mySecondAction.run();
            putValue(Action.NAME, myFirstText);
            setIcon(new ImageIcon(myFirstIcon));
        } else {
            myFirstAction.run();
            putValue(Action.NAME, mySecondText);
            setIcon(new ImageIcon(mySecondIcon));
        }
        myFlag = !myFlag;
    }

    /**
     * Helper to set the Icon to both the Large and Small Icon values.
     * 
     * @param theIcon the icon to set for this Action
     */
    private void setIcon(final ImageIcon theIcon) {
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
                        icon.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);

        final Image smallImage =
                        icon.getImage().getScaledInstance(12, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon smallIcon = new ImageIcon(smallImage);
        putValue(Action.SMALL_ICON, smallIcon);
    }
}
