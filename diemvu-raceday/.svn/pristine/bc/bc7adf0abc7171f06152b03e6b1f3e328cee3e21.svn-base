
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.TimeFormat;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */

public class RaceModel implements PropertyChangeEnabledRaceControls {

    /**
     * 
     */
    public static final String RACE_STARTWITH = "#RACE";

    /**
     * 
     */
    public static final String TRACK_STARTWITH = "#TRACK";

    /**
     * 
     */
    public static final String WIDTH_STARTWITH = "#WIDTH";

    /**
     * 
     */
    public static final String HEIGHT_STARTWITH = "#HEIGHT";

    /**
     * 
     */
    public static final String DISTANCE_STARTWITH = "#DISTANCE";

    /**
     * 
     */
    public static final String TIME_STARTWITH = "#TIME";

    /**
     * 
     */
    public static final String PARTICIPANTS_STARTWITH = "#PARTICIPANTS";

    /**
     * 
     */
    public static final String PARTICIPANT_STARTWITH = "#([0-9]){1,2}";

    /**
     * 
     */
    public static final String TELEMETRY_STARTWITH = "$T";

    /**
     *
     */
    public static final String LINE_CROSSING_STARTWITH = "$C";
    /**
     * 
     */
    public static final String LEADER_STARTWITH = "$L";

    /**
     * 
     */
    public static final String LEADER_TIMESTAMP = "\\d+";

    /**
     * 
     */
    public static final String COLON = ":";

    /**
     * 
     */
    public static final String LEADER_RACEID = "([0-9]){1,3}";

    /**
     * 
     */
    public static final String RACE_FORMAT = "#RACE:.*";

    /**
     * 
     */
    public static final String TRACK_FORMAT = "#TRACK:\\D+";

    /**
     * 
     */
    public static final String WIDTH_FORMAT = "#WIDTH:[0-9]";

    /**
     * 
     */
    public static final String HEIGHT_FORMAT = "#HEIGHT:[0-9]";

    /**
     * 
     */
    public static final String DISTANCE_FORMAT = "#DISTANCE:\\d+";

    /**
     * 
     */
    public static final String TIME_FORMAT = "#TIME:\\d+";

    /**
     * 
     */
    public static final String PARTICIPANTS_FORMAT = "#PARTICIPANTS:\\d+";

    /**
     * 
     */
    public static final String PARTICIPANT_FORMAT = "#[0-9][0-9]:\\D+:-?\\d+.\\d+";

    /**
     * 
     */
    public static final String TELEMETRY_FORMAT =
                    "\\$T:\\d+:([0-9]){1,3}:-?\\d+\\.([0-9]){1,2}:([0-9]){1,2}";

    /**
     * 
     */
    public static final String LINE_CROSSING_FORMAT =
                    "\\$C:\\d+:\\d+{1,2}:\\d+{1,2}:(true|false)";
    /**
     * 
     */
    public static final String LEAD_FORMAT = "\\$L:\\d+";
    /**
     * 
     */
    public static final int NUMBER_OF_HEADERS = 7;
    /**
     * 
     */
    public static final String ERROR1 = "Error loading file";
    /**
     * 
     */
    public static final String ERROR2 = "Error!";
    /**
     * 
     */
    private int myTotalTime;

    /**
     * 
     */

    private int myTime;

    /**
     * Manager for Property Change Listeners.
     */
    private PropertyChangeSupport myPcs;

    /**
     * 
     */
    private List<String> myHeaderList;

    /**
     * 
     */
    private List<Participant> myParticipants;

    /**
     * 
     */
    private List<List<Message>> myMessageList;

    /**
     * 
     */
    private List<String> myRaceInfoList;

    /**
     * 
     */
    private List<String> myUpdatedMessageList;

    /**
     * 
     */
    private List<Integer> myUnSelectedParticipants;
    /**
     * 
     */
    private String myCurrentTimeStamp = "0";
    /**
     * 
     */
    private int myTimeStampNumber;
    /**
      */
    private int myPreviousTimeStamp;

    /**
     * 
     */
    private int myNumberOfRacer;

    /**
    * 
    */
    public RaceModel() {
        myTimeStampNumber = 0;
        myPcs = new PropertyChangeSupport(this);
        createHeaderFormatList();
        myTime = 0;
        myRaceInfoList = new ArrayList<>();
        myParticipants = new ArrayList<>();
        myMessageList = new ArrayList<>();
        myUnSelectedParticipants = new ArrayList<Integer>();
        myMessageList.add(new ArrayList<Message>());
    }

    @Override
    public void advance() {
        advance(1);

    }

    @Override
    public void advance(final int theMillisecond) {

        changeTime(myTime + theMillisecond);
        getEachMessage(myTime);

    }

    /**
     * 
     * @param theTimeStamp TIMESTAMP
     */
    private void getEachMessage(final int theTimeStamp) {
        if (myPreviousTimeStamp != myTotalTime) {
            for (int i = myPreviousTimeStamp; i <= theTimeStamp; i++) {

                for (final Message m : myMessageList.get(i)) {
                    if (m.toString().startsWith(TELEMETRY_STARTWITH)) {
                        final TelemetryMessage tm = (TelemetryMessage) m;
                        if (myUnSelectedParticipants.isEmpty()) {
                            myPcs.firePropertyChange(PROPERTY_MESSAGE_CHANGE, null, m);

                        } else {
                            final int a = tm.getMyRacerID();
                            if (!myUnSelectedParticipants.contains(tm.getMyRacerID())) {
                                myPcs.firePropertyChange(PROPERTY_MESSAGE_CHANGE, null, m);
                            }
                        }
                    } else {
                        if (m.toString().startsWith(LEADER_STARTWITH)) {
                            final LeadMessage lm = (LeadMessage) m;
                            List<Integer> list = new ArrayList<>();
                            list = lm.getMyRacerIDList();
                            myPcs.firePropertyChange(PROPERTY_LEADER_BOARD, null, list);
                        }
                        myPcs.firePropertyChange(PROPERTY_MESSAGE_CHANGE, null, m);
                    }

                }
            }

            myPreviousTimeStamp = theTimeStamp;

        } else {
            myPcs.firePropertyChange(PROPERTY_END_RACE, null, myPreviousTimeStamp);
            myPreviousTimeStamp = 0;
        }

    }

    /**
     * 
     * @param theTm
     */

    @Override
    public void moveTo(final int theMillisecond) {
        if (theMillisecond < 0) {
            throw new IllegalArgumentException("");
        }
        changeTime(theMillisecond);
    }

    /**
     * Helper method to change the value of time and notify observers. Functional
     * decomposition.
     * 
     * @param theMillisecond the time to change to
     */
    private void changeTime(final int theMillisecond) {
        final int old = myTime;
        myTime = theMillisecond;
        myPcs.firePropertyChange(PROPERTY_TIME, old, myTime);
        myPcs.firePropertyChange(PROPERTY_TIMER_RUN, old, myTime);
        myPcs.firePropertyChange(PROPERTY_MOVE_SLIDER, old, myTime);
    }

    @Override
    public void toggleParticipant(final int theParticpantID, final boolean theToggle) {
        if (theToggle) {
            if (!myUnSelectedParticipants.contains(theParticpantID)) {
                myUnSelectedParticipants.add(theParticpantID);
            }

        } else {
            if (myUnSelectedParticipants.contains(theParticpantID)) {
                for (int i = 0; i < myUnSelectedParticipants.size(); i++) {
                    if (theParticpantID == myUnSelectedParticipants.get(i)) {
                        myUnSelectedParticipants.remove(i);
                    }
                }
            }
        }
    }

    /**
     * 
     */
    private void createHeaderFormatList() {
        myHeaderList = new ArrayList<>();
        myHeaderList.add(RACE_FORMAT);
        myHeaderList.add(TRACK_FORMAT);
        myHeaderList.add(WIDTH_FORMAT);
        myHeaderList.add(HEIGHT_FORMAT);
        myHeaderList.add(DISTANCE_FORMAT);
        myHeaderList.add(TIME_FORMAT);
        myHeaderList.add(PARTICIPANTS_FORMAT);
    }

    @Override
    public void loadRace(final File theRaceFile) throws IOException {
        myTotalTime = 0;
        final Scanner scanner = new Scanner(theRaceFile);
        myParticipants = new ArrayList<Participant>();
        int i = 1;
        // String regex = "#\\d+{1,3}:\\D+:-?\\d+.\\d+";
        String lead = LEAD_FORMAT;
        // String cross = "\\$C:\\d+:\\d+{1,2}:\\d+{1,2}:(true|false)";
        // String tel = "\\$T:\\d+:\\d+:-?\\d+.([0-9]){1,2}:\\d+{1,2}";
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (i <= NUMBER_OF_HEADERS) {
                final String header = myHeaderList.get(i - 1);
                if (!line.matches(header)) {
                    JOptionPane.showMessageDialog(new JPanel(), ERROR1, ERROR2,
                                                  JOptionPane.ERROR_MESSAGE);

                    break;
                }
                getRaceInfor(line);
                if (i == NUMBER_OF_HEADERS) {
                    final int thex = 14;
                    myNumberOfRacer = Integer.valueOf(line.substring(thex));
                    for (int w = 0; w < myNumberOfRacer; w++) {
                        lead = lead + ":\\d+";
                    }
                }
            } else if (i <= myNumberOfRacer + NUMBER_OF_HEADERS) {
                // if (!line.matches(regex)) {
                //
                // JOptionPane.showMessageDialog(new JPanel(), "Error loading file", "Error!",
                // JOptionPane.ERROR_MESSAGE);
                // break;
                // }
                myParticipants = new ArrayList<Participant>();
                getParticipants(theRaceFile);

            } else {
                getMessageList(line);
            }
            // } else if (!(line.matches(TELEMETRY_FORMAT) || line.matches(LEAD_FORMAT)
            // || line.matches(LINE_CROSSING_FORMAT))) {
            // JOptionPane.showMessageDialog(new JPanel(), "Error loading file", "Error!",
            // JOptionPane.ERROR_MESSAGE);
            // break;

            i++;

        }

        scanner.close();

        createUpdatedMessageList();
        // for (Participant a : myParticipants) {
        // System.out.println(a);
        // }

        myPcs.firePropertyChange(PROPERTY_RACE_INFO, null, myRaceInfoList);
        // myPcs.firePropertyChange(PROPERTY_MESSAGE_CHANGE, null, myMessageList);

    }

    /**
     * 
     * @param theLine line
     */
    private void getRaceInfor(final String theLine) {
        final short x2 = 2;
        final short x3 = 3;
        final String[] string = theLine.split(COLON);
        final String s = string[1];
        if (theLine.startsWith(RACE_STARTWITH)) {
            myRaceInfoList.add(0, s);
        }
        if (theLine.startsWith(TRACK_STARTWITH)) {
            myRaceInfoList.add(1, "Track type: " + s);
        }
        if (theLine.startsWith(TIME_STARTWITH)) {
            myTotalTime = Integer.valueOf(s);
            myRaceInfoList.add(x3, "Total time: " + TimeFormat.formatTime(myTotalTime));
            myPcs.firePropertyChange(PROPERTY_TOTAL_TIME, null, myTotalTime);
        }
        if (theLine.startsWith(DISTANCE_STARTWITH)) {
            myRaceInfoList.add(x2, "Lap distance: " + s);
        }
        if (theLine.startsWith(HEIGHT_STARTWITH)) {
            final int height = Integer.valueOf(string[1]);
            myPcs.firePropertyChange(PROPERTY_HEIGHT, null, height);
        }
        if (theLine.startsWith(WIDTH_STARTWITH)) {
            final int width = Integer.valueOf(string[1]);
            myPcs.firePropertyChange(PROPERTY_WIDTH, null, width);
        }
        if (theLine.startsWith(DISTANCE_STARTWITH)) {
            final int distance = Integer.valueOf(string[1]);
            myPcs.firePropertyChange(PROPERTY_LENGTH, null, distance);
        }
    }

    /**
     * 
     * @param theFile file
     * @throws IOException exception
     * @return All the Participants
     */
    public List<Participant> getParticipants(final File theFile) throws IOException {
        int count = 0;

        String[] participantsInfo = null;
        // Get the mount of participants
        final int participantAmount = myNumberOfRacer;
        final Scanner input = new Scanner(theFile);
        String currentLine = "";
        while (input.hasNextLine() && count < participantAmount) {
            currentLine = input.nextLine();
            if (currentLine.matches(PARTICIPANT_FORMAT)) {
                participantsInfo = currentLine.split(COLON);
                // myParticipant = new ArrayList<>();
                final Participant participant =
                                new Participant(participantsInfo[0].substring(1),
                                                participantsInfo[1], participantsInfo[2]);
                myParticipants.add(participant);
                count++;
            }
        }
        input.close();
        myPcs.firePropertyChange(PROPERTY_PARTICIPANT_LIST, null, myParticipants);
        return myParticipants;

    }

    /**
     * 
     * @param theLine line
     */
    private void getMessageList(final String theLine) {
        // if (!(currentLine.matches(TELEMETRY_FORMAT) || currentLine.matches(LEAD_FORMAT)
        // || currentLine.matches(LINE_CROSSING_FORMAT))) {
        // .showMessageDialog(new JPanel(), "Error loading file", "Error!",
        // JOptionPane.ERROR_MESSAGE);
        // }

        final int x3 = 3;
        final int x4 = 4;
        final String[] p = theLine.split(COLON);
        final String timeStamp = p[1];
        // myMessageList.add(new ArrayList<Message>());

        checkTimeStamp(myCurrentTimeStamp, timeStamp);
        // int IntegerCurrentTimeStamp = Integer.valueOf(myCurrentTimeStamp);
        if (theLine.startsWith(LEADER_STARTWITH)) {
            final List<Integer> l = new ArrayList<>();
            for (int i = 2; i < p.length; i++) {
                l.add(Integer.valueOf(p[i]));
            }

            final LeadMessage message =
                            new LeadMessage(p[0].substring(1), Integer.valueOf(p[1]), l);
            myPcs.firePropertyChange(PROPERTY_LEADER_BOARD, null, l);
            myMessageList.get(myTimeStampNumber).add(message);
        }
        if (theLine.matches(TELEMETRY_FORMAT)) {

            final TelemetryMessage message =
                            new TelemetryMessage(p[0].substring(1), Integer.valueOf(p[1]),
                                                 Integer.valueOf(p[2]), Double.valueOf(p[x3]),
                                                 Integer.valueOf(p[x4]));
            myMessageList.get(myTimeStampNumber).add(message);
        }
        if (theLine.matches(LINE_CROSSING_FORMAT)) {
            final CrossMessage message =
                            new CrossMessage(p[0].substring(1), Integer.valueOf(p[1]),
                                             Integer.valueOf(p[2]), Integer.valueOf(p[x3]),
                                             Boolean.valueOf(p[x4]));
            myMessageList.get(myTimeStampNumber).add(message);

        }

    }

    /**
     * 
     * @param theOldTimeStamp nothing
     * @param theNewTimeStamp nothing
     */
    private void checkTimeStamp(final String theOldTimeStamp, final String theNewTimeStamp) {
        if (!theOldTimeStamp.equals(theNewTimeStamp)) {
            myMessageList.add(new ArrayList<Message>());
            myTimeStampNumber++;
            myCurrentTimeStamp = theNewTimeStamp;
        }
    }

    /**
     * 
     */
    private void createUpdatedMessageList() {
        final String s = "Load file: Start - This may take a while. Please be patient.";
        myUpdatedMessageList = new ArrayList<>();
        myUpdatedMessageList.add(s);
        myUpdatedMessageList.add("Load file: Race information loaded.");
        myUpdatedMessageList.add("Load file: Loading telemetry information");
        myUpdatedMessageList.add("Load file: Still loading...");
        myUpdatedMessageList.add("Load file: Complete!");
        myPcs.firePropertyChange(PROPERTY_LOADING_MESSAGES, null, myUpdatedMessageList);
    }

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);
    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(theListener);
    }

    @Override
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(thePropertyName, theListener);

    }

    @Override
    public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(thePropertyName, theListener);

    }
}
