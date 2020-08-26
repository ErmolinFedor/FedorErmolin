package hw4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SecondFrame extends BaseElements {
    private WebDriver driver;

    public SecondFrame(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Switch to original window back")
    public HomePage switchToParent() {
        driver.switchTo().parentFrame();
        return new HomePage(driver);
    }
}
