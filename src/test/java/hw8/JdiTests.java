package hw8;

import hw8.beans.MetalsColors;
import hw8.data.MetalsColorsData;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw8.JdiSite.*;
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


    @Test(dataProvider = "MetalsColorsToDo", dataProviderClass =MetalsColorsData.class)
    public void jdiMetalsColorsTest(MetalsColors metalsColors, List<String> expectedList) {
        open();
        jdiHomePage.login(ROMAN);
        jdiHomePage.userName.is().text(ROMAN.getName());
        jdiHomePage.clickMetalsColors();
        jdiMetalsColorsPage.checkOpened();
        jdiMetalsColorsPage.fillMetalsColorsForm(metalsColors);
        assertData(expectedList);
        jdiHomePage.logout();
    }

    @Step("Result sections should contains data  below: {expectedList}")
    private void assertData(List<String> expectedList) {
        List<String> actualList = jdiMetalsColorsPage.getLogListResults();
        assertThat(actualList, equalTo(expectedList));
    }

}
