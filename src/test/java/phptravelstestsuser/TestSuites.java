package phptravelstestsuser;

import enumpackage.Currency;
import enumpackage.Languages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravelsuser.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestSuites {
    WebDriver driver;
    LoginPageUser loginPage;
    AccountPageUserUser accountPageUser;
    MyProfileUser myProfileUser;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPage = new LoginPageUser(driver);
        loginPage.submitForm();
        Assert.assertFalse(loginPage.isResultLoginDisplayed());
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPageUser.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void validateAccountPage(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlMatches(accountPageUser.getURL()));
        accountPageUser.clickOnLink("Bookings");
        Assert.assertTrue(accountPageUser.locateBookingElement("Rendezvous Hotels"));
        Assert.assertTrue(accountPageUser.locateBookingElement("Singapore"));
        accountPageUser.clickOnLink("My Profile");
        Assert.assertTrue(accountPageUser.checkMyProfile());
        accountPageUser.chooseCurrency(Currency.EUR.toString());
        accountPageUser.chooseLanguage(Languages.English.toString());
        accountPageUser.createInstantPrintscreen(method.getName());
    }

    @Test
    public void editMyProfile(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        accountPageUser.clickOnLink("My Profile");
        myProfileUser = new MyProfileUser(driver);
        myProfileUser.setMyProfileInformation("Karagatsi 2", "Koz", "11551", "Greece");
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
        accountPageUser.createInstantPrintscreen(method.getName());
    }
}