package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aundre.Jess
 */
public class TimeUtility {
    public static void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("smsmddMMYYYY");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
