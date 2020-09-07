package hw5.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseElements {

    private final static String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private WebDriver driver;

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



    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public void openHome() {
        driver.get(url);
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

}
