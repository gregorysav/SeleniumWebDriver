package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage {
    private static String BASE_URL = "https://www.phptravels.net/account/";
    WebDriver driver;

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

    @FindBy(xpath = "//a[contains(text(), 'Invoice')]")
    WebElement invoiceBtn;

    @FindBy(linkText = "DEMO")
    WebElement demoBtn;

    @FindBy(linkText = "Logout")
    WebElement logout;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLink(String linkName) {
        for (WebElement el: navLinks) {
            WebElement linkNameEl = el.findElement(By.xpath("//*[contains(text(),'"+linkName+"')]"));
            if(linkNameEl.isDisplayed()) {
                linkNameEl.click();
            }
        }
    }

    public boolean elementIsPresent(WebElement el) {
        return el.isDisplayed();
    }

    private boolean fieldHasValue(WebElement el, String value) {
        return el.getAttribute("value").equals(value);
    }

    public boolean checkMyProfile() {
        if (fieldHasValue(firstname, "Demo") && fieldHasValue(lastname, "User") && fieldHasValue(email, "user@phptravels.com")) {
            return true;
        }
        return false;
    }

    public boolean locateBookingElement(String elementName) {
        for (WebElement el: bookingList) {
            WebElement findElement = el.findElement(By.xpath("//*[contains(text(), '"+elementName+"')]"));
            if (findElement.isDisplayed()) {
                return true;
            }
        }
        return false;
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

    public boolean checkWishlist() {
        wishlist.click();
        return driver.findElement(By.xpath("//h4[contains(text(), 'No Wishlist Items Found')]")).isDisplayed();
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
