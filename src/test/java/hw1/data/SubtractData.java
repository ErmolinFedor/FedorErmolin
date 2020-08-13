package hw1.data;

import org.testng.annotations.DataProvider;

public class SubtractData {
    @DataProvider(name = "subtractData")
    public static Object[][] baseData() {
        return new Object[][] {
                {1d, 1d, 0d},
                {0d, 1d, -1d},
                {1d, 0d, 1d},
                {4d, 2d, 2d},
        };
    }
}
