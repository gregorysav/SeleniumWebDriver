package phptravelstestadmin;

import io.qameta.allure.Link;
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
import phptravelsadmin.SidebarLinksAdmin;

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
    String[] visaLinks = {"settings", "bookings"};
    String[] blogLinks = {"category", "settings"};
    String[] offersLinks = {"settings"};

    @Parameters({ "chromeDriver" })
    @BeforeTest(description = "Start chrome web driver and log in")
    public void setup(String chromeDriver) {
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

    @Test(description = "Validate Dashboard information")
    @Link(name="Base page", url="https://www.phptravels.net/admin")
    public void validateDashboardLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnDashboardLink();
        wait.until(ExpectedConditions.urlContains("admin"));
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
    }

    @Test(description = "Validate Updates link works correctly")
    public void validateUpdatesLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnUpdatesLink();
        wait.until(ExpectedConditions.urlContains("admin/updates"));
        assertThat(driver.getCurrentUrl().contains("admin/updates")).isTrue();
    }

    @Test(description = "Validate Modules link works correctly")
    public void validateModulesLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnModulesLink();
        wait.until(ExpectedConditions.urlContains("admin/settings/modules"));
        assertThat(driver.getCurrentUrl().contains("admin/settings/modules")).isTrue();
    }

    @Test(description = "Validate General link works correctly")
    public void validateGeneralLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnGeneralLink();
        for (String link: generalLinks ) {
            assertThat(sidebarLinksAdmin.checkGeneralLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate Accounts link works correctly")
    public void validateAccountsLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnAccountsLink();
        for (String link: accountsLinks ) {
            assertThat(sidebarLinksAdmin.checkAccountsLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate CMS link works correctly")
    public void validateCMSLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnCMSLink();
        assertThat(sidebarLinksAdmin.checkCMSLinks("")).isTrue();
        assertThat(sidebarLinksAdmin.checkCMSLinks("menu")).isTrue();
    }

    @Test(description = "Validate Hotels link works correctly")
    public void validateHotelsLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnHotelsLink();
        for (String link: hotelsLinks ) {
            assertThat(sidebarLinksAdmin.checkHotelsLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate Flights link works correctly")
    public void validateFlightsLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnFlightsLink();
        for (String link: flightsLinks ) {
            assertThat(sidebarLinksAdmin.checkFlightsLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate Cartrawler link works correctly")
    public void validateCartrawlerLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnCartrawlerLink();
        assertThat(sidebarLinksAdmin.checkCartrawlerLinks()).isTrue();
    }

    @Test(description = "Validate Visa link works correctly")
    public void validateVisaLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnVisaLink();
        for (String link: visaLinks ) {
            assertThat(sidebarLinksAdmin.checkVisaLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate Blog link works correctly")
    public void validateBlogLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnBlogLink();
        for (String link: blogLinks ) {
            assertThat(sidebarLinksAdmin.checkBlogLinks(link)).isTrue();
        }
    }

    @Test(description = "Validate Locations link works correctly")
    public void validateLocationsLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnLocationsLink();
        assertThat(sidebarLinksAdmin.checkLocationsLinks()).isTrue();
    }

    @Test(description = "Validate Offers link works correctly")
    public void validateOffersLink() {
        wait = new WebDriverWait(driver, 10);
        assertThat(driver.getCurrentUrl().contains("admin")).isTrue();
        sidebarLinksAdmin = new SidebarLinksAdmin(driver);
        sidebarLinksAdmin.clickOnSpecialOffersLink();
        for (String link: offersLinks ) {
            assertThat(sidebarLinksAdmin.checkSpecialOffersLinks(link)).isTrue();
        }
    }
}