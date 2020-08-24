package hw4.pages;

import hw4.pages.components.HeaderMenu;
import hw4.pages.components.LeftSideMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseElements {

    private WebDriver driver;

    private LeftSideMenu leftSideMenu;
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        leftSideMenu = new LeftSideMenu(driver);
        headerMenu = new HeaderMenu(driver);
    }

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(className = "benefit-icon")
    private List<WebElement> imagesList;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textBelowImagesList;

    @FindBy(name = "main-title")
    private WebElement mainHeadText;

    @FindBy(name = "jdi-text")
    private WebElement jdiText;

    @FindBy(id = "second_frame")
    private WebElement secondFrame;

    @FindBy(css = "[class='text-center'] a")
    private WebElement subHeaderText;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    public String getTitle() {
        return driver.getTitle();
    }

    @Step("typing login: {name}, and password: {password}")
    public void logIn(String name, String password) {
        profilePhoto.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    public int getImgCount() {
        imagesList.size();
        return imagesList.size();
    }

    public boolean isTextBelowImages() {
        for (int i = 0; i < imagesList.size(); i++) {
            Point pointImg = imagesList.get(i).getLocation();
            Point pointText = textBelowImagesList.get(i).getLocation();
            if (pointImg.getY() > pointText.getY()) {
                return false;
            }
        }
        return true;
    }

    public String getMainText() {
        return mainHeadText.getText() + jdiText.getText();
    }

    public boolean iframeExists() {
        return secondFrame != null;
    }

    public SecondFrame moveToSecondIframe() {
        driver.switchTo().frame(secondFrame);
        return new SecondFrame(driver);
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

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
