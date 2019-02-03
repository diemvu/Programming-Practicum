
package view;

import java.text.DecimalFormat;

/**
 * 
 * @author diemvu
 * @version fall 2018
 */
public class TimeFormat {
    /** The separator for formatted. */
    public static final String SEPARATOR = ":";

    /** The number of milliseconds in a second. */
    public static final int MILLIS_PER_SEC = 1000;

    /** The number of seconds in a minute. */
    public static final int SEC_PER_MIN = 60;

    /** The number of minute in a hour. */
    public static final int MIN_PER_HOUR = 60;

    /** A formatter to require at least 1 digit, leading 0. */
    public static final DecimalFormat ONE_DIGIT_FORMAT = new DecimalFormat("0");

    /** A formatter to require at least 2 digits, leading 0s. */
    public static final DecimalFormat TWO_DIGIT_FORMAT = new DecimalFormat("00");

    /** A formatter to require at least 3 digits, leading 0s. */
    public static final DecimalFormat THREE_DIGIT_FORMAT = new DecimalFormat("000");

    /**
     * 
     * @param theTime time
     * @return string
     */
    public static String formatTime(final long theTime) {
        long time = theTime;
        final long milliseconds = time % MILLIS_PER_SEC;
        time /= MILLIS_PER_SEC;
        final long seconds = time % SEC_PER_MIN;
        time /= SEC_PER_MIN;
        final long min = time % MIN_PER_HOUR;
        time /= MIN_PER_HOUR;
        return TWO_DIGIT_FORMAT.format(min) + SEPARATOR + TWO_DIGIT_FORMAT.format(seconds)
               + SEPARATOR + THREE_DIGIT_FORMAT.format(milliseconds);
    }
}
