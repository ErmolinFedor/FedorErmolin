package hw5.pages;

import hw5.beans.Color;
import hw5.pages.components.HeaderMenu;
import hw5.pages.components.LeftSideMenu;
import hw5.pages.components.RightSideBar;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DifferentElementsPage {

    private WebDriver driver;

    private LeftSideMenu leftSideMenu;
    private RightSideBar rightSideBar;
    private HeaderMenu headerMenu;

    @FindBy(css = ".checkbox-row .label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".checkbox-row .label-radio")
    private List<WebElement> radios;

    @FindBy(css = "[class='colors'] select")
    private List<WebElement> selects;

    @FindBy(css = "button[class=uui-button], [type=button]")
    private List<WebElement> buttons;

    @Step("Check number of checkboxes")
    public int checkboxesSize() {
        return checkboxes.size();
    }

    @Step("Check number of radio buttons")
    public int radiosSize() {
        return radios.size();
    }

    @Step("Check number of selects")
    public int selectsSize() {
        return selects.size();
    }

    @Step("Check number of buttons")
    public int buttonsSize() {
        return buttons.size();
    }

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
        headerMenu = new HeaderMenu(driver);
    }

    @Step("Navigate to Left side menu")
    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    @Step("Navigate to Right side")
    public RightSideBar getRightSideBar() {
        return rightSideBar;
    }

    @Step("select checkboxes: {names}")
    public void selectCheckbox(String names) {
        String[] nameArr = names.split(" ");
        for (WebElement element: checkboxes) {
            if (Arrays.asList(nameArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    @Step("Select radio: {name}")
    public void selectRadio(String names) {
        String[] nameArr = names.split(" ");
        for (WebElement element: radios) {
            if (Arrays.asList(nameArr).contains(element.getText())) {
                element.click();
            }
        }
    }

    @Step("Get the status of checkbox.")
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

    @Step("Get status of radiobutton.")
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

    @Step("Get the selected value.")
    public HashMap<String, String> getSelectedSelect() {
        HashMap<String, String> res = new HashMap<>();
        Select select = new Select(selects.get(0));
        res.put("Colors", select.getFirstSelectedOption().getText());
        return res;
    }


    @Step("Select in dropdown: {color}")
    public void selectColor(Color color) {
        Select select = new Select(selects.get(0));
        select.selectByVisibleText(color.name());
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
