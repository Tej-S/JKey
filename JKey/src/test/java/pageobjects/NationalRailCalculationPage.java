package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testbase.Base;

import java.util.List;

/**
 * Created by Aundre.Jess
 */
public class NationalRailCalculationPage extends Base {
    @FindBy(xpath = "//*[@id='oft']/tbody")
    private WebElement resultTable;

    public NationalRailCalculationPage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public WebElement getResultTable() {
        return resultTable;
    }

    public void setResultTable(WebElement resultTable) {
        this.resultTable = resultTable;
    }

    public Boolean checkResultTable(String text) {
        if (text == null) {
            return false;
        }
        List<WebElement> allRows = resultTable.findElements(By.tagName("tr"));
        for (WebElement row : allRows) {
            List<WebElement> allCells = row.findElements(By.tagName("td"));
            for (WebElement cells : allCells) {
                if (cells.getText().contains(text)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}