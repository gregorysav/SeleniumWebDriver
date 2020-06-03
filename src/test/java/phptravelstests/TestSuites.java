package phptravelstests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import phptravels.AccountPage;
import phptravels.LoginPage;

public class TestSuites {
    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.submitForm();
        accountPage = new AccountPage(driver);
    }

    @After
    public void cleanup() {
        accountPage = new AccountPage(driver);
        accountPage.logout();
        driver.close();
    }

    @Test
    public void validateAccountPage() {
        accountPage
                .clickOnLink("My Profile")
                .checkMyProfile()
                .clickOnLink("Bookings")
                .checkBookings()
                .checkWishlist()
                .chooseCurrency("EUR")
                .chooseLanguage("English");
    }
}
