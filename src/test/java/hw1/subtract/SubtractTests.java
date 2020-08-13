package hw1.subtract;

import com.epam.tat.module4.Calculator;
import hw1.base.BaseTests;
import hw1.data.MultiplyData;
import hw1.data.SubtractData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTests extends BaseTests {
    @Test(dataProvider = "subtractData", dataProviderClass = SubtractData.class)
    public void subtractPositiveTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, "Wrong subtract");
    }
}
