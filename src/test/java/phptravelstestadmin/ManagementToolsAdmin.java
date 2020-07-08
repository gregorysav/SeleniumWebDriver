package phptravelstestadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravelsadmin.LoginPageAdmin;
import phptravelsadmin.ManagementSectionAdmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagementToolsAdmin {
    WebDriver driver;
    WebDriverWait wait;
    LoginPageAdmin loginPageAdmin;
    ManagementSectionAdmin managementSectionAdmin;

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
        driver.close();
    }

    @Test
    public void validateGoogleAccountsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnGoogleAccountsLink();
        List<String> googleAccountsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleAccountsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("google"));
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        driver.close();
        driver.switchTo().window(googleAccountsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateGoogleAnalyticsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnGoogleAnalyticsLink();
        List<String> googleAnalyticsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleAnalyticsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("analytics"));
        Assert.assertTrue(driver.getCurrentUrl().contains("analytics"));
        driver.close();
        driver.switchTo().window(googleAnalyticsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateGoogleDevsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnGoogleDevsLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("developers"));
        Assert.assertTrue(driver.getCurrentUrl().contains("developers"));
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateLiveChatLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnLiveChatLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("chat"));
        Assert.assertTrue(driver.getCurrentUrl().contains("chat"));
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateSendinBlueLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnSendinBlueLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("sendinblue"));
        Assert.assertTrue(driver.getCurrentUrl().contains("sendinblue"));
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateImmotionHostingLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        managementSectionAdmin.clickOnInmotionHostingLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("inmotionhosting"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inmotionhosting"));
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }
}