package phptravelstestadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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

    @Parameters({ "chromeDriver" })
    @BeforeTest(description = "Start chrome web driver and log in")
    public void setup(String chromeDriver) throws IOException {
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPageAdmin = new LoginPageAdmin(driver);
        loginPageAdmin.submitForm();
    }

    @AfterTest(description = "Sign out and close web driver")
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test(description = "Validate Google Accounts link works correctly")
    public void validateGoogleAccountsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnGoogleAccountsLink();
        List<String> googleAccountsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleAccountsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("google"));
        assertThat(driver.getCurrentUrl().contains("google")).isTrue();
        driver.close();
        driver.switchTo().window(googleAccountsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Google Analytics link works correctly")
    public void validateGoogleAnalyticsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnGoogleAnalyticsLink();
        List<String> googleAnalyticsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleAnalyticsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("analytics"));
        assertThat(driver.getCurrentUrl().contains("analytics")).isTrue();
        driver.close();
        driver.switchTo().window(googleAnalyticsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Google Devs link works correctly")
    public void validateGoogleDevsLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnGoogleDevsLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("developers"));
        assertThat(driver.getCurrentUrl().contains("developers")).isTrue();
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Live Chat link works correctly")
    public void validateLiveChatLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnLiveChatLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("chat"));
        assertThat(driver.getCurrentUrl().contains("chat")).isTrue();
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Sending Blue link works correctly")
    public void validateSendinBlueLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnSendinBlueLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("sendinblue"));
        assertThat(driver.getCurrentUrl().contains("sendinblue")).isTrue();
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Inmotion hosting link works correctly")
    public void validateInmotionHostingLink() {
        wait = new WebDriverWait(driver, 10);
        managementSectionAdmin = new ManagementSectionAdmin(driver);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        managementSectionAdmin.clickOnInmotionHostingLink();
        List<String> googleDevsTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(googleDevsTabs.get(1));
        wait.until(ExpectedConditions.urlContains("inmotionhosting"));
        assertThat(driver.getCurrentUrl().contains("inmotionhosting")).isTrue();
        driver.close();
        driver.switchTo().window(googleDevsTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }
}