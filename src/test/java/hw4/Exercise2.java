package hw4;

import hw4.base.BaseTests;
import hw4.base.TestListener;
import hw4.pages.DifferentElementsPage;
import hw4.pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Different Elements Page")
@Listeners(TestListener.class)
public class Exercise2 extends BaseTests {

    @Test
    public void testDifferentElements() {
        //Open test site by URL
        HomePage homePage = openUrl();
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
