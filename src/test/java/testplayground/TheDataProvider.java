package testplayground;

import org.testng.annotations.DataProvider;

public class TheDataProvider {
    @DataProvider(name = "MyProvidedData")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"https://www.google.com/", "google"},
                {"https://www.guru99.com/", "guru99"}
        };
    }
}