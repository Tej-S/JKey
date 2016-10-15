package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import testconfiguration.TestsConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aundre.Jess
 */
public class DriverFactory {

    private static final long IMPLICIT_WAIT_TIMEOUT = 10;
    private static WebDriver driver;

    public static WebDriver getBrowserDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. "
                    + "Please call DriverFactory.startBrowser() before use this method");
        }
    }

    public static void startBrowser(boolean isLocal) throws MalformedURLException {

        if (driver == null) {
            Browser browser = TestsConfig.getConfig().getBrowser();
            if (!isLocal) {
                // example, use real key and secret
                driver = new RemoteWebDriver(new URL("http://key:secret@hub.testingbot.com/wd/hub"),
                        Capabilities.getDefaultCapabilities(browser));
            } else {
                switch (browser) {
                    case FIREFOX:
                        driver = new FirefoxDriver(Capabilities.getDefaultCapabilities(Browser.FIREFOX));
                        break;
                    case CHROME:
                        driver = new ChromeDriver(Capabilities.getDefaultCapabilities(Browser.CHROME));
                        break;
                    case IE10:
                        driver = new InternetExplorerDriver(Capabilities.getDefaultCapabilities(Browser.IE10));
                        break;
                    case SAFARI:
                        driver = new SafariDriver(Capabilities.getDefaultCapabilities(Browser.SAFARI));
                        break;
                    default:
                        throw new IllegalStateException("Please enter a valid browser");
                }
            }
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        } else {
            throw new IllegalStateException("Quit driver before using this method");
        }
    }

    public static void stopBrowserDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
