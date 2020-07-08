package phptravelstestadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import phptravelsadmin.HomePageAdmin;
import phptravelsadmin.LoginPageAdmin;
import phptravelsadmin.ProfilePageAdmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogInAdmin {
    WebDriver driver;
    LoginPageAdmin loginPageAdmin;
    HomePageAdmin homePageAdmin;
    ProfilePageAdmin profilePageAdmin;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPageAdmin = new LoginPageAdmin(driver);
        loginPageAdmin.submitForm();
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
//        accountPageUser.logout();
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.urlContains("login"));
//        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void setProfileInformation() {
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnAccountLink();
        assertThat(driver.getCurrentUrl().contains("admin/profile")).isTrue();
        profilePageAdmin = new ProfilePageAdmin(driver);
        profilePageAdmin.setProfileInformation("FNAME", "LNAME", "98765", "Address 1st");
    }

    @Test
    public void validateMoreOnBlogLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnMoreOnBlogLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("blog"));
        assertThat(driver.getCurrentUrl().contains("blog")).isTrue();
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateDocumentationLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnDocumentationLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("documentation"));
        assertThat(driver.getCurrentUrl().contains("documentation")).isTrue();
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateIntegrationsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnIntegrationsLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("integrations"));
        assertThat(driver.getCurrentUrl().contains("integrations")).isTrue();
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateServerHeaderBookingsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        assertThat(homePageAdmin.isServerHeaderPresent()).isTrue();
        homePageAdmin.clickOnServerHeaderButton("Bookings");
        wait.until(ExpectedConditions.urlContains("bookings"));
        assertThat(driver.getCurrentUrl().contains("bookings")).isTrue();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateServerHeaderCMSPagesLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        assertThat(homePageAdmin.isServerHeaderPresent()).isTrue();
        homePageAdmin.clickOnServerHeaderButton("CMS Pages");
        wait.until(ExpectedConditions.urlContains("cms"));
        assertThat(driver.getCurrentUrl().contains("cms")).isTrue();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateServerHeaderBlogLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        assertThat(homePageAdmin.isServerHeaderPresent()).isTrue();
        homePageAdmin.clickOnServerHeaderButton("Blog");
        wait.until(ExpectedConditions.urlContains("blog"));
        assertThat(driver.getCurrentUrl().contains("blog")).isTrue();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateServerHeaderNewsletterLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        assertThat(homePageAdmin.isServerHeaderPresent()).isTrue();
        homePageAdmin.clickOnServerHeaderButton("Newsletter");
        wait.until(ExpectedConditions.urlContains("newsletter"));
        assertThat(driver.getCurrentUrl().contains("newsletter")).isTrue();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test
    public void validateServerHeaderBackupLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        assertThat(homePageAdmin.isServerHeaderPresent()).isTrue();
        homePageAdmin.clickOnServerHeaderButton("Backup");
        wait.until(ExpectedConditions.urlContains("backup"));
        assertThat(driver.getCurrentUrl().contains("backup")).isTrue();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }
}