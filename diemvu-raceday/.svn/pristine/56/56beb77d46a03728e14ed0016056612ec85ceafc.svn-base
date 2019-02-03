
package model;

/**
 * 
 * @author diemvu
 * @version Fall 2018
 */
public class CrossMessage extends AbstractMessage {
    /**
     * 
     */
    private static String CROSS = "$C";
    /**
     * 
     */
    private int myRacerID;
    /**
     * 
     */
    private int myLap;
    /**
     * 
     */
    private boolean myIsFinished;

    /**
     * @param theMessageType Type
     * @param theTimeStamp Type
     * @param theRacerID Type
     * @param theLap Type
     * @param theFinished Type
     */
    public CrossMessage(final String theMessageType, final int theTimeStamp,
                        final int theRacerID, final int theLap, final boolean theFinished) {
        super(CROSS, theTimeStamp);
        this.myRacerID = theRacerID;
        this.myLap = theLap;
        this.myIsFinished = theFinished;
    }

    /**
     * @return the myRacerID
     */
    public int getMyRacerID() {
        return myRacerID;
    }

    /**
     * @param theRacerID the myRacerID to set
     * 
     */
    public void setMyRacerID(final int theRacerID) {
        this.myRacerID = theRacerID;
    }

    /**
     * @return the myLap
     */
    public int getMyLap() {
        return myLap;
    }

    /**
     * @param theLap the myLap to set
     */
    public void setMyLap(final int theLap) {
        this.myLap = theLap;
    }

    /**
     * @return the isFinished
     */
    public boolean getIsFinished() {
        return myIsFinished;
    }

    /**
     * @param theFinished the isFinished to set
     */
    public void setIsFinished(final boolean theFinished) {
        this.myIsFinished = theFinished;
    }
    // $C:617331:30:10:true

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String c = ":";
        return CROSS + c + this.getTimeStamp() + c + myRacerID + c + myLap + c + myIsFinished;
    }

}
