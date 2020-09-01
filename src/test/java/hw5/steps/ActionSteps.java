package hw5.steps;

import hw5.beans.Color;
import hw5.context.Context;
import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.pages.UserTable;
import io.cucumber.java.en.When;

public class ActionSteps {

    private HomePage homePage = new HomePage(Context.getInstance().getDriver());
    private DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(Context.getInstance().getDriver());
    private UserTable userTable =
            new UserTable(Context.getInstance().getDriver());

    @When("I click on Service button in Header")
    public void i_click_Service_on_button_in_Header() {
        homePage.getHeaderMenu().clickServiceOnHeader();
    }

    @When("I click on Different Elements Page button in Service dropdown")
    public void i_click_Different_Elements_on_button_in_Service_dropdown() {
        homePage.getHeaderMenu().differentElementLinkClick();
    }

    @When("I click on User Table button in Service dropdown")
    public void i_click_User_Table_on_button_in_Service_dropdown() {
        homePage.getHeaderMenu().userTableLinkClick();
    }

    @When("Select checkboxes {string}")
    public void select_checkboxes(String checkbox) {
        differentElementsPage.selectCheckbox(checkbox);
    }

    @When("Select radiobutton {string}")
    public void select_radiobutton(String radiobutton) {
        differentElementsPage.selectRadio(radiobutton);
    }

    @When("Select in dropdown {string}")
    public void select_in_dropdown(String dropdown) {
        differentElementsPage.selectColor(Color.valueOf(dropdown));
    }

    @When("I select vip checkbox for Sergey Ivan")
    public void i_select_vip_checkbox_for_Sergey_Ivan() {
        userTable.clickIvanCheckbox();

    }

}
