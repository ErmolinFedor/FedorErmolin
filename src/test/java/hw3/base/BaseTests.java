package hw3.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class BaseTests {
    protected WebDriver driver;
    protected Properties property = new Properties();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        try {
            property.load(
                    new InputStreamReader(
                            new FileInputStream("src/test/resources/hw3config.properties"),
                            Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
