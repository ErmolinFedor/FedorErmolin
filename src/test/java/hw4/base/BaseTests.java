package hw4.base;

import hw4.beans.Color;
import hw4.pages.DifferentElementsPage;
import hw4.pages.HomePage;
import hw4.pages.SecondFrame;
import io.qameta.allure.Step;
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Step("Open test site by URL")
    protected HomePage openUrl() {
        return new HomePage(driver);
    }

    @Step("Assert Browser title")
    public void assertHomePageTitle(HomePage homePage) {
        assertEquals(homePage.getTitle(),
                property.getProperty("homePageTitle"),
                "Wrong Browser title");
    }

    @Step("Perform login")
    public void logInUser(HomePage homePage) {
        homePage.logIn(property.getProperty("login"), property.getProperty("password"));
    }

    @Step("Assert User name in the left-top side of screen that user is loggined")
    public void assertUserName(HomePage homePage) {
        assertEquals(homePage.getUserName(),
                property.getProperty("userNameTitle"),
                "Wrong userName");

    }

    @Step("Assert that there are 4 items on the header section"
            + " are displayed and they have proper texts")
    public void assertTextHeaderItems(HomePage homePage) {
        assertEquals(homePage.getTextHeaderItems(),
                property.getProperty("menuButtons"),
                "Wrong header items");
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImgCount(HomePage homePage) {
        assertEquals(homePage.getImgCount(),
                Integer.parseInt(property.getProperty("imgCount")),
                "Incorrect number of images on page");
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTextBelowImages(HomePage homePage) {
        assertTrue(homePage.isTextBelowImages());
    }

    @Step("Assert a text of the main headers")
    public void assertMainText(HomePage homePage) {
        assertEquals(homePage.getMainText(), property.getProperty("mainText"),
                "Wrong text of header");
    }

    @Step("Assert that there is the iframe in the center of page")
    public void assertIsIframeExists(HomePage homePage) {
        assertTrue(homePage.iframeExists());
    }

    @Step("Switch to the iframe and check that there is Epam logo in the left top conner of iframe")
    public SecondFrame assertIsLogoExists(HomePage homePage) {
        SecondFrame secondFrame = homePage.moveToSecondIframe();
        assertTrue(secondFrame.logoExists());
        return secondFrame;
    }

    @Step("Assert a text of the sub header")
    public void assertSubHeaderText(HomePage homePage) {
        assertEquals(homePage.getSubHeaderText(),
                property.getProperty("subHeaderTxt"),
                "Wrong text of the sub header");
    }

    @Step("Assert that JDI GITHUB is a link and has a proper URL")
    public void assertSubHeaderLink(HomePage homePage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayedLink(), "Link isn't displayed");
        softAssert.assertEquals(homePage.getSubHeaderLink(),
                property.getProperty("link"), "Link hasn't proper value");
        softAssert.assertAll();
    }

    @Step("Assert that there is Left Section")
    public void assertsIsDisplayedLeftSection(HomePage homePage) {
        assertTrue(homePage.isDisplayedLeftSection(),
                "Left section isn't displayed");
    }

    @Step("Assert that there is Footer")
    public void assertIsDisplayedFooter(HomePage homePage) {
        assertTrue(homePage.isDisplayedFooter(), "Footer isn't displayed");
    }

    @Step("Click on \"Service\" subcategory in the header and check "
            + "that drop down contains options")
    public void assertHasHeaderSubServiceElements(HomePage homePage) {
        assertEquals(homePage.getHeaderMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSubHeader"));

    }

    @Step("Click on Service subcategory in the left section and check "
            + "that drop down contains options")
    public void assertHasLeftMenuSubServiceElements(HomePage homePage) {
        assertEquals(homePage.getLeftSideMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSub"));
    }

    @Step("Check interface on Different elements page, it contains all needed elements")
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

    @Step("Assert that there is Right Section")
    public void assertDifPageIsDisplayedRightSection(
            DifferentElementsPage differentElementsPage) {
        assertTrue(differentElementsPage
                        .getRightSideBar()
                        .isDisplayedRightSection(),
                "Right section isn't displayed");
    }

    @Step("Assert that there is Left Section")
    public void assertDifPageIsDisplayedLeftSection(
            DifferentElementsPage differentElementsPage) {
        softAssert.assertTrue(differentElementsPage.getLeftSideMenu()
                        .isDisplayedLeftSection(),
                "Left section isn't displayed");
    }

    @Step("Assert that for each checkbox there is an individual log row"
            + " and value is corresponded to the status of checkbox.")
    public void assertSelectedCheckBoxes(
            DifferentElementsPage differentElementsPage) {
        softAssert.assertEquals(differentElementsPage.getSelectedCheckBoxes(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(2),
                "Wrong log of selected. Wrong selected checkboxes");
    }

    @Step("Select radio")
    public void selectRadioSelen(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectRadio("Selen");
    }

    @Step("Assert that for radiobutton there is a log row"
            + " and value is corresponded to the status of radiobutton.")
    public void assertSelectedRadio(
            DifferentElementsPage differentElementsPage) {
        assertEquals(differentElementsPage.getSelectedRadio(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(1),
                "Wrong log of selected. Wrong selected radio");
    }

    @Step("Select in dropdown")
    public void selectColor(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectColor(Color.Yellow);
    }

    @Step("Assert that for dropdown there is a log row"
            + " and value is corresponded to the selected value.")
    public void assertSelectedColor(
            DifferentElementsPage differentElementsPage) {
        assertEquals(differentElementsPage.getSelectedSelect(),
            differentElementsPage.getRightSideBar()
                    .getSelectedFromLog(1),
            "Wrong log of selected. Wrong selected color");
    }

    @Step("Select checkboxes")
    public void selectUnselectCheckbox(
            DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectCheckbox(property.getProperty("selectCheckboxes"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void assertWrongHomePageTitle(HomePage homePage) {
        assertEquals(homePage.getTitle(),
                property.getProperty("wrongHomePageTitle"),
                "Wrong Browser title");
    }

}
