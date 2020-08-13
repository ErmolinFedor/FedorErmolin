package hw1.data;

import org.testng.annotations.DataProvider;

public class MultiplyData {
    @DataProvider(name = "multiplyData")
    public static Object[][] baseData() {
        return new Object[][] {
                {1d, 1d, 1d},
                {0d, 1d, 0d},
                {3d, -5d, -15d},
                {4d, 2d, 8d},
        };
    }
}
