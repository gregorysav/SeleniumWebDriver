package phptravels;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage {
    private static String BASE_URL = "https://www.phptravels.net/account/";
    WebDriver driver;
    BookingsPage bookingsPage;

    @FindBy(xpath = "//h3[contains(text(), 'Demo')]")
    WebElement greetingMsg;

    @FindBy(className = "nav-link")
    List<WebElement> navLinks;

    @FindBy(xpath = "//*[contains(text(),'Wishlist')]")
    WebElement wishlist;

    @FindBy(name = "firstname")
    WebElement firstname;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(xpath = "//div[@id='bookings']/div[@class='row']")
    List<WebElement> bookingList;

    @FindBy(id = "dropdownCurrency")
    WebElement dropdownCurrency;

    @FindBy(id = "dropdownLangauge")
    WebElement dropdownLangauge;

    @FindBy(xpath = "/html//header[@id='//header-waypoint-sticky']/div[@class='header-top']/div[@class='container-fluid']//ul//div[@class='dropdown dropdown-login dropdown-tab']/a[@id='dropdownCurrency']")
    WebElement demoBtn;

    @FindBy(xpath = "//a[contains(text(), 'Invoice')]")
    WebElement invoiceBtn;

    @FindBy(xpath = "/html//header[@id='//header-waypoint-sticky']/div[@class='header-top']/div[@class='container-fluid']//ul//div[@class='dropdown-menu dropdown-menu-right show']//a[@href='https://www.phptravels.net/account/logout/']")
    WebElement logout;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickOnLink(String linkName) {
        elementIsPresent(greetingMsg);
        for (WebElement el: navLinks) {
            WebElement linkNameEl = el.findElement(By.xpath("//*[contains(text(),'"+linkName+"')]"));
            if(linkNameEl.isDisplayed()) {
                linkNameEl.click();
            }
        }
        return this;
    }

    public boolean elementIsPresent(WebElement el) {
        return el.isDisplayed();
    }

    public boolean fieldHasValue(WebElement el, String value) {
        return el.getText().equals(value);
    }

    public AccountPage checkMyProfile() {
        fieldHasValue(firstname, "Demo");
        fieldHasValue(lastname, "User");
        fieldHasValue(email, "user@phptravels.com");
        return this;
    }

    public AccountPage checkBookings() {
        bookingsPage = new BookingsPage(driver);
        bookingsPage.checkBookingRow();
        return this;
    }

    public AccountPage chooseCurrency(String currency) {
        dropdownCurrency.click();
        WebElement selectCurrency = driver.findElement(By.xpath("//div[@class='dropdown-menu-inner']/a[contains(text(), '"+currency+"')]"));
        selectCurrency.click();
        return this;
    }

    public AccountPage chooseLanguage(String language) {
        dropdownLangauge.click();
        WebElement selectLanguage = driver.findElement(By.xpath("//div[@class='dropdown-menu-inner']/a[contains(text(), '"+language+"')]"));
        selectLanguage.click();
        return this;
    }

    public AccountPage checkWishlist() {
        wishlist.click();
        driver.findElement(By.xpath("//h4[contains(text(), 'No Wishlist Items Found')]"));
        return this;
    }

    public void goToInvoice() {
        elementIsPresent(invoiceBtn);
        invoiceBtn.click();
    }

    public static int getBookingInfo(String requestInfo) {
        int returnValue = 0;
        switch (requestInfo) {
            case "Booking ID" :
                returnValue = 31;
                break;
            case "Booking Number" :
                returnValue = 923;
                break;
            default:
                returnValue = -1;
        }
        return returnValue;
    }

    public void logout() {
        demoBtn.click();
        logout.click();
    }
}
