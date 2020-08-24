package hw4;

import hw4.base.BaseTests;
import hw4.base.TestListener;
import hw4.pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Inspect Home Page")
@Listeners(TestListener.class)
public class FailTest extends BaseTests {
    @Test
    public void testHomePageFail() {
        HomePage homePage = openUrl();
        //Assert Browser title
        assertHomePageTitle(homePage);
    }
}
