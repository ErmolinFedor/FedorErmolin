package hw4.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class RightSideBar {
    private WebDriver driver;

    @FindBy(name = "log-sidebar")
    private WebElement logSidebar;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private List<WebElement> bodyLog;

    public RightSideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Step("Is Right Section displayed")
    public boolean isDisplayedRightSection() {
        return logSidebar.isDisplayed();
    }

    @Step("Get status from log row.")
    public HashMap<String, String> getSelectedFromLog(int count) {
        HashMap<String, String> res = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] ss = bodyLog.get(i).getText().split(" ");
            if (!ss[ss.length - 1].equalsIgnoreCase("false")) {
                res.put(ss[1].substring(0, ss[1].length() - 1), ss[ss.length - 1]);
            }

        }
        return res;
    }
}
