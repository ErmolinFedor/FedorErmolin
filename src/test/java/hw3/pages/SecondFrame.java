package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondFrame extends BaseElements {
    private WebDriver driver;

    @FindBy(css = "img#epam-logo")
    private WebElement logo;

    public SecondFrame(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean logoExists() {
        return logo != null;
    }

    public HomePage switchToParent() {
        driver.switchTo().parentFrame();
        return new HomePage(driver);
    }
}
