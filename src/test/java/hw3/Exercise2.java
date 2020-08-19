package hw3;

import hw3.beans.Color;
import hw3.base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;

public class Exercise2 extends BaseTests {
    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver); //Open test site by URL
        softAssert.assertEquals(homePage.getTitle(),
                property.getProperty("homePageTitle"),
                "Wrong Browser title");

        homePage.logIn(property.getProperty("login"), property.getProperty("password"));
        softAssert.assertEquals(homePage.getUserName(),
                property.getProperty("userNameTitle"),
                "Wrong userName");

        softAssert.assertEquals(homePage.getHeaderMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSubHeader"));

        softAssert.assertEquals(homePage.getLeftSideMenu().getExistsSubServiceElements(),
                property.getProperty("serviceSub"));

        DifferentElementsPage differentElementsPage =
                homePage.getLeftSideMenu().clickDifferentElement();

        softAssert.assertEquals(differentElementsPage.getAllElements(),
                property.getProperty("difInterfaces"),
                "Wrong number of elements");

        softAssert.assertTrue(differentElementsPage
                        .getRightSideBar()
                        .isDisplayedRightSection(),
                "Right section isn't displayed");

        softAssert.assertTrue(differentElementsPage.getLeftSideMenu()
                        .isDisplayedLeftSection(),
                "Left section isn't displayed");

        differentElementsPage.selectCheckbox(property.getProperty("selectCheckboxes"));
        softAssert.assertEquals(differentElementsPage.getSelectedCheckBoxes(),
                differentElementsPage.getRightSideBar()
        .getSelectedFromLog(2),
                "Wrong log of selected. Wrong selected checkboxes");

        differentElementsPage.selectRadio("Selen");
        softAssert.assertEquals(differentElementsPage.getSelectedRadio(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(1),
                "Wrong log of selected. Wrong selected radio");

        differentElementsPage.selectColor(Color.Yellow);
        softAssert.assertEquals(differentElementsPage.getSelectedSelect(),
                differentElementsPage.getRightSideBar()
                .getSelectedFromLog(1),
                "Wrong log of selected. Wrong selected color");

        differentElementsPage.selectCheckbox(property.getProperty("selectCheckboxes"));
        softAssert.assertEquals(differentElementsPage.getSelectedCheckBoxes(),
                differentElementsPage.getRightSideBar()
                        .getSelectedFromLog(2),
                "Wrong log of selected. Wrong unselected checkboxes");
        softAssert.assertAll();
    }
}
