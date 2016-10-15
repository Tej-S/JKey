package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testbase.DriverFactory;

public class ScreenCapture {

    public static void takeScreenShot() {
        File screenshot = ((TakesScreenshot) DriverFactory.getBrowserDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(
                    System.getProperty("user.dir") + "//screenshots//IMG-" + TimeUtility.getTimeStamp() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
