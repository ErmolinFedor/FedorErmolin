package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTests {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
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

    public void assertTitle() {
        assertEquals(getTitle(), Constance.titleExpected, "Wrong Browser title");
    }

    public void assertUserName() {
        assertEquals(getUserName(), Constance.userName.toString(), "Wrong userName");
    }

    public void assertHeaderItems() {
        assertEquals(checkHeaderItems(), Constance.menuButtons, "Wrong header items");
    }

    public void assertImgCount() {
        assertEquals(checkImg(), Constance.imgCount,
                "Incorrect number of images on page");
    }

    public void assertImgTxt() {
        assertTrue(checkImgTxt());
    }

    public void assertMainText() {
        assertEquals(checkMainText(), Constance.mainText.toString(), "Wrong text of header");
    }

    public void assertIframeExists() {
        assertTrue(iframeExists());
    }

    public void assertIframeLogoExists() {
        assertTrue(iframeLogoExists());
    }

    public void assertSubHeaderText() {
        assertEquals(getSubHeaderText(),
                Constance.subHeaderTxt.toString(), "Wrong text of the sub header");
    }

    public void assertIsDisplayedLink() {
        assertTrue(isDisplayedLink(), "Link isn't displayed");
    }

    public void assertSubHeaderLink() {
        assertEquals(getSubHeaderLink(), Constance.link, "Link hasn't proper value");
    }

    public void assertIsDisplayedLeftSection() {
        assertTrue(isDisplayedLeftSection(), "Left section isn't displayed");
    }

    public void assertIsDisplayedFooter() {
        assertTrue(isDisplayedFooter(), "Footer isn't displayed");
    }

    private String getTitle() {
        return driver.getTitle();
    }

    protected void openurl() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    protected void performLogin() {
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(Constance.login);
        driver.findElement(By.cssSelector("#password")).sendKeys(Constance.password);
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
            Point pointText = texts.get(i).getLocation();
            if (pointImg.getY() > pointText.getY()) {
                return false;
            }
        }
        return true;
    }

    private boolean iframeExists() {
        WebElement iframe = driver.findElement(By.id("second_frame"));
        return iframe != null;
    }

    protected void switchToParent() {
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

    public void assertSubServiceHeaderElements() {
        assertEquals(getExistsSubServiceHeaderElements(),
                Constance.serviceElementsHeader, "Wrong service items");
    }

    private void clickHeaderService() {
        driver.findElement(
                By.xpath("//a[contains(text(), 'Service')]")).click();
    }

    protected void clickDifferentElements() {
        clickHeaderService();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
    }

    private List<String> getExistsSubServiceHeaderElements() {
        clickHeaderService();
        List<WebElement> dropDown = driver.findElements(
                By.cssSelector("ul.dropdown-menu li"));
        return dropDown.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void assertSubServiceLeftSectionElements() {
        assertEquals(getExistsSubServiceLeftElements(),
                Constance.serviceElementsLeft, "Wrong service items");
    }

    private List<String> getExistsSubServiceLeftElements() {
        WebElement service = driver.findElement(
                By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > a > span"));
        service.click();
        WebElement dropDown = driver.findElement(
                By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > ul"));
        List<WebElement> elements = dropDown.findElements(By.tagName("li"));
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void assertDifPageInterfaces() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getNumberOfCheckboxes(), Constance.checkboxes,
                "Wrong number of checkboxes");
        softAssert.assertEquals(getNumberOfRadios(), Constance.radios, "Wrong number of radios");
        softAssert.assertEquals(getNumberOfDropdown(), Constance.dropdown,
                "Wrong number of dropdowns");
        softAssert.assertEquals(getNumberOfButtons(), Constance.buttons, "Wrong number of buttons");
        softAssert.assertAll();
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

    public void assertDifPageIsDisplayedRightSection() {
        assertTrue(isDisplayedDifPageRightSection(), "Right section isn't displayed");
    }

    public void assertDifPageIsDisplayedLeftSection() {
        assertTrue(isDisplayedDifPageLeftSection(), "Left section isn't displayed");
    }

    private boolean isDisplayedDifPageRightSection() {
        return driver.findElement(By.name("log-sidebar")).isDisplayed();
    }

    private boolean isDisplayedDifPageLeftSection() {
        return driver.findElement(By.name("navigation-sidebar")).isDisplayed();
    }

    public void assertSelectedCheckboxes() {
        assertEquals(getSelectedFromLog(2), getSelectedCheckBoxes(),
                "Wrong log of selected. Wrong selected checkboxes");
    }

    private List<String> getSelectedFromLog(int count) {
        WebElement log = driver.findElement(By.cssSelector("[class='panel-body-list logs']"));
        List<WebElement> selected = log.findElements(By.tagName("li"));
        List<String> selectedS = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] ss = selected.get(i).getText().split(" ");
            if (!ss[ss.length - 1].equalsIgnoreCase("false")) {
                String s = ss[1].substring(0, ss[1].length() - 1) + " " + ss[ss.length - 1];
                selectedS.add(s);
            }
        }
        Collections.reverse(selectedS);
        return selectedS;
    }

    private List<String> getSelectedCheckBoxes() {
        List<String> res = new ArrayList<>();
        List<WebElement> elements =
                driver.findElements(By.cssSelector(".checkbox-row .label-checkbox"));
        for (WebElement element: elements) {
            WebElement e = element.findElement(By.cssSelector("[type=checkbox]"));//isSelected
            if (e.isSelected()) {
                res.add(element.getText() + " " + String.valueOf(e.isSelected()));
            }
        }
        return res;
    }

    private List<String> getSelectedRadio() {
        List<String> res = new ArrayList<>();
        List<WebElement> elements =
                driver.findElements(By.cssSelector(".checkbox-row .label-radio"));
        for (WebElement element: elements) {
            WebElement e = element.findElement(By.cssSelector("[type=radio]"));//isSelected
            if (e.isSelected()) {
                res.add(e.getAttribute("name") + " " + element.getText());
            }
        }
        return res;
    }

    private void selectWaterCheckbox() {
        WebElement boxWater = driver.findElement(
                By.cssSelector("* label:nth-child(1) > input[type=checkbox]"));
        boxWater.click();
    }

    private void selectWindCheckbox() {
        WebElement boxWind = driver.findElement(
                By.cssSelector("* label:nth-child(3) > input[type=checkbox]"));
        boxWind.click();
    }

    public void unSelectCheckboxes() {
        selectWaterCheckbox();
        selectWindCheckbox();
    }

    public void selectCheckboxes() {
        selectWaterCheckbox();
        selectWindCheckbox();
    }

    public void assertSelectedRadio() {
        assertEquals(getSelectedFromLog(1), getSelectedRadio(),
                "Wrong log of selected. Wrong selected radio");
    }

    public List<String> getSelectedColor() {
        List<String> res = new ArrayList<>();
        Select select = new Select(driver.findElement(By.cssSelector("[class='colors'] select")));
        res.add("Colors" + " " + select.getFirstSelectedOption().getText());
        return res;
    }

    public void assertSelectedColor() {
        assertEquals(getSelectedFromLog(1), getSelectedColor(),
                "Wrong log of selected. Wrong unselected checkboxes");
    }

}
