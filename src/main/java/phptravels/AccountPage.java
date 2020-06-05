package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountPage extends BasePage {
    private static String accountURL = BASE_URL + "account/";
    WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(), 'Demo')]")
    WebElement greetingMsg;

    @FindBy(className = "nav-link")
    List<WebElement> navLinks;

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

    @FindBy(linkText = "DEMO")
    WebElement demoBtn;

    @FindBy(linkText = "Logout")
    WebElement logout;

    @FindBy(id = "footer")
    WebElement footerMenu;


    public AccountPage(WebDriver driver){
        super(driver);
    }

    public String getURL() {
        return accountURL;
    }

    public void clickOnLink(String linkName) {
        for (WebElement el: navLinks) {
            WebElement linkNameEl = el.findElement(By.xpath("//*[contains(text(),'"+linkName+"')]"));
            if(linkNameEl.isDisplayed()) {
                linkNameEl.click();
            }
        }
    }

    public void clickOnElement(String el) {
        footerMenu.findElement(By.linkText(el)).click();
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

    public void chooseCurrency(String currency) {
        dropdownCurrency.click();
        WebElement selectCurrency = dropdownCurrency.findElement(By.xpath("//a[contains(text(), '"+currency+"')]"));
        selectCurrency.click();
    }

    public void chooseLanguage(String language) {
        dropdownLangauge.click();
        WebElement selectLanguage = dropdownLangauge.findElement(By.xpath("//a[contains(text(), '"+language+"')]"));
        selectLanguage.click();
    }

    public void logout() {
        demoBtn.click();
        logout.click();
    }
}
