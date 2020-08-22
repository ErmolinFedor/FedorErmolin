package hw3.pages.components;

import hw3.pages.DifferentElementsPage;
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

    public String getExistsSubServiceElements() {
        service.click();
        StringBuilder sb = new StringBuilder();
        for (WebElement element : serviceSub) {
            sb.append(element.getText());
        }
        return sb.toString();
    }

    public DifferentElementsPage differentElementsPageClick() {
        service.click();
        differentElementsPage.click();
        return new DifferentElementsPage(driver);
    }
}
