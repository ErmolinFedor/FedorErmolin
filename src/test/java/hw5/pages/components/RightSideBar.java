package hw5.pages.components;

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

    @FindBy(css = ".panel-body-list.logs li")
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

    public HashMap<String, String> getSelectedBoxesFromLog() {
        HashMap<String, String> res = new HashMap<>();
        String  water = "Water";
        String earth = "Earth";
        String wind = "Wind";
        String fire = "Fire";
        for (WebElement element: bodyLog) {
            String[] ss = element.getText().split(" ");
            if (ss[1].startsWith(water)
                    || ss[1].startsWith(earth)
                    || ss[1].startsWith(wind)
                    || ss[1].startsWith(fire)) {
                if (!ss[ss.length - 1].equalsIgnoreCase("false")) {
                    res.put(ss[1].substring(0, ss[1].length() - 1), ss[ss.length - 1]);
                }
            }
        }
        return res;
    }

    public HashMap<String, String> getSelectedRadioFromLog() {
        HashMap<String, String> res = new HashMap<>();
        for (WebElement element: bodyLog) {
            String[] ss = element.getText().split(" ");
            if (ss[1].startsWith("metal")) {
                if (!ss[ss.length - 1].equalsIgnoreCase("false")) {
                    res.put(ss[1].substring(0, ss[1].length() - 1), ss[ss.length - 1]);
                    return res;
                }
            }
        }
        return res;
    }

    public HashMap<String, String> getSelectedDropFromLog() {
        HashMap<String, String> res = new HashMap<>();
        for (WebElement element: bodyLog) {
            String[] ss = element.getText().split(" ");
            if (ss[1].startsWith("Colors")) {
                if (!ss[ss.length - 1].equalsIgnoreCase("false")) {
                    res.put(ss[1].substring(0, ss[1].length() - 1), ss[ss.length - 1]);
                    return res;
                }
            }
        }
        return res;
    }

    public boolean logContainsLine(String line) {
        for (WebElement element: bodyLog) {
            if (element.getText().endsWith(line)) return true;
        }
        return false;
    }

    public void helper() {
        for (WebElement element: bodyLog) {
            System.out.println(element.getText());
        }
    }
}
