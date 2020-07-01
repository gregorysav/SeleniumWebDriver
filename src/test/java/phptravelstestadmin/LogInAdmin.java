package phptravelstestadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravelsadmin.HomePageAdmin;
import phptravelsadmin.LoginPageAdmin;
import phptravelsadmin.ProfilePageAdmin;
import phptravelsuser.AccountPageUserUser;
import phptravelsuser.LoginPageUser;
import phptravelsuser.MyProfileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogInAdmin {
    WebDriver driver;
    WebDriverWait wait;
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
        Assert.assertTrue(driver.getCurrentUrl().contains("admin/profile"));
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
        Assert.assertTrue(driver.getCurrentUrl().contains("blog"));
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateDocumentationLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnDocumentationLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("documentation"));
        Assert.assertTrue(driver.getCurrentUrl().contains("documentation"));
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateIntegrationsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        homePageAdmin = new HomePageAdmin(driver);
        homePageAdmin.clickOnIntegrationsLink();
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("integrations"));
        Assert.assertTrue(driver.getCurrentUrl().contains("integrations"));
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }
}
