package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hw3.pages.components.LeftSideMenu;

import java.util.List;

public class BaseElements {

    private WebDriver driver;

    private LeftSideMenu leftSideMenu;

    public BaseElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        leftSideMenu = new LeftSideMenu(driver);
    }

    @FindBy(css = "img#epam-logo")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private WebElement service;

    @FindBy(css = "ul.dropdown-menu li")
    private WebElement serviceItemsLocator;

    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private WebElement differentElements;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']")
    private WebElement headerItems;

    public List<WebElement> getServiceItems() {
        return null;
    }

    public String getUserName() {
        return userNameText.getText().toUpperCase();
    }

    public String getTextHeaderItems() {
        return headerItems.getText();
    }

    public boolean logoExists() {
        return logo != null;
    }


}
