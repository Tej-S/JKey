package testbase;

/**
 * Created by Aundre.Jess
 */
public enum Browser {
    FIREFOX("firefox"), CHROME("chrome"), IE10("ie10"), SAFARI("safari");
    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public static Browser getByName(String name) {
        for (Browser browser : values()) {
            if (browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }

    public String getBrowserName() {
        return browserName;
    }
}
