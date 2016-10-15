package testbase;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Aundre.Jess
 */
public class Capabilities {
    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return DesiredCapabilities.firefox();
            case CHROME:
                // Change Chrome path below
                Capabilities.setChromePath("\\Program Files\\chromedriver\\chromedriver.exe");
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException(
                            "System variable 'webdriver.chrome.driver' should be set to path for executable driver,"
                                    + " use the Capabilities class to set path");
                }
                return DesiredCapabilities.chrome();

            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;
            case SAFARI:
                return DesiredCapabilities.safari();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

    private static void setChromePath(final String path) {
        System.setProperty("webdriver.chrome.driver", path);
    }
}
