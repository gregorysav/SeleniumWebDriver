package phptravelstests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phptravels.AccountPage;
import phptravels.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAccountPageLinks {
    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        loginPage = new LoginPage(driver);
        loginPage.submitForm();
        Assert.assertFalse(loginPage.isResultLoginDisplayed());
    }

    @AfterTest
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        accountPage.logout();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.close();
    }

    @Test
    public void validateVisaLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnMobileMenuElement("Visa");
        Assert.assertTrue(driver.getCurrentUrl().contains("m-visa"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateSignUpLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Supplier Sign Up");
        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(signupTabs.get(1));
        wait.until(ExpectedConditions.urlContains("supplier-register"));
        Assert.assertTrue(driver.getCurrentUrl().contains("supplier-register"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(signupTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));

    }

    @Test
    public void validateLoginLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Supplier Login");
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        wait.until(ExpectedConditions.urlContains("supplier"));
        Assert.assertTrue(driver.getCurrentUrl().contains("supplier"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateContactLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Contact");
        Assert.assertTrue(driver.getCurrentUrl().contains("contact-us"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateHowToBookLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("How to Book");
        Assert.assertTrue(driver.getCurrentUrl().contains("How-to-Book"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateBookingTipsLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Booking Tips");
        Assert.assertTrue(driver.getCurrentUrl().contains("Booking-Tips"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateAboutUsLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("About Us");
        Assert.assertTrue(driver.getCurrentUrl().contains("About-Us"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateFAQLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("FAQ");
        Assert.assertTrue(driver.getCurrentUrl().contains("FAQ"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateOurPartnersLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Our Partners");
        Assert.assertTrue(driver.getCurrentUrl().contains("Our-Partners"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validatePrivacyPolicyLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Privacy Policy");
        Assert.assertTrue(driver.getCurrentUrl().contains("Privacy-Policy"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateTermsOfUseLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.clickOnFooterElement("Terms of Use");
        Assert.assertTrue(driver.getCurrentUrl().contains("Terms-of-Use"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validateAppStoreDeviceLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        accountPage.downloadOnDevice("IOS");
        List<String> appStoreTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(appStoreTabs.get(1));
        wait.until(ExpectedConditions.urlContains("apps.apple.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("apps.apple.com"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(appStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @Test
    public void validatePlayStoreDeviceLink(Method method) throws IOException {
        accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
        accountPage.downloadOnDevice("Android");
        List<String> playStoreTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(playStoreTabs.get(1));
        wait.until(ExpectedConditions.urlContains("play.google.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("play.google.com"));
        accountPage.createInstantPrintscreen(method.getName());
        driver.close();
        driver.switchTo().window(playStoreTabs.get(0));
        wait.until(ExpectedConditions.urlContains("account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }
}