package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw8.entities.User;
import hw8.forms.JdiLoginForm;
import io.qameta.allure.Step;

public class JdiHomePage extends WebPage {
    @Css("#user-icon")
    private Button userIcon;

    @Css("#user-name")
    public Text userName;

    @XPath("//a[contains(text(), 'Metals & Colors')]")
    public Button metalsColors;

    private JdiLoginForm jdiLoginForm;

    @Step("Login on JDI site as User")
    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public String getUserName() {
        return userName.getValue();
    }

    @Step("Open Metals & Colors page by Header menu")
    public void clickMetalsColors() {
        metalsColors.click();
    }
}
