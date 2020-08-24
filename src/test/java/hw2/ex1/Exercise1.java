package hw2.ex1;

import hw2.base.BaseTests;
import hw2.base.Constance;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class Exercise1 extends BaseTests {
    @Test
    public void test() {
        //Open test site by URL
        openurl();
        //Assert Browser title
        assertTitle();
        //Perform login
        performLogin();
        //Assert User name in the left-top side of screen that user is loggined
        assertUserName();
        //Assert Browser title
        assertTitle();
        //Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertHeaderItems();
        //Assert that there are 4 images on the Index Page and they are displayed
        assertImgCount();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertImgTxt();
        //Assert a text of the main headers
        assertMainText();
        //Assert that there is the iframe in the center of page
        assertIframeExists();
        //Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        assertIframeLogoExists();
        //Switch to original window back
        switchToParent();
        //Assert a text of the sub header
        assertSubHeaderText();
        //Assert that JDI GITHUB is a link and has a proper URL
        assertIsDisplayedLink();
        //Assert that there is Left Section
        assertSubHeaderLink();
        //Browser is closed - I close the browser in method AfterClass
        assertIsDisplayedLeftSection();
        //Assert that there is Footer
        assertIsDisplayedFooter();
    }

}
