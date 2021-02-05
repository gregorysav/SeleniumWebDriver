//package phptravelstestsuser;
//
//import static org.assertj.core.api.Assertions.*;
//
//import base.TestBase;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import phptravelsuser.AccountPageUser;
//import phptravelsuser.LoginPageUser;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestAccountPageUserLinks extends TestBase {
//    WebDriver driver =TestBase.getWebDriver();
//    LoginPageUser loginPage;
//    AccountPageUser accountPageUser;
//
//    @BeforeTest(description = "Start chrome web driver and log in")
//    public void setup() {
//        loginPage = new LoginPageUser(driver);
//        loginPage.submitForm();
//        assertThat(loginPage.isResultLoginDisplayed()).isTrue();
//    }
//
//    @AfterTest(description = "Sign out and close web driver")
//    public void cleanup() throws InterruptedException {
//        Thread.sleep(3000);
//        accountPageUser.logout();
//        driver.close();
//    }
//
////    @Test
////    public void validateVisaLink(Method method) throws IOException {
////        accountPageUser = new AccountPageUser(driver);
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////        wait.until(ExpectedConditions.urlContains("account"));
////        accountPageUser.clickOnMobileMenuElement("Visa");
////        assertThat(driver.getCurrentUrl().contains("m-visa")).isTrue();
////        accountPageUser.createInstantPrintscreen(method.getName());
////        driver.navigate().back();
////        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
////    }
//
//    @Test(description = "Validate Sign up footer link works correctly")
//    public void validateSignUpLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Supplier Sign Up");
//        List<String> signupTabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(signupTabs.get(1));
//        wait.until(ExpectedConditions.urlContains("supplier-register"));
//        assertThat(driver.getCurrentUrl().contains("supplier-register")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.close();
//        driver.switchTo().window(signupTabs.get(0));
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Supplier Login footer link works correctly")
//    public void validateLoginLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Supplier Login");
//        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(browserTabs.get(1));
//        wait.until(ExpectedConditions.urlContains("supplier"));
//        assertThat(driver.getCurrentUrl().contains("supplier")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.close();
//        driver.switchTo().window(browserTabs.get(0));
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Contact footer link works correctly")
//    public void validateContactLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Contact");
//        assertThat(driver.getCurrentUrl().contains("contact-us")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate How to Book footer link works correctly")
//    public void validateHowToBookLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("How to Book");
//        assertThat(driver.getCurrentUrl().contains("How-to-Book")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Booking Tips footer link works correctly")
//    public void validateBookingTipsLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Booking Tips");
//        assertThat(driver.getCurrentUrl().contains("Booking-Tips")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate About us footer link works correctly")
//    public void validateAboutUsLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("About Us");
//        assertThat(driver.getCurrentUrl().contains("about-Us")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate FAQ footer link works correctly")
//    public void validateFAQLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("FAQ");
//        assertThat(driver.getCurrentUrl().contains("FAQ")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Our Partners footer link works correctly")
//    public void validateOurPartnersLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Our Partners");
//        assertThat(driver.getCurrentUrl().contains("Our-Partners")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Privacy Policy footer link works correctly")
//    public void validatePrivacyPolicyLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Privacy Policy");
//        assertThat(driver.getCurrentUrl().contains("Privacy-Policy")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Terms of Use footer link works correctly")
//    public void validateTermsOfUseLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.clickOnFooterElement("Terms of Use");
//        assertThat(driver.getCurrentUrl().contains("Terms-of-Use")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.navigate().back();
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate IOS link works correctly")
//    public void validateAppStoreDeviceLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        accountPageUser.downloadOnDevice("IOS");
//        List<String> appStoreTabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(appStoreTabs.get(1));
//        wait.until(ExpectedConditions.urlContains("apps.apple.com"));
//        assertThat(driver.getCurrentUrl().contains("apps.apple.com")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.close();
//        driver.switchTo().window(appStoreTabs.get(0));
//        wait.until(ExpectedConditions.urlContains("account"));
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//
//    @Test(description = "Validate Android link works correctly")
//    public void validatePlayStoreDeviceLink(Method method) throws IOException {
//        accountPageUser = new AccountPageUser(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("account"));
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//        accountPageUser.downloadOnDevice("Android");
//        List<String> playStoreTabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(playStoreTabs.get(1));
//        wait.until(ExpectedConditions.urlContains("play.google.com"));
//        assertThat(driver.getCurrentUrl().contains("play.google.com")).isTrue();
//        accountPageUser.createInstantPrintscreen(method.getName());
//        driver.close();
//        driver.switchTo().window(playStoreTabs.get(0));
//        wait.until(ExpectedConditions.urlContains("account"));
//        assertThat(driver.getCurrentUrl().contains("account")).isTrue();
//    }
//}