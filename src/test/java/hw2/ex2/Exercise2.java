package hw2.ex2;

import hw2.base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Exercise2 extends BaseTests {
    @Test
    public void testEx2() {
        SoftAssert softAssert = new SoftAssert();
        openurl();

        softAssert.assertNotNull(driver);

        String titleExpected = "Home Page";
        softAssert.assertEquals(getTitle(), titleExpected, "Wrong Browser title");

        performLogin();
        String userName = "ROMAN IOVLEV";

        softAssert.assertEquals(getUserName(), userName, "Wrong userName");

        List<String> serviceElements = new ArrayList<>();
        serviceElements.add("Support");
        serviceElements.add("Dates");
        serviceElements.add("Complex Table");
        serviceElements.add("Simple Table");
        serviceElements.add("Search");
        serviceElements.add("User Table");
        serviceElements.add("Table with pages");
        serviceElements.add("Different elements");
        serviceElements.add("Performance");

        softAssert.assertEquals(getExistsSubServiceElements(),
                serviceElements, "Wrong service items");
        clickDifferentElements();
        String pageDifferentElements = "Different Elements";
        softAssert.assertEquals(getTitle(), pageDifferentElements, "Wrong Browser title");

        //4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        int checkboxes = 4;
        int radios = 4;
        int dropdown = 1;
        int buttons = 2;
        softAssert.assertEquals(getNumberOfCheckboxes(), checkboxes, "Wrong number of checkboxes");
        softAssert.assertEquals(getNumberOfRadios(), radios, "Wrong number of radios");
        softAssert.assertEquals(getNumberOfDropdown(), dropdown, "Wrong number of dropdowns");
        softAssert.assertEquals(getNumberOfButtons(), buttons, "Wrong number of buttons");
        softAssert.assertTrue(isDisplayedRightSection(), "Right section isn't displayed");
        softAssert.assertTrue(isDisplayedLeftSection(), "Left section isn't displayed");

        selectCheckboxes();
        List<String> selected = new ArrayList<>();//List.of("Wind true", "Water true");
        selected.add("Wind true");
        selected.add("Water true");
        softAssert.assertEquals(getSelectedFromLog(), selected,
                "Wrong log of selected. Wrong selected checkboxes");

        selectRadio();
        selected.add(0, "metal Selen");
        softAssert.assertEquals(getSelectedFromLog(), selected,
                "Wrong log of selected. Wrong selected radio");

        selectYellow();
        selected.add(0, "Colors Yellow");
        softAssert.assertEquals(getSelectedFromLog(), selected,
                "Wrong log of selected. Wrong selected color");

        selectCheckboxes();
        selected.add(0, "Water false");
        selected.add(0, "Wind false");
        softAssert.assertEquals(getSelectedFromLog(), selected,
                "Wrong log of selected. Wrong unselected checkboxes");

        softAssert.assertAll();
    }

    private void openurl() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    private String getTitle() {
        return driver.getTitle();
    }

    private void performLogin() {
        //username: Roman
        //pass: Jdi1234
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("img#user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Roman");
        driver.findElement(By.cssSelector("#password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
    }

    private String getUserName() {
        return driver.findElement(By.id("user-name")).getText().toUpperCase();
    }

    private List<String> getExistsSubServiceElements() {
        WebElement service = driver.findElement(
                By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > a > span"));
        service.click();
        WebElement dropDown = driver.findElement(
                By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > ul"));
        List<WebElement> elements = dropDown.findElements(By.tagName("li"));
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private void clickDifferentElements() {
        driver.findElement(
                By.cssSelector("#mCSB_1_container > ul > "
                        + "li:nth-child(3) > ul > li:nth-child(8) > a > span"))
                .click();
    }

    private int getNumberOfCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        return checkboxes.size();
    }

    private int getNumberOfRadios() {
        List<WebElement> radios = driver.findElements(By.cssSelector("[type=radio]"));
        return radios.size();
    }

    private int getNumberOfDropdown() {
        List<WebElement> dropdown = driver.findElements(By.cssSelector("select"));
        return dropdown.size();
    }

    private int getNumberOfButtons() {
        List<WebElement> buttons = driver.findElements(
                By.cssSelector("button[class=uui-button], [type=button]"));
        return buttons.size();
    }

    private boolean isDisplayedRightSection() {
        return driver.findElement(By.name("log-sidebar")).isDisplayed();
    }

    private boolean isDisplayedLeftSection() {
        return driver.findElement(By.name("navigation-sidebar")).isDisplayed();
    }

    private void selectCheckboxes() {
        WebElement boxWater = driver.findElement(
                By.cssSelector("* label:nth-child(1) > input[type=checkbox]"));
        boxWater.click();
        WebElement boxWind = driver.findElement(
                By.cssSelector("* label:nth-child(3) > input[type=checkbox]"));
        boxWind.click();
    }

    private List<String> getSelectedFromLog() {
        WebElement log = driver.findElement(By.cssSelector("[class='panel-body-list logs']"));
        List<WebElement> selected = log.findElements(By.tagName("li"));
        List<String> selectedS = new ArrayList<>();
        for (WebElement element : selected) {
            String[] ss = element.getText().split(" ");
            String s = ss[1].substring(0, ss[1].length() - 1) + " " + ss[ss.length - 1];
            selectedS.add(s);
        }
        return selectedS;
    }

    private void selectRadio() {
        driver.findElement(By.cssSelector("* label:nth-child(4) > input[type=radio]")).click();
    }

    private void selectYellow() {
        driver.findElement(By.cssSelector("*  select > option:nth-child(4)")).click();
    }

}
