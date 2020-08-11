package hw1.data;

import org.testng.annotations.DataProvider;

public class DivideData {
    @DataProvider(name = "divideData")
    public static Object[][] baseData() {
        return new Object[][] {
                {2d, 1d, 2d},
                {12d, 3d, 4d},
                {16d, 2d, 8d},
                {27d, 3d, 9d},
        };
    }
}
