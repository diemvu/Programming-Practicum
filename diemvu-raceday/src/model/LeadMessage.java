
package model;

import java.util.List;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class LeadMessage extends AbstractMessage {
    /**
     * 
     */
    private static String LEAD = "$L";
    /**
     * 
     */
    private static String C = ":";
    /**
     * 
     */
    private List<Integer> myRacerIDList;

    /**
     * 
     * @param theMessageType diem
     * @param theTimeStamp diem
     * @param theRacerIDList diem
     */
    public LeadMessage(final String theMessageType, final int theTimeStamp,
                       final List<Integer> theRacerIDList) {
        super(LEAD, theTimeStamp);
        myRacerIDList = theRacerIDList;
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the myRacerIDList
     */
    public List<Integer> getMyRacerIDList() {
        return myRacerIDList;
    }

    /**
     * @param theRacerIDList the myRacerIDList to set
     */
    public void setMyRacerIDList(final List<Integer> theRacerIDList) {
        this.myRacerIDList = theRacerIDList;
    }

    // $L:0:32:67:35:42:09:46:41:55:75:30
    /**
     * 
     * @return racerIDs
     */
    private String getRacerIDS() {
        String s = "";
        for (Integer racerID : myRacerIDList) {
            s = s + C + racerID;
        }
        return s.substring(1);
    }

    @Override
    public String toString() {
      
        return LEAD + C + getTimeStamp() + C + getRacerIDS();

    }

}
