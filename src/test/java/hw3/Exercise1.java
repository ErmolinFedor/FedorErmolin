package hw3;

import hw3.base.BaseTests;
import org.testng.annotations.Test;
import hw3.pages.HomePage;
import hw3.pages.SecondFrame;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class Exercise1 extends BaseTests {
    @Test
    public void test() {

        HomePage homePage = new HomePage(driver); //Open test site by URL
        assertEquals(homePage.getTitle(),
                property.getProperty("homePageTitle"),
                "Wrong Browser title");

        homePage.logIn(property.getProperty("login"), property.getProperty("password"));
        assertEquals(homePage.getUserName(),
                property.getProperty("userNameTitle"),
                "Wrong userName");

        assertEquals(homePage.getTitle(),
                property.getProperty("homePageTitle"),
                "Wrong Browser title");

        assertEquals(homePage.getTextHeaderItems(),
                property.getProperty("menuButtons"),
                "Wrong header items");
        assertEquals(homePage.getImgCount(),
                Integer.parseInt(property.getProperty("imgCount")),
                "Incorrect number of images on page");
        assertTrue(homePage.isTextBelowImages());

        assertEquals(homePage.getMainText(), property.getProperty("mainText"),
                "Wrong text of header");

        assertTrue(homePage.iframeExists());
        SecondFrame secondFrame = homePage.moveToSecondIframe();
        assertTrue(secondFrame.logoExists());
        homePage = secondFrame.switchToParent();

        assertEquals(homePage.getSubHeaderText(),
                property.getProperty("subHeaderTxt"),
                "Wrong text of the sub header");
        assertTrue(homePage.isDisplayedLink(), "Link isn't displayed");
        assertEquals(homePage.getSubHeaderLink(),
                property.getProperty("link"), "Link hasn't proper value");
        assertTrue(homePage.isDisplayedLeftSection(),
                "Left section isn't displayed");
        assertTrue(homePage.isDisplayedFooter(), "Footer isn't displayed");
    }
}
