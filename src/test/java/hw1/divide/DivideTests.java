package hw1.divide;

import com.epam.tat.module4.Calculator;
import hw1.base.BaseTests;
import hw1.data.AddData;
import hw1.data.DivideData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTests extends BaseTests {
    @Test(dataProvider = "divideData", dataProviderClass = DivideData.class)
    public void divideTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, "Wrong divide");
    }

    @Test(dataProvider = "divideExceptionData", dataProviderClass = DivideData.class,
            expectedExceptions = NumberFormatException.class)
    public void divideExceptionTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected, "Wrong divide");
    }
}
