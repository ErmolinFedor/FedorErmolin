package hw5.steps;

import hw5.context.Context;
import hw5.pages.DifferentElementsPage;
import hw5.pages.UserTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps {
    private DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(Context.getInstance().getDriver());
    private UserTable userTable =
            new UserTable(Context.getInstance().getDriver());

    @Then("Name should be displayed and equals to expected username {string}")
    public void name_should_be_displayed_and_equals_to_expected_username(String string) {
        assertEquals(differentElementsPage.getHeaderMenu().getUserName(),
                string);
    }

    @Then("Log rows are displayed and checkbox name and its status are corresponding to selected")
    public void log_rows_are_displayed_and_checkbox_name_and_its_status_are_corresponding_to_selected() {
        assertEquals(
                differentElementsPage.getSelectedCheckBoxes(),
                differentElementsPage.getRightSideBar().getSelectedBoxesFromLog()
        );
    }

    @Then("Log rows are displayed and radio button name and it status is corresponding to selected")
    public void log_rows_are_displayed_and_radio_button_name_and_it_status_is_corresponding_to_selected() {
        assertEquals(
                differentElementsPage.getSelectedRadio(),
                differentElementsPage.getRightSideBar().getSelectedRadioFromLog()
        );
    }

    @Then("Log rows are displayed and dropdown name and selected value is corresponding to selected")
    public void log_rows_are_displayed_and_dropdown_name_and_selected_value_is_corresponding_to_selected() {
        assertEquals(
                differentElementsPage.getSelectedSelect(),
                differentElementsPage.getRightSideBar().getSelectedDropFromLog()
        );
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String string) {
        assertEquals(userTable.getPageNameText(), string);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer count) {
        assertEquals(Integer.valueOf(userTable.getDropdownCount()), count);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer count) {
        assertEquals(Integer.valueOf(userTable.getUsernameCount()), count);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer count) {
        assertEquals(Integer.valueOf(userTable.getDescriptionsCount()), count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer count) {
        assertEquals(Integer.valueOf(userTable.getCheckboxesCount()),  count);
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(DataTable expectedTable) {
        List<List<String>> list = expectedTable.asLists();
        List<String> numbersExpected = new ArrayList<>();
        List<String> usernamesExpected = new ArrayList<>();
        List<String> descriptionsExpected = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            numbersExpected.add(list.get(i).get(0));
            usernamesExpected.add(list.get(i).get(1));
            descriptionsExpected.add(list.get(i).get(2));
        }
        assertEquals(usernamesExpected, userTable.getUsernamesList(), "wrong usernames");
        assertEquals(numbersExpected, userTable.getNumberColumnList(), "wrong column number");
        assertEquals(descriptionsExpected, userTable.getDescriptionsList(),"wrong descriptions");
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(DataTable expectedTable) {
        userTable.getOptionsTypeForUserRoman().get(0).click();
        List<String> optionExpected = expectedTable
                .asList()
                .stream()
                .skip(1)
                .collect(Collectors.toList());;
        List<String> actualResult = userTable.getOptionsStringForRoman();
        assertEquals(actualResult, optionExpected, "wrong droplist");
    }

    @Then("One log row has {string} text in log section")
    public void one_log_row_has_text_in_log_section(String string) {
        assertTrue(userTable.getRightSideBar().logContainsLine(string));
    }

}
