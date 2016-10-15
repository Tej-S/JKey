package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testbase.Base;

/**
 * Created by Aundre.Jess
 */
public class NationalRailHomePage extends Base {
    private static final String PAGE_URL = "http://ojp.nationalrail.co.uk/service/planjourney/search";
    @FindBy(id = "txtFrom")
    private WebElement txtFromElement;
    @FindBy(id = "txtTo")
    private WebElement txtToElement;
    @FindBy(id = "go")
    private WebElement goButtonElement;
    @FindBy(className = "ctf-title")
    private WebElement titleElement;

    public NationalRailHomePage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return txtToElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterTextFrom(String text) {
        txtFromElement.sendKeys(text);
    }

    public void enterTextTo(String text) {
        txtToElement.sendKeys(text);
    }

    public NationalRailCalculationPage selectGo() {
        goButtonElement.click();
        return new NationalRailCalculationPage();
    }
}
