package hw5.pages.components;

import hw5.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private WebElement service;


    @FindBy(css = "ul.dropdown-menu li")
    private List<WebElement> serviceSub;

    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private WebElement differentElementsPage;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(xpath = "//a[contains(text(), 'User Table')]")
    private WebElement userTableLink;

    @Step("Navigate to header, click Service")
    public void clickServiceOnHeader() {
        service.click();
    }

    @Step("get Service items")
    public String getSubServiceElements()  {
        StringBuilder sb = new StringBuilder();
        for (WebElement element : serviceSub) {
            sb.append(element.getText());
        }
        return sb.toString();
    }

    public String getExistsSubServiceElements() {
        clickServiceOnHeader();
        return getSubServiceElements();
    }

    @Step("click Different Elements Page link")
    public void differentElementLinkClick() {
        differentElementsPage.click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public DifferentElementsPage differentElementsPageClick() {
        clickServiceOnHeader();
        differentElementLinkClick();
        return new DifferentElementsPage(driver);
    }

    public String  getUserName() {
        return userNameText.getText();
    }

    public void userTableLinkClick() {
        userTableLink.click();
    }
}
