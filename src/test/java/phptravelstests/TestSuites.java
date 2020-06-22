package phptravelstests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravels.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestSuites {
    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;
    MyProfile myProfile;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPage = new LoginPage(driver);
        loginPage.submitForm();
        Assert.assertFalse(loginPage.isResultLoginDisplayed());
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPage.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void validateAccountPage(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlMatches(accountPage.getURL()));
        accountPage.clickOnLink("Bookings");
        Assert.assertTrue(accountPage.locateBookingElement("Rendezvous Hotels"));
        Assert.assertTrue(accountPage.locateBookingElement("Singapore"));
        accountPage.clickOnLink("My Profile");
        Assert.assertTrue(accountPage.checkMyProfile());
        accountPage.chooseCurrency(Currency.EUR.toString());
        accountPage.chooseLanguage(Languages.English.toString());
        accountPage.createInstantPrintscreen(method.getName());
    }

    @Test
    public void editMyProfile(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        accountPage.clickOnLink("My Profile");
        myProfile = new MyProfile(driver);
        myProfile.setMyProfileInformation("Karagatsi 2", "Koz", "11551", "Greece");
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
        accountPage.createInstantPrintscreen(method.getName());
    }
}