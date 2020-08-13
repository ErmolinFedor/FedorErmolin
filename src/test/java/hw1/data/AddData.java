package hw1.data;

import org.testng.annotations.DataProvider;

public class AddData {
    @DataProvider(name = "addData")
    public static Object[][] baseData() {
        return new Object[][] {
                {1d, 1d, 2d},
                {0d, 1d, 1d},
                {1d, 0d, 1d},
                {4d, 2d, 6d},
        };
    }
}
