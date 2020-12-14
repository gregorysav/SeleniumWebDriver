package phptravelstestadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import phptravelsadmin.HomePageAdmin;
import phptravelsadmin.LoginPageAdmin;
import phptravelsadmin.ProfilePageAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogInAdmin {
    WebDriver driver;
    LoginPageAdmin loginPageAdmin;
    HomePageAdmin homePageAdmin;
    ProfilePageAdmin profilePageAdmin;

    @BeforeTest(description = "Start chrome web driver and log in")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\workspace_offline\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageAdmin = new LoginPageAdmin(driver);
        loginPageAdmin.submitForm();

    }

    @AfterTest(description = "Sign out and close web driver")
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        loginPageAdmin.clickOnLogoutLink();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("admin"));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        driver.close();
    }

    @Test(description = "Set profile information")
    public void setProfileInformation() {
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnAccountLink();
        assertThat(driver.getCurrentUrl().contains("admin/profile")).isTrue();
        profilePageAdmin = new ProfilePageAdmin(driver);
        profilePageAdmin.setProfileInformation("FNAME", "LNAME", "98765", "Address 1st");
    }

    @Test(description = "Validate blog link works correctly")
    public void validateMoreOnBlogLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnMoreOnBlogLink();
//        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("blog"));
        assertThat(driver.getCurrentUrl().contains("blog")).isTrue();
//        driver.close();
//        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate documentation link works correctly")
    public void validateDocumentationLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnDocumentationLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("docs.phptravels.com"));
        assertThat(driver.getCurrentUrl().contains("docs.phptravels.com")).isTrue();
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate integrations link works correctly")
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

    @Test(description = "Validate bookings link works correctly")
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

    @Test(description = "Validate CMS Pages link works correctly")
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

    @Test(description = "Validate Server Header Blog link works correctly")
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

    @Test(description = "Validate Server Header Newsletter link works correctly")
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

    @Test(description = "Validate Server Header Backup link works correctly")
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