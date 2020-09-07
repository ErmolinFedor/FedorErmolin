package hw5.steps;

import hw5.beans.User;
import hw5.context.Context;
import hw5.pages.HomePage;
import io.cucumber.java.en.Given;

public class ModelSteps {
    HomePage homePage = new HomePage(Context.getInstance().getDriver());

    @Given("I open JDI GitHub site")
    public void i_open_JDI_GitHub_site() {
        homePage.openHome();
    }

    @Given("I login as user {string}")
    public void i_login_as_user(String username) {
        User user = new User(username);
        homePage.logIn(user.getLogin(), user.getPassword());
    }

}
