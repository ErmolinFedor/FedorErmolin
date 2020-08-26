package hw4;

import hw4.base.BaseTests;
import hw4.base.TestListener;
import hw4.pages.HomePage;
import hw4.pages.SecondFrame;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Inspect Home Page")
@Listeners(TestListener.class)
public class Exercise1 extends BaseTests {

    @Test
    public void testHomePage() {
        //Open test site by URL
        HomePage homePage = openUrl();
        //Assert Browser title
        assertHomePageTitle(homePage);
        //Perform login
        logInUser(homePage);
        //Assert User name in the left-top side of screen that user is loggined
        assertUserName(homePage);
        //Assert Browser title
        assertHomePageTitle(homePage);
        //Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertTextHeaderItems(homePage);
        //Assert that there are 4 images on the Index Page and they are displayed
        assertImgCount(homePage);
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTextBelowImages(homePage);
        //Assert a text of the main headers
        assertMainText(homePage);
        //Assert that there is the iframe in the center of page
        assertIsIframeExists(homePage);
        //Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        SecondFrame secondFrame = assertIsLogoExists(homePage);
        //Switch to original window back
        homePage = secondFrame.switchToParent();
        //Assert a text of the sub header
        assertSubHeaderText(homePage);
        //Assert that JDI GITHUB is a link and has a proper URL
        assertSubHeaderLink(homePage);
        //Assert that there is Left Section
        assertsIsDisplayedLeftSection(homePage);
        //Assert that there is Footer
        assertIsDisplayedFooter(homePage);
    }
}
