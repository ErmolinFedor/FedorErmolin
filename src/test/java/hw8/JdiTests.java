package hw8;

import hw8.beans.Data;
import hw8.data.MetalsColorsData;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw8.entities.User.ROMAN;

public class JdiTests {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test(priority =0)
    public void logIn() {
        JdiSite.open();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getName());
    }


    @Test(priority = 1, dataProvider = "MetalsColorsToDo", dataProviderClass =MetalsColorsData.class)
    public void jdiMetalsColorsTest(Data data, List<String> expectedList) {
        JdiSite.jdiHomePage.clickMetalsColors();
        JdiSite.jdiMetalsColorsPage.checkOpened();
        JdiSite.jdiMetalsColorsPage.fillMetalsColorsForm(data);
        JdiSite.jdiMetalsColorsPage.clickSubmit();
        assertData(expectedList);
    }

    @Step("Result sections should contains data  below: {expectedList}")
    private void assertData(List<String> expectedList) {
        List<String> actualList = JdiSite.jdiMetalsColorsPage.getLogListResults();
        assertThat(actualList, equalTo(expectedList));
    }

}
