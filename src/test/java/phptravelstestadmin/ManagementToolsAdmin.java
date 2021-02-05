package phptravelstestadmin;

import base.TestBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravelsadmin.LoginPageAdmin;
import phptravelsadmin.ManagementSectionAdmin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagementToolsAdmin {
    WebDriver driver = TestBase.getWebDriver();
    WebDriverWait wait;
    LoginPageAdmin loginPageAdmin;
    ManagementSectionAdmin managementSectionAdmin;

    @BeforeTest(description = "Set browser")
    public void setRemoteWebdriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageAdmin = new LoginPageAdmin(driver);
        loginPageAdmin.submitForm();
    }

    @AfterTest(description = "Close browser")
    public void cleanup() {
        driver.quit();
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