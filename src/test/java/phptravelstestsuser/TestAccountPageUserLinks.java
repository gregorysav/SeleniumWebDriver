package phptravelstestsuser;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravelsuser.AccountPageUserUser;
import phptravelsuser.LoginPageUser;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAccountPageUserLinks {
    WebDriver driver;
    LoginPageUser loginPage;
    AccountPageUserUser accountPageUser;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPage = new LoginPageUser(driver);
        loginPage.submitForm();
        assertThat(loginPage.isResultLoginDisplayed()).isTrue();
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPageUser.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        assertThat(driver.getCurrentUrl().contains("login")).isTrue();
        driver.close();
    }

    @Test
    public void validateVisaLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnMobileMenuElement("Visa");
        assertThat(driver.getCurrentUrl().contains("m-visa")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateSignUpLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Supplier Sign Up");
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("supplier-register"));
        assertThat(driver.getCurrentUrl().contains("supplier-register")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateLoginLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Supplier Login");
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        wait.until(ExpectedConditions.urlContains("supplier"));
        assertThat(driver.getCurrentUrl().contains("supplier")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateContactLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Contact");
        assertThat(driver.getCurrentUrl().contains("contact-us")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateHowToBookLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("How to Book");
        assertThat(driver.getCurrentUrl().contains("How-to-Book")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateBookingTipsLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Booking Tips");
        assertThat(driver.getCurrentUrl().contains("Booking-Tips")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateAboutUsLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("About Us");
        assertThat(driver.getCurrentUrl().contains("About-Us")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateFAQLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("FAQ");
        assertThat(driver.getCurrentUrl().contains("FAQ")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateOurPartnersLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Our Partners");
        assertThat(driver.getCurrentUrl().contains("Our-Partners")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validatePrivacyPolicyLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Privacy Policy");
        assertThat(driver.getCurrentUrl().contains("Privacy-Policy")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateTermsOfUseLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Terms of Use");
        assertThat(driver.getCurrentUrl().contains("Terms-of-Use")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validateAppStoreDeviceLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.downloadOnDevice("IOS");
        List<String> appStoreTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(appStoreTabs.get(1));
        wait.until(ExpectedConditions.urlContains("apps.apple.com"));
        assertThat(driver.getCurrentUrl().contains("apps.apple.com")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(appStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }

    @Test
    public void validatePlayStoreDeviceLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
        accountPageUser.downloadOnDevice("Android");
        List<String> playStoreTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(playStoreTabs.get(1));
        wait.until(ExpectedConditions.urlContains("play.google.com"));
        assertThat(driver.getCurrentUrl().contains("play.google.com")).isTrue();
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(playStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
    }
}