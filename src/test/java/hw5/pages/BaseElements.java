package hw5.pages;

import hw5.pages.components.HeaderMenu;
import hw5.pages.components.LeftSideMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BaseElements {

    private WebDriver driver;

    private LeftSideMenu leftSideMenu;
    private HeaderMenu headerMenu;

    @FindBy(css = "[class='text-center'] a")
    private WebElement subHeaderText;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    public BaseElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        leftSideMenu = new LeftSideMenu(driver);
        headerMenu = new HeaderMenu(driver);
    }

    @Step("Navigate to Left side menu")
    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public String getPageNameText() {
        return driver.getTitle();
    }

    public String getSubHeaderText() {
        return subHeaderText.getText();
    }

    @Step("JDI GITHUB link is displayed")
    public boolean isDisplayedLink() {
        return subHeaderText.isDisplayed();
    }

    @Step("JDI GITHUB has a proper URL")
    public String getSubHeaderLink() {
        return subHeaderText.getAttribute("href");
    }

    public boolean isDisplayedLeftSection() {
        return leftSection.isDisplayed();
    }

    public boolean isDisplayedFooter() {
        return footer.isDisplayed();
    }
}
