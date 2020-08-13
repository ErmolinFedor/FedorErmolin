package hw1.multiply;

import hw1.base.BaseTests;
import hw1.data.MultiplyData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTests extends BaseTests {
    @Test(dataProvider = "multiplyData", dataProviderClass = MultiplyData.class)
    public void multiplyTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, "Wrong multiply");
    }
}
