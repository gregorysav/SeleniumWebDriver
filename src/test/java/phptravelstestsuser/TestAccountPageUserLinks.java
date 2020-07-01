package phptravelstestsuser;

import org.junit.Assert;
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
        Assert.assertFalse(loginPage.isResultLoginDisplayed());
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPageUser.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void validateVisaLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnMobileMenuElement("Visa");
        Assert.assertTrue(driver.getCurrentUrl().contains("m-visa"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
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
        Assert.assertTrue(driver.getCurrentUrl().contains("supplier-register"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
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
        Assert.assertTrue(driver.getCurrentUrl().contains("supplier"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateContactLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Contact");
        Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateHowToBookLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("How to Book");
        Assert.assertTrue(driver.getCurrentUrl().contains("How-to-Book"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateBookingTipsLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Booking Tips");
        Assert.assertTrue(driver.getCurrentUrl().contains("Booking-Tips"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateAboutUsLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("About Us");
        Assert.assertTrue(driver.getCurrentUrl().contains("About-Us"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateFAQLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("FAQ");
        Assert.assertTrue(driver.getCurrentUrl().contains("FAQ"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateOurPartnersLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Our Partners");
        Assert.assertTrue(driver.getCurrentUrl().contains("Our-Partners"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validatePrivacyPolicyLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Privacy Policy");
        Assert.assertTrue(driver.getCurrentUrl().contains("Privacy-Policy"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateTermsOfUseLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPageUser.clickOnFooterElement("Terms of Use");
        Assert.assertTrue(driver.getCurrentUrl().contains("Terms-of-Use"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
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
        Assert.assertTrue(driver.getCurrentUrl().contains("apps.apple.com"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(appStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validatePlayStoreDeviceLink(Method method) throws IOException {
        accountPageUser = new AccountPageUserUser(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
        accountPageUser.downloadOnDevice("Android");
        List<String> playStoreTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(playStoreTabs.get(1));
        wait.until(ExpectedConditions.urlContains("play.google.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("play.google.com"));
        accountPageUser.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(playStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }
}