package hw5.context;

import org.openqa.selenium.WebDriver;

public class Context {

    private static Context instance;
    private WebDriver driver;

    private Context() {
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
