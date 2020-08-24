package hw4.pages.components;

import hw4.pages.DifferentElementsPage;
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
    private void difElClick() {
        differentElementsPage.click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public DifferentElementsPage differentElementsPageClick() {
        clickServiceOnHeader();
        difElClick();
        return new DifferentElementsPage(driver);
    }
}
