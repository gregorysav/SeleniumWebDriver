package phptravelstests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import phptravels.AccountPage;
import phptravels.Currency;
import phptravels.Languages;
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
    }

    @After
    public void cleanup() {
        accountPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void validateAccountPage() {
        accountPage = new AccountPage(driver);
        accountPage.clickOnLink("Bookings");
        Assert.assertTrue(accountPage.locateBookingElement("Rendezvous Hotels"));
        Assert.assertTrue(accountPage.locateBookingElement("Singapore"));
        accountPage.clickOnLink("My Profile");
        Assert.assertTrue(accountPage.checkMyProfile());
        Assert.assertTrue(accountPage.checkWishlist());
        accountPage.chooseCurrency(Currency.EUR.toString());
        accountPage.chooseLanguage(Languages.English.toString());
    }
}
