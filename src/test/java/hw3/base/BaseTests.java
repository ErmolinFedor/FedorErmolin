package hw3.base;

import hw3.beans.Color;
import hw3.pages.BaseElements;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import hw3.pages.SecondFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class BaseTests {
    protected WebDriver driver;
    protected Properties property = new Properties();
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        softAssert = new SoftAssert();
        try {
            property.load(
                    new InputStreamReader(
                            new FileInputStream("src/test/resources/hw3config.properties"),
                            Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }

    public void assertHomePageTitle(HomePage homePage) {
        assertEquals(homePage.getTitle(),
                property.getProperty("homePageTitle"),
                "Wrong Browser title");
    }

    public void logInUser(HomePage homePage) {
        homePage.logIn(property.getProperty("login"), property.getProperty("password"));
    }

    public void assertUserName(HomePage homePage) {
        assertEquals(homePage.getUserName(),
                property.getProperty("userNameTitle"),
                "Wrong userName");

    }

    public void assertTextHeaderItems(HomePage homePage) {
        assertEquals(homePage.getTextHeaderItems(),
                property.getProperty("menuButtons"),
                "Wrong header items");
    }

    public void assertImgCount(HomePage homePage) {
        assertEquals(homePage.getImgCount(),
                Integer.parseInt(property.getProperty("imgCount")),
                "Incorrect number of images on page");
    }

    public void assertTextBelowImages(HomePage homePage) {
        assertTrue(homePage.isTextBelowImages());
    }

    public void assertMainText(HomePage homePage) {
        assertEquals(homePage.getMainText(), property.getProperty("mainText"),
                "Wrong text of header");
    }

    public void assertIsIframeExists(HomePage homePage) {
        assertTrue(homePage.iframeExists());
    }

    public SecondFrame assertIsLogoExists(HomePage homePage) {
        SecondFrame secondFrame = homePage.moveToSecondIframe();
        assertTrue(secondFrame.logoExists());
        return secondFrame;
    }

    public void assertSubHeaderText(HomePage homePage) {
        assertEquals(homePage.getSubHeaderText(),
                property.getProperty("subHeaderTxt"),
                "Wrong text of the sub header");
    }

    public void assertSubHeaderLink(HomePage homePage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayedLink(), "Link isn't displayed");
        softAssert.assertEquals(homePage.getSubHeaderLink(),
                property.getProperty("link"), "Link hasn't proper value");
        softAssert.assertAll();
    }

    public void assertsIsDisplayedLeftSection(HomePage homePage) {
        assertTrue(homePage.isDisplayedLeftSection(),
                "Left section isn't displayed");
    }

    public void assertIsDisplayedFooter(HomePage homePage) {
        assertTrue(homePage.isDisplayedFooter(), "Footer isn't displayed");
    }

    public void assertHasHeaderSubServiceElements(HomePage homePage) {
        assertEquals(homePage.getHeaderMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSubHeader"));

    }

    public void assertHasLeftMenuSubServiceElements(HomePage homePage) {
        assertEquals(homePage.getLeftSideMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSub"));
    }

    public void assertDifferentPageInterfaces(DifferentElementsPage differentElementsPage) {
        softAssert.assertEquals(differentElementsPage.checkboxesSize(),
                Integer.parseInt(property.getProperty("checkboxes")),
                "Wrong number of checkboxes");
        softAssert.assertEquals(differentElementsPage.radiosSize(),
                Integer.parseInt(property.getProperty("radios")),
                "Wrong number of radios");
        softAssert.assertEquals(differentElementsPage.selectsSize(),
                Integer.parseInt(property.getProperty("selects")),
                "Wrong number of selects");
        softAssert.assertEquals(differentElementsPage.buttonsSize(),
                Integer.parseInt(property.getProperty("buttons")),
                "Wrong number of buttons");
        softAssert.assertAll();

    }

    public void assertDifPageIsDisplayedRightSection(
            DifferentElementsPage differentElementsPage) {
        assertTrue(differentElementsPage
                        .getRightSideBar()
                        .isDisplayedRightSection(),
                "Right section isn't displayed");
    }

    public void assertDifPageIsDisplayedLeftSection(
            DifferentElementsPage differentElementsPage) {
        softAssert.assertTrue(differentElementsPage.getLeftSideMenu()
                        .isDisplayedLeftSection(),
                "Left section isn't displayed");
    }

    public void assertSelectedCheckBoxes(
            DifferentElementsPage differentElementsPage) {
        softAssert.assertEquals(differentElementsPage.getSelectedCheckBoxes(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(2),
                "Wrong log of selected. Wrong selected checkboxes");
    }

    public void selectRadioSelen(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectRadio("Selen");
    }

    public void assertSelectedRadio(
            DifferentElementsPage differentElementsPage) {
        assertEquals(differentElementsPage.getSelectedRadio(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(1),
                "Wrong log of selected. Wrong selected radio");
    }

    public void selectColor(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectColor(Color.Yellow);
    }

    public void assertSelectedColor(
            DifferentElementsPage differentElementsPage) {
        assertEquals(differentElementsPage.getSelectedSelect(),
            differentElementsPage.getRightSideBar()
                    .getSelectedFromLog(1),
            "Wrong log of selected. Wrong selected color");
    }

    public void selectUnselectCheckbox(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectCheckbox(property.getProperty("selectCheckboxes"));
    }

}
