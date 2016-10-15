package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.TimeUtility;

/**
 * Created by Aundre.Jess
 */
public abstract class Base {

    protected static final int WAIT_FOR_PAGE_TO_LOAD_IN_SECONDS = 10;

    public Base(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
        getDriver().manage().window().maximize();
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    protected abstract void openPage();

    public boolean exists(WebElement webElement) {
        for (int i = 0; i <= 30; i++) {
            try {
                if (webElement.isDisplayed()) {
                    return true;
                }
            } catch (RuntimeException e) {
            }
            TimeUtility.waitForSeconds(1);
        }
        return false;
    }

    public abstract boolean isPageOpened();

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_TO_LOAD_IN_SECONDS) {
            TimeUtility.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }

    protected WebDriver getDriver() {
        return DriverFactory.getBrowserDriver();
    }
}
