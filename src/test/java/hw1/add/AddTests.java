package hw1.add;

import hw1.base.BaseTests;
import hw1.data.AddData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTests extends BaseTests {

    @Test(dataProvider = "addData", dataProviderClass = AddData.class)
    public void addPositiveTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, "Wrong sum");
    }
}
