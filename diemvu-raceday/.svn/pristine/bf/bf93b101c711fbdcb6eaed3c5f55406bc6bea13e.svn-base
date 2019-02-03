
package model;

/**
 * 
 * @author diemvu
 * @version fall
 */
public class TelemetryMessage extends AbstractMessage {
    /**
     * 
     */
    private static String TELEMETRY = "$T";
    /**
     * 
     */
    private int myRacerID;
    /**
     * 
     */
    private double myDistance;
    /**
     * 
     */
    private int myLap;

    /**
     * 
     * @param theMessageType n
     * @param theTimeStamp n
     * @param theRacerId n
     * @param theDistance n
     * @param theLap n
     */

    public TelemetryMessage(final String theMessageType, final int theTimeStamp,
                            final int theRacerId, final double theDistance, final int theLap) {
        super(TELEMETRY, theTimeStamp);
        myRacerID = theRacerId;
        myDistance = theDistance;
        myLap = theLap;
    }

    /**
     * @return the myRacerID
     */
    public int getMyRacerID() {
        return myRacerID;
    }

    /**
     * @param theRacerID the myRacerID to set
     */
    public void setMyRacerID(final int theRacerID) {
        this.myRacerID = theRacerID;
    }

    /**
     * @return the myDistance
     */
    public double getMyDistance() {
        return myDistance;
    }

    /**
     * @param theDistance the myDistance to set
     */
    public void setMyDistance(final int theDistance) {
        this.myDistance = theDistance;
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

    // $T:0:46:-499.84:0
    @Override
    public String toString() {
        final String c = ":";
        return TELEMETRY + c + getTimeStamp() + c + myRacerID + c + myDistance + c + myLap;

    }

}
