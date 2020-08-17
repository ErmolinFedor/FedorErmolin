package hw2.ex1;

import hw2.base.BaseTests;
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
        openurl();
        assertNotNull(driver);
        String titleExpected = "Home Page";
        assertEquals(getTitle(), titleExpected, "Wrong Browser title");
        performLogin();
        String userName = "ROMAN IOVLEV";
        assertEquals(getUserName(), userName, "Wrong userName");
        assertEquals(getTitle(), titleExpected, "Wrong Browser title");
        String menuButtons = "HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS";
        assertEquals(checkHeaderItems(), menuButtons, "Wrong header items");
        assertEquals(checkImg(), 4, "Incorrect number of images on page");
        assertTrue(checkImgTxt());
        String mainText = "EPAM FRAMEWORK WISHES…\n"
                + "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT "
                + "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, "
                + "QUIS NOSTRUD EXERCITATION ULLAMCO "
                + "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT "
                + "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN "
                + "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(checkMainText(), mainText, "Wrong text of header");
        assertTrue(iframeExists());
        assertTrue(iframeLogoExists());
        switchToParent();
        //Driver has focus on the original window - I have no idea
        String subHeaderTxt = "JDI GITHUB";
        assertEquals(getSubHeaderText(), subHeaderTxt, "Wrong text of the sub header");
        String link = "https://github.com/epam/JDI";
        assertTrue(isDisplayedLink(), "Link isn't displayed");
        assertEquals(getSubHeaderLink(), link, "Link hasn't proper value");
        assertTrue(isDisplayedLeftSection(), "Left section isn't displayed");
        assertTrue(isDisplayedFooter(), "Footer isn't displayed");
        //Browser is closed - I close the browser in method AfterClass
    }

    private String getTitle() {
        return driver.getTitle();
    }

    private void openurl() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
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

    private String checkHeaderItems() {
        WebElement items = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]"));
        return items.getText();
    }

    private String checkMainText() {
        WebElement h3Txt = driver.findElement(By.name("main-title"));
        WebElement pointText = driver.findElement(By.name("jdi-text"));
        return h3Txt.getText() + "\n" + pointText.getText();
    }

    private int checkImg() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        return images.size();
    }

    private boolean checkImgTxt() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < images.size(); i++) {
            Point pointImg = images.get(i).getLocation();
            Point poimtText = texts.get(i).getLocation();
            if (pointImg.getY() > poimtText.getY()) {
                return false;
            }
        }
        return true;
    }

    private boolean iframeExists() {
        WebElement iframe = driver.findElement(By.id("second_frame"));
        return iframe != null;
    }

    private void switchToParent() {
        driver.switchTo().parentFrame();
    }

    private boolean iframeLogoExists() {
        driver.switchTo().frame("second_frame");
        WebElement logo = driver.findElement(By.cssSelector("img#epam-logo"));
        return logo != null;
    }

    private String getSubHeaderText() {
        return driver.findElement(By.cssSelector("*[class='text-center']")).getText();
    }

    private boolean isDisplayedLink() {
        return driver.findElement(
                By.cssSelector("div.main-content > h3:nth-child(3) > a")).isDisplayed();
    }

    private String getSubHeaderLink() {
        WebElement element = driver.findElement(
                By.cssSelector("div.main-content > h3:nth-child(3) > a"));
        return element.getAttribute("href");
    }

    private boolean isDisplayedLeftSection() {
        return driver.findElement(By.id("mCSB_1")).isDisplayed();
    }

    private boolean isDisplayedFooter() {
        return driver.findElement(By.tagName("footer")).isDisplayed();
    }

}
