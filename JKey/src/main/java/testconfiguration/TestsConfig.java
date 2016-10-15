package testconfiguration;

import testbase.Browser;
import testconfiguration.properties.PropertiesLoader;
import testconfiguration.properties.Property;
import testconfiguration.properties.PropertyFile;

/**
 * Created by Aundre.Jess
 */

@PropertyFile("browser.properties")
public class TestsConfig {

    private static TestsConfig config;
    @Property("browser.name")
    private String browser = "Chrome";
    @Property("browser.version")
    private String version = "";

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

    public String getBrowserVersion() {
        return version;
    }

}
