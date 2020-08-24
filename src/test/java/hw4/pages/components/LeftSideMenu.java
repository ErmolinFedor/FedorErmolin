package hw4.pages.components;

import hw4.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftSideMenu {
    private WebDriver driver;

    public LeftSideMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "navigation-sidebar")
    private WebElement navigationSideBar;

    @FindBy(css = ".sidebar-menu li")
    private List<WebElement> leftItems;

    @FindBy(css = ".menu-title[index='3']")
    private WebElement service;

    @FindBy(css = ".menu-title[index='3'] .sub li")
    private List<WebElement> serviceSub;

    @FindBy(css = "[class='menu-title'] li[index='8']")
    private WebElement differentElementLink;

    public void clickService() {
        service.click();
    }

    public DifferentElementsPage clickDifferentElement() {
        differentElementLink.click();
        return new DifferentElementsPage(driver);
    }

    @Step("navigate to Left section, click service")
    private void clickServiceOnLeft() {
        service.click();
    }

    @Step("get service items")
    private String getServiceItems() {
        StringBuilder sb = new StringBuilder();
        for (WebElement element : serviceSub) {
            sb.append(element.getText());
        }
        return sb.toString();
    }

    public String getExistsSubServiceElements() {
        clickServiceOnLeft();
        return getServiceItems();
    }

    @Step("Is Displayed Left section")
    public boolean isDisplayedLeftSection() {
        return navigationSideBar.isDisplayed();
    }
}
