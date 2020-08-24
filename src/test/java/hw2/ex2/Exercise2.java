package hw2.ex2;

import hw2.base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;
import java.util.stream.Collectors;


public class Exercise2 extends BaseTests {
    @Test
    public void testEx2() {
        SoftAssert softAssert = new SoftAssert();
        //Open test site by URL
        openurl();
        //Assert Browser title
        assertTitle();
        //Perform login
        performLogin();
        //Assert User name in the left-top side of screen that user is loggined
        assertUserName();
        //Click on "Service" subcategory in the header and check that drop down contains options
        assertSubServiceHeaderElements();
        //Click on Service subcategory in the left section and check that drop down contains options
        assertSubServiceLeftSectionElements();
        //Open through the header menu Service -> Different Elements Page
        clickDifferentElements();
        //Check interface on Different elements page, it contains all needed elements
        assertDifPageInterfaces();
        //Assert that there is Right Section
        assertDifPageIsDisplayedRightSection();
        //Assert that there is Left Section
        assertDifPageIsDisplayedLeftSection();
        //Select checkboxes
        selectCheckboxes();
        //Assert that for each checkbox there is an individual
        // log row and value is corresponded to the status of checkbox.
        assertSelectedCheckboxes();
        //Select radio
        selectRadio();
        //Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton.
        assertSelectedRadio();
        //Select in dropdown
        selectYellow();
        //Assert that for dropdown there is a log row and value
        // is corresponded to the selected value.
        assertSelectedColor();
        //Unselect and assert checkboxes
        unSelectCheckboxes();
        //Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        assertSelectedCheckboxes();
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



    private void selectRadio() {
        driver.findElement(By.xpath("//div[3]//label[4]//input[1]")).click();
    }

    private void selectYellow() {
        Select select = new Select(driver.findElement(By.cssSelector("[class='colors'] select")));
        select.selectByVisibleText("Yellow");
    }

}
