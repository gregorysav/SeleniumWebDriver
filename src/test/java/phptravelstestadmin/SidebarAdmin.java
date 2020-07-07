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
import phptravelsadmin.SidebarLinksAdmin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SidebarAdmin {
    WebDriver driver;
    WebDriverWait wait;
    LoginPageAdmin loginPageAdmin;
    SidebarLinksAdmin sidebarLinksAdmin;
    String[] generalLinks = {"currencies", "paymentgateways", "social", "widgets", "sliders", "email", "sms_settings", "backup", "banip"};
    String[] accountsLinks = {"admins", "suppliers", "customers", "guest"};
    String[] hotelsLinks = {"", "rooms", "extras", "reviews", "settings"};
    String[] flightsLinks = {"routes", "airports", "settings", "airlines", "countries"};

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
    public void validateDashboardLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnDashboardLink();
        wait.until(ExpectedConditions.urlContains("admin"));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    public void validateUpdatesLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnUpdatesLink();
        wait.until(ExpectedConditions.urlContains("admin/updates"));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin/updates"));
    }

    @Test
    public void validateModulesLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnModulesLink();
        wait.until(ExpectedConditions.urlContains("admin/settings/modules"));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin/settings/modules"));
    }

    @Test
    public void validateGeneralLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnGeneralLink();
        for (String link: generalLinks ) {
            Assert.assertTrue(sidebarLinksAdmin.checkGeneralLinks(link));
        }
    }

    @Test
    public void validateAccountsLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnAccountsLink();
        for (String link: accountsLinks ) {
            Assert.assertTrue(sidebarLinksAdmin.checkAccountsLinks(link));
        }
    }

    @Test
    public void validateCMSLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnCMSLink();
        Assert.assertTrue(sidebarLinksAdmin.checkCMSLinks(""));
        Assert.assertTrue(sidebarLinksAdmin.checkCMSLinks("menu"));
    }

    @Test
    public void validateHotelsLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnHotelsLink();
        for (String link: hotelsLinks ) {
            Assert.assertTrue(sidebarLinksAdmin.checkHotelsLinks(link));
        }
    }

    @Test
    public void validateFlightsLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnFlightsLink();
        for (String link: flightsLinks ) {
            Assert.assertTrue(sidebarLinksAdmin.checkFlightsLinks(link));
        }
    }

    @Test
    public void validateViatorLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnViatorLink();
        Assert.assertTrue(sidebarLinksAdmin.checkViatorLinks());
    }

    @Test
    public void validateCartrawlerLink() {
        wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnCartrawlerLink();
        Assert.assertTrue(sidebarLinksAdmin.checkCartrawlerLinks());
    }
}