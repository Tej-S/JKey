package testrunner;

import excelhandler.ExcelHandler;
import excelhandler.ExcelKeywordReader;
import excelhandler.KeywordExecutorUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static testbase.DriverFactory.startBrowser;
import static testbase.DriverFactory.stopBrowserDriver;


public class TestRunner {
    private KeywordExecutorUtility keywordExecutorClass;
    private ExcelHandler excelSheetClass;
    private String testKeywords;
    private String excelTestSheet;
    private ExcelKeywordReader keywordReader;

    @Before
    public void setUp() throws MalformedURLException {
        startBrowser(true);
        keywordExecutorClass = new KeywordExecutorUtility();
        excelSheetClass = new ExcelHandler();
        keywordReader = new ExcelKeywordReader();
    }

    @Test
    public void TestRun() {
        testKeywords = "keywords.NationalRailKeywords";
        excelTestSheet = "test.xls";

        keywordReader.executeKeywords(excelSheetClass, keywordExecutorClass, excelTestSheet, testKeywords);
    }

    @After
    public void tearDown() {
        stopBrowserDriver();
    }
}
