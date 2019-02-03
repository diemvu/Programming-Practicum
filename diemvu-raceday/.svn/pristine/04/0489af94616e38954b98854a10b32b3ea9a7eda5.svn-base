
package controller;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_LOADING_MESSAGES;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_PARTICIPANT_LIST;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_RACE_INFO;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;
//import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIMER_END;
//import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIMER_END;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TOTAL_TIME;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_MESSAGE_CHANGE;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIMER_RUN;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_END_RACE;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.Timer;
import model.Message;
import model.Participant;
import model.PropertyChangeEnabledRaceControls;
import model.RaceModel;
import view.GraphicFrame;
import view.TimeFormat;
import view.TimePanel;
import view.TrackPanel;

/**
 * 
 * @author diemvu
 * @version Autumn 2018
 */
public class Controller extends JPanel implements PropertyChangeListener {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8452917670991316606L;

    /** Amount in Pixels for the Horizontal margin. */
    private static final int COLUM = 50;

    /** Amount in Pixels for the Vertical margin. */
    private static final int ROW = 10;

    /** Amount of milliseconds between each call to the timer. */
    private static final int TIMER_FREQUENCY = 30;
    /**
     * 
     */
    private static final int MINOR_TICK_SPACE = 500;

    /** Start text for the start/stop button. */
    private static final String BUTTON_ICON_PLAY = "./images/ic_play.png";

    /** Stop text for the start/stop button. */
    private static final String BUTTON_ICON_PAUSE = "./images/ic_pause.png";

    /** Start text for the start/stop button. */
    private static final String BUTTON_ICON_TIMEONE = "./images/ic_one_times.png";

    /** Stop text for the start/stop button. */
    private static final String BUTTON_ICON_TIMEFOUR = "./images/ic_four_times.png";
    /** Start text for the start/stop button. */

    /** Start text for the start/stop button. */
    private static final String BUTTON_ICON_SINGLE = "./images/ic_repeat.png";

    /** Start text for the start/stop button. */
    private static final String BUTTON_ICON_LOOPRACE = "./images/ic_repeat_color.png";
 
    /** reStart icon for the restart button. */
    private static final String BUTTON_ICON_RESTART = "./images/ic_restart.png";
    /**
     * 
     */
    private static final String BUTTON_ICON_CLEAR = "./images/ic_clear.png";
    /**
     * 
     */
    private static final Dimension DIMENSION = new Dimension(630, 340);
    /**
     * 
     */
    private static final Dimension DIMENSION1 = new Dimension(380, 40);
    /**
     * 
     */
    private static final int FRAMEX = 400;
    /**
     * 
     */
    private static final int FRAMEY = 200;
    /** Value for fast multiplier. */
    private static final int SPEED_FAST = 4;
    /** Padding for the border around the label. */
    private static final int SPEED_SLOW = 1;
    /**
     * 
     */
    private static final String S = "\n";
    /**
     * 
     */
    private static final int TIME_FREQUENCY = 30;
    /**
     * 
     */
    private static RaceModel myRaceModel = new RaceModel();

    

    /** The Color object this class controls. */
    // private final TimeControls myTime;

    /** The timer to control how often to advance the Time object. */
    private Timer myTimer;

    /**
     * 
     */

    /**
     * 
     */
    private List<Action> myControlActions;
    /**
     * 
     */
    private List<Action> myFileActions;
    /**
     * 
     */
    private List<Action> myHelpActions;
    /**
     * 
     */
    private JFileChooser myFileChooser;
    /**
     * 
     */
    private String myInfo;
    /**
     * 
     */
    private List<JCheckBox> myCheckBox;

    /** The time multiplier. */
    private int myMutiplier = 1;
    // private RaceControls myRace;
    /**
     * 
     */
    private JTabbedPane myTabbedPane;
    /**
     * 
     */
    private JTextArea myTextArea;
    /**
     * 
     */
    private TimePanel myTimerLabel;
    /**
     * 
     */
    private JMenuBar myMenuBar;
    /**
     * 
     */
    private JSlider mySlider;
    /**
     * 
     */
    private JToolBar myToolBar;
    /**
     * 
     */
    private JPanel myCheckPanel;
    /**
     * 
     */
    private JPanel myMainPanel;
    /**
     * 
     */
    private JCheckBox myCheckAll;
    // private JFrame myFrame;
    /**
     * 
     */
    private int myTotalTime;
    /**
     * 
     */
    private String myRaceInfor;
    // /**
    // *
    // */
    // private List<List<Message>> myMessageList;

    /**
     * 
     */
    private List<Participant> myParticipantsList;
    /**
     * 
     */
    private boolean myLoopMode;
    /**
     * 
     */
    private JMenu myFile;
    /**
     * 
     */
    private JMenu myControll;
    /**
     * 
     */
    private JMenu myHelp;

    private PropertyChangeEnabledRaceControls time;

    /**
     * 
     */
    private ToggleAction myPlayAction;
    // private ToggleAction myPlayPause;
    /**
     * 
     */
    public Controller() {

        myTimer = new Timer(TIME_FREQUENCY, this::handleTimer);
        myParticipantsList = new ArrayList<>();
        // myTime = new RaceModel();
        myRaceInfor = "";
        myLoopMode = false;
        myCheckBox = new ArrayList<>();
        myCheckAll = new JCheckBox("Select all", true);
        myCheckPanel = new JPanel();
    }

    // private void addPropertyChangeListener() {
    //
    // // myRaceModel.addPropertyChangeListener(PROPERTY_UPDATE_MESSAGES, controller);
    //
    // }
    /**
     * 
     */
    public void createAndShowGUI() {
        final JFrame frame = new JFrame("Race Day");

        final Controller controller = new Controller();
        myTimerLabel = new TimePanel();
        myRaceModel.addPropertyChangeListener(PROPERTY_LOADING_MESSAGES, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_RACE_INFO, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_TIME, myTimerLabel);
        myRaceModel.addPropertyChangeListener(PROPERTY_TOTAL_TIME, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_PARTICIPANT_LIST, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_TIMER_RUN, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_MESSAGE_CHANGE, controller);
        myRaceModel.addPropertyChangeListener(PROPERTY_END_RACE, controller);
        controller.createComponents();

        myMainPanel = new JPanel();
        myMainPanel.setLayout(new BorderLayout());
        final JPanel subPanel1 = new JPanel();
        subPanel1.add(controller.createSlider());
        subPanel1.add(myTimerLabel);

        myMainPanel.add(controller.createTabbedPane(), BorderLayout.CENTER);
        frame.add(subPanel1, BorderLayout.NORTH);
        frame.setJMenuBar(controller.createMenuBar());
        frame.add(myMainPanel, BorderLayout.CENTER);

        frame.add(controller.createToolBar(), BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setSize(DIMENSION);
        frame.setLocation(FRAMEX, FRAMEY);
        frame.setResizable(false);
      //final TrackPanel trackPanel = new TrackPanel();
//      time.addPropertyChangeListener(model.PropertyChangeEnabledRaceControls.PROPERTY_TIME,
//                                     trackPanel);
//        final GraphicFrame timeViewFrame = new GraphicFrame(myRaceModel);
//        //timeViewFrame.setContentPane(trac);
//        timeViewFrame.pack();
//        timeViewFrame.setVisible(true);
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              //final JFrame frame = new JFrame("Race Track");
              final GraphicFrame timeViewFrame = new GraphicFrame(myRaceModel);
              //timeViewFrame.setContentPane(trac);
              timeViewFrame.pack();
              timeViewFrame.setVisible(true);
          }
      });

    }

    /**
     * 
     */
    private void createComponents() {

        createActions();
        createMenuBar();
        createToolBar();
        createTabbedPane();
        createSlider();
        createTimer();
    }

    /**
     */
    private void createActions() {
        createFileActions();
        createControlActions();
        createHelpActions();
    }

    /**
     * 
     */
    private void createFileActions() {
        myFileActions = new ArrayList<>();
        final NonToggleAction loadRace =
                        new NonToggleAction("Load Race...", null, () -> loadRace());
        final NonToggleAction exit = new NonToggleAction("Exit", null, () -> System.exit(0));
        myFileActions.add(loadRace);
        myFileActions.add(exit);

    }

    /**
     * 
     */
    private void createControlActions() {
        myControlActions = new ArrayList<>();
        final NonToggleAction restart =
                        new NonToggleAction("Restart", BUTTON_ICON_RESTART, () -> restart());
        myPlayAction =
                        new ToggleAction("Play", "Pause", BUTTON_ICON_PLAY, BUTTON_ICON_PAUSE,
                            () -> myTimer.start(), () -> myTimer.stop());
        
        myPlayAction.addPropertyChangeListener(new PropertyChangeListener() {
            
            @Override
            public void propertyChange(final PropertyChangeEvent theEvt) {
                if (!myTimer.isRunning()) {
                    mySlider.setEnabled(true);
                } else {
                    mySlider.setEnabled(false);
                }
                
            }
        });
        final ToggleAction timesOneFour =
                        new ToggleAction("Times One", "Times Four", BUTTON_ICON_TIMEONE,
                                         BUTTON_ICON_TIMEFOUR, () -> myMutiplier = SPEED_FAST,
                            () -> myMutiplier = SPEED_SLOW);
        final ToggleAction singleRace =
                        new ToggleAction("Single Race", "Loop Race", BUTTON_ICON_SINGLE,
                                         BUTTON_ICON_LOOPRACE, () -> myLoopMode = true,
                            () -> myLoopMode = false);
       
        final NonToggleAction clear =
                        new NonToggleAction("Clear", BUTTON_ICON_CLEAR, () -> clear());
        myControlActions.add(restart);
        myControlActions.add(myPlayAction);
        myControlActions.add(timesOneFour);
        myControlActions.add(singleRace);
        myControlActions.add(clear);
    }

    /**
     * 
     */
    private void clear() {

        myTextArea.setText("");
    }

    /**
     * 
     */
    private void showMyInfo() {

        myInfo = "";
        myInfo = myInfo + "Diem Vu" + S + "Autumn 2018" + S + "TCSS 305 Assignment 5";

        JOptionPane.showMessageDialog(new JPanel(), myInfo, "About",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Event handler for the timer.
     * 
     * @param theEvent the fired event
     */
    private void handleTimer(final ActionEvent theEvent) { // NOPMD
        myRaceModel.advance(TIMER_FREQUENCY * myMutiplier);

    }

    /**
     * 
     */
    private void createHelpActions() {
        myHelpActions = new ArrayList<>();
        final NonToggleAction raceInfor =
                        new NonToggleAction("Race Info...", null, () -> showRaceInfo());
        final NonToggleAction about =
                        new NonToggleAction("About...", null, () -> showMyInfo());
        myHelpActions.add(raceInfor);
        myHelpActions.add(about);

    }

    /**
     * 
     * @return menuBar
     */
    private JMenuBar createMenuBar() {
        myMenuBar = new JMenuBar();
        myFile = new JMenu("File");
        for (final Action action : myFileActions) {

            myFile.add(new JMenuItem(action));
        }
        myFile.insertSeparator(1);

        // create Control menu
        myControll = new JMenu("Controls");
        for (final Action action : myControlActions) {
            final JMenuItem menuItem = new JMenuItem(action);
            menuItem.setEnabled(false);
            myControll.add(menuItem);
        }

        // create Help Menu
        myHelp = new JMenu("Help");
        for (final Action a : myHelpActions) {
            myHelp.add(new JMenuItem(a));
        }
        myHelp.getMenuComponent(0).setEnabled(false);
        myFile.getMenuComponent(2).setEnabled(false);
        myMenuBar.add(myFile);
        myMenuBar.add(myControll);
        myMenuBar.add(myHelp);
        return myMenuBar;

    }

    /**
     * 
     * @return Tool bar
     */
    private JToolBar createToolBar() {
        myToolBar = new JToolBar();
        for (final Action action : myControlActions) {
            final JButton butt = new JButton(action);
            butt.setHideActionText(true);
            butt.setEnabled(false);
            myToolBar.add(butt);
        }
        // setButtonEnable(false);
        return myToolBar;
    }

    /**
     * 
     * @param theEnable boolean value
     */
    private void setComponentEnable(final boolean theEnable) {
        for (Component cp : myToolBar.getComponents()) {
            cp.setEnabled(theEnable);
        }
        for (Component menu : myFile.getMenuComponents()) {
            menu.setEnabled(theEnable);

        }
        for (Component menu : myControll.getMenuComponents()) {
            menu.setEnabled(theEnable);

        }
        for (Component menu : myHelp.getMenuComponents()) {
            menu.setEnabled(theEnable);

        }
    }

    /**
     * 
     * @return slider
     */
    private JSlider createSlider() {
        mySlider = new JSlider(0, myTotalTime);
        mySlider.setPreferredSize(DIMENSION1);
        mySlider.setPaintTicks(true);
        mySlider.setPaintTrack(true);

        mySlider.setMinimum(0);
        mySlider.setValue(0);
        mySlider.addChangeListener(theEvt -> myRaceModel.moveTo(mySlider.getValue()));
      //  mySlider.setMajorTickSpacing(_TICK_SPACE);
        mySlider.setMinorTickSpacing(MINOR_TICK_SPACE);
        mySlider.setEnabled(false);
        return mySlider;
    }

    /**
     * 
     * @return TimePanel
     */
    private TimePanel createTimer() {
        // myTimer = new Timer(TIME_FREQUENCY, this::handleTimer);
        myTimerLabel = new TimePanel();
        return myTimerLabel;
    }

    /**
     * 
     * @return JTabbedPane
     */
    private JTabbedPane createTabbedPane() {
        myTabbedPane = new JTabbedPane();
        myTextArea = new JTextArea();
        myTextArea.setText("");
        myTextArea.setEditable(false);
        myTextArea.setColumns(COLUM);
        myTextArea.setRows(ROW);

        final JScrollPane scrollPane =
                        new JScrollPane(myTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        final JScrollPane checkBoxScroll =
                        new JScrollPane(myCheckPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myTabbedPane.addTab("Data Output Stream", scrollPane);
        myTabbedPane.addTab("Race Paticipants", checkBoxScroll);

        return myTabbedPane;
    }

    /**
     * 
     * @return List<JCheckBox>
     */
    private List<JCheckBox> createCheckBox() {

        myCheckBox = new ArrayList<>();
        myCheckBox.add(myCheckAll);
        myCheckAll.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(final ItemEvent theEvent) {
                for (JCheckBox b : myCheckBox) {
                    if (theEvent.getStateChange() == 1) {

                        b.setSelected(true);

                    } else {
                        b.setSelected(false);
                    }
                }
            }
        });
        for (Participant p : myParticipantsList) {
            final JCheckBox aCheckBox = new JCheckBox(p.getMyRacerName(), true);
            aCheckBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(final ItemEvent theEvent) {
                    if (theEvent.getStateChange() == 1) {
                        myRaceModel.toggleParticipant(Integer.valueOf(p.getMyRacerID()),
                                                      false);
                    } else {
                        myRaceModel.toggleParticipant(Integer.valueOf(p.getMyRacerID()), true);
                    }
                }
            });
            myCheckBox.add(aCheckBox);
        }

        return myCheckBox;
    }

    /**
     * 
     */
    private void loadRace() {
        myFileChooser = new JFileChooser();
        myFileChooser.setCurrentDirectory(new File("./race_files"));
        final int x = myFileChooser.showOpenDialog(this);
        final File file = myFileChooser.getSelectedFile();
        if (x == JFileChooser.APPROVE_OPTION) {
            try {
                myRaceModel.loadRace(file);

            } catch (final IOException e) {
               
                e.printStackTrace();
            }
        }
        // setMenuEnable(true);
        setComponentEnable(true);

    }

    /**
     * 
     */
    private void restart() {
        myTimerLabel.setText(TimeFormat.formatTime(0));
        myTimer.setInitialDelay(0);
        mySlider.setValue(0);
        myTimer.start();

    }

    /**
     * 
     */
    private void showRaceInfo() {
        JOptionPane.showMessageDialog(new JPanel(), myRaceInfor, "Race Information",
                                      JOptionPane.INFORMATION_MESSAGE);

    }
    /**
     * 
     * @param theEvt event
     */
    @SuppressWarnings("unchecked")
    private void check(final PropertyChangeEvent theEvt) {
        if (PROPERTY_RACE_INFO.equals(theEvt.getPropertyName())) {
            final List<String> raceInfor = (List<String>) theEvt.getNewValue();

            for (String string : raceInfor) {
                myRaceInfor = myRaceInfor + string + S;
            }

        }
        if (PROPERTY_PARTICIPANT_LIST.equals(theEvt.getPropertyName())) {
            myParticipantsList = (List<Participant>) theEvt.getNewValue();
            createCheckBox();
            myCheckPanel.removeAll();
            myCheckPanel.setLayout(new GridLayout(myParticipantsList.size() + 1, 1));

            for (JCheckBox aCheckBox : myCheckBox) {
                myCheckPanel.add(aCheckBox);
            }
            //myCheckPanel = new JPanel();
        }

        if (PROPERTY_TOTAL_TIME.equals(theEvt.getPropertyName())) {
            myTotalTime = (int) theEvt.getNewValue();
            mySlider.setMaximum(myTotalTime);
            mySlider.setEnabled(true);

        }

    }
    @SuppressWarnings("unchecked")
    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if (PROPERTY_LOADING_MESSAGES.equals(theEvt.getPropertyName())) {
            final List<String> updateMessages = (List<String>) theEvt.getNewValue();
            myTextArea.setText("");
            for (String a : updateMessages) {
                myTextArea.append(a + S);
            }
        }
        check(theEvt);

        if (PROPERTY_TIMER_RUN.equals(theEvt.getPropertyName())) {
            final int sliderMoveTo = (Integer) theEvt.getNewValue();
            mySlider.setValue(sliderMoveTo);
        }
        if (PROPERTY_MESSAGE_CHANGE.equals(theEvt.getPropertyName())) {
        
            final Message message = (Message) theEvt.getNewValue();
            myTextArea.append(message.toString() + S);
        }
        if (PROPERTY_END_RACE.equals(theEvt.getPropertyName())) {
            final int endRace = (Integer) theEvt.getNewValue();
            if (endRace == myTotalTime) {
                if (myLoopMode) {
                    restart();
                } else {
                    myTimer.stop();
                    myPlayAction.actionPerformed(null);
                }
            }

        }

    }
}
