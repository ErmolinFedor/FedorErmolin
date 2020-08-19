package hw3.pages;

import hw3.beans.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import hw3.pages.components.LeftSideMenu;
import hw3.pages.components.RightSideBar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DifferentElementsPage {

    private WebDriver driver;

    private LeftSideMenu leftSideMenu;
    private RightSideBar rightSideBar;

    @FindBy(css = ".checkbox-row .label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".checkbox-row .label-radio")
    private List<WebElement> radios;

    @FindBy(css = "[class='colors'] select")
    private List<WebElement> selects;

    @FindBy(css = "button[class=uui-button], [type=button]")
    private List<WebElement> buttons;

    public String getAllElements() {
        StringBuilder sb = new StringBuilder();
        sb.append("checkboxes = ").append(checkboxes.size())
                .append(" radios = ").append(radios.size())
                .append(" selects = ").append(selects.size())
                .append(" buttons = ").append(buttons.size());
        return sb.toString();
    }

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        leftSideMenu = new LeftSideMenu(driver);
        rightSideBar = new RightSideBar(driver);
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public RightSideBar getRightSideBar() {
        return rightSideBar;
    }

    public void selectCheckbox(String names) {
        String[] nameArr = names.split(" ");
        for (WebElement element: checkboxes) {
            if (Arrays.asList(nameArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectRadio(String names) {
        String[] nameArr = names.split(" ");
        for (WebElement element: radios) {
            if (Arrays.asList(nameArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    public HashMap<String, String> getSelectedCheckBoxes() {
        HashMap<String, String> res = new HashMap<>();
        for (WebElement element: checkboxes) {
            WebElement e = element.findElement(By.cssSelector("[type=checkbox]"));//isSelected
            if (e.isSelected()) {
                res.put(element.getText(), String.valueOf(e.isSelected()));
            }
        }
        return res;
    }

    public HashMap<String, String> getSelectedRadio() {
        HashMap<String, String> res = new HashMap<>();
        for (WebElement element: radios) {
            WebElement e = element.findElement(By.cssSelector("[type=radio]"));//isSelected
            if (e.isSelected()) {
                res.put(e.getAttribute("name"), element.getText());
            }
        }
        return res;
    }

    public HashMap<String, String> getSelectedSelect() {
        HashMap<String, String> res = new HashMap<>();
        Select select = new Select(selects.get(0));
        res.put("Colors", select.getFirstSelectedOption().getText());
        return res;
    }


    public void selectColor(Color color) {
        Select select = new Select(selects.get(0));
        select.selectByVisibleText(color.name());
    }

}
