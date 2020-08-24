package hw3;

import hw3.base.BaseTests;
import org.testng.annotations.Test;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;

public class Exercise2 extends BaseTests {
    @Test
    public void test() {


















        //Open test site by URL
        HomePage homePage = new HomePage(driver);
        //Assert Browser title
        assertHomePageTitle(homePage);
        //Perform login
        logInUser(homePage);
        //Assert User name in the left-top side of screen that user is loggined
        assertUserName(homePage);
        //Click on "Service" subcategory in the header and check that drop down contains options
        assertHasHeaderSubServiceElements(homePage);
        //Click on Service subcategory in the left section and check that drop down contains options
        assertHasLeftMenuSubServiceElements(homePage);
        //Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage =
                homePage.getHeaderMenu().differentElementsPageClick();
        //Check interface on Different elements page, it contains all needed elements
        assertDifferentPageInterfaces(differentElementsPage);
        //Assert that there is Right Section
        assertDifPageIsDisplayedRightSection(differentElementsPage);
        //Assert that there is Left Section
        assertDifPageIsDisplayedLeftSection(differentElementsPage);
        //Select checkboxes
        selectUnselectCheckbox(differentElementsPage);
        //Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        assertSelectedCheckBoxes(differentElementsPage);
        //Select radio
        selectRadioSelen(differentElementsPage);
        //Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        assertSelectedRadio(differentElementsPage);
        //Select in dropdown
        selectColor(differentElementsPage);
        //Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        assertSelectedColor(differentElementsPage);
        //Unselect and assert checkboxes
        selectUnselectCheckbox(differentElementsPage);
        //Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        assertSelectedCheckBoxes(differentElementsPage);
    }
}
