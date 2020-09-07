package hw5;

import hw4.base.DriverFactory;
import hw5.context.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class CucumberTests extends AbstractTestNGCucumberTests {

    @Before
    public void setUp() {
        Context.getInstance().setDriver(DriverFactory.getDriver());
    }

    @After
    public void tearDown() {
        Context.getInstance().getDriver().quit();
    }
}
