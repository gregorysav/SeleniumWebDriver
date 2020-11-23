package phptravelstestsuser;

import enumpackage.Currency;
import enumpackage.Languages;
import static org.assertj.core.api.Assertions.*;
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
    AccountPageUser accountPageUser;
    MyProfileUser myProfileUser;

    @BeforeTest(description = "Start chrome web driver and log in")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\workspace_offline\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPage = new LoginPageUser(driver);
        loginPage.submitForm();
        assertThat(loginPage.isResultLoginDisplayed()).isTrue();
    }

    @AfterTest(description = "Sign out and close web driver")
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPageUser.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        assertThat(driver.getCurrentUrl().contains("login")).isTrue();
        driver.close();
    }

    @Test(description = "Validate Bookings link works correctly")
    public void validateAccountPage(Method method) throws IOException {
        accountPageUser = new AccountPageUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlMatches(accountPageUser.getURL()));
        accountPageUser.clickOnLink("Bookings");
        assertThat(accountPageUser.locateBookingElement("Rendezvous Hotels")).isTrue();
        assertThat(accountPageUser.locateBookingElement("Singapore")).isTrue();
        accountPageUser.clickOnLink("My Profile");
        assertThat(accountPageUser.checkMyProfile()).isTrue();
        accountPageUser.chooseCurrency(Currency.EUR.toString());
        accountPageUser.chooseLanguage(Languages.English.toString());
        accountPageUser.createInstantPrintscreen(method.getName());
    }

    @Test(description = "Set my profile information")
    public void editMyProfile(Method method) throws IOException {
        accountPageUser = new AccountPageUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        accountPageUser.clickOnLink("My Profile");
        myProfileUser = new MyProfileUser(driver);
        myProfileUser.setMyProfileInformation("Karagatsi 2", "Koz", "11551", "Greece");
        wait.until(ExpectedConditions.urlContains("account"));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
    }
}