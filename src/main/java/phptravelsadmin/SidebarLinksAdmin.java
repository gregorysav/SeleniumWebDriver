package phptravelsadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarLinksAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL;
    WebDriver driver;

    @FindBy(css = "#sidebar")
    WebElement sidebar;

    @FindBy(xpath = "//a/*[contains(text(), 'Dashboard')]")
    WebElement dashboard;

    @FindBy(xpath = "//a/*[contains(text(), 'Updates')]")
    WebElement updates;

    @FindBy(linkText = "MODULES")
    WebElement modules;

    @FindBy(xpath = "//a[@href='#menu-ui']")
    WebElement general;

    @FindBy(xpath = "//a[@href='#ACCOUNTS']")
    WebElement accounts;

    @FindBy(xpath = "//a[@href='#CMS']")
    WebElement cms;

    @FindBy(xpath = "//a[@href='#Hotels']")
    WebElement hotels;

    @FindBy(xpath = "//ul[@id='Hotels']")
    WebElement hotelsDropdown;

    @FindBy(xpath = "//a[@href='#Flights']")
    WebElement flights;

    @FindBy(xpath = "//a[@href='#Cartrawler']")
    WebElement cartrawler;

    @FindBy(xpath = "//a[@href='#Ivisa']")
    WebElement visa;

    @FindBy(xpath = "//a[@href='#Blog']")
    WebElement blog;

    @FindBy(xpath = "//a[@href='#Locations']")
    WebElement locations;

    @FindBy(xpath = "//a[@href='#SPECIAL_OFFERS']")
    WebElement special_offers;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/coupons/']")
    WebElement coupons;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/newsletter/']")
    WebElement newsletter;

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/bookings']")
    WebElement bookings;

    @FindBy(xpath = "//a[@href='#PAYOUTS']")
    WebElement payouts;


    public SidebarLinksAdmin(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void clickOnDashboardLink() {
        dashboard.click();
    }

    public void clickOnUpdatesLink() {
        updates.click();
    }

    public void clickOnModulesLink() {
        modules.click();
    }

    public void clickOnGeneralLink() {
        general.click();
    }

    public void clickOnAccountsLink() {
        accounts.click();
    }

    public void clickOnCMSLink() {
        cms.click();
    }

    public void clickOnHotelsLink() {
        hotels.click();
    }

    public void clickOnFlightsLink() {
        flights.click();
    }

    public void clickOnCartrawlerLink() { cartrawler.click(); }

    public void clickOnVisaLink() { visa.click(); }

    public void clickOnBlogLink() { blog.click(); }

    public void clickOnLocationsLink() { locations.click(); }

    public void clickOnSpecialOffersLink() { special_offers.click(); }

    public boolean checkGeneralLinks(String value) {
        if (value.equals("email") || value.equals("sms_settings")) {
            return sidebar.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/templates/"+ value +"/']")).isDisplayed();
        } else if (value.equals("backup") || value.equals("banip")) {
            return sidebar.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/"+ value +"/']")).isDisplayed();
        } else if (sidebar.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/settings/"+ value +"/']")).isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkAccountsLinks(String value) {
        WebElement el = accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/accounts/"+ value +"/']"));
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkCMSLinks(String value) {
        WebElement el;
        if (value.equals("menu")) {
            el = accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/cms/menus/manage']"));
        } else {
            el = accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/cms']"));
        }
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkHotelsLinks(String value) {
        WebElement el;
        if (value.equals("")) {
            el = hotelsDropdown.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/hotels']"));
        } else {
            el = hotelsDropdown.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/hotels/"+ value +"']"));
        }
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkFlightsLinks(String value) {
        WebElement el = flights.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/flights/"+ value +"']"));
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkCartrawlerLinks() {
        WebElement el = sidebar.findElement(By.xpath("//ul[@id='Cartrawler']//a[@href='https://www.phptravels.net/admin/cartrawler/settings']"));
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkVisaLinks(String value) {
        WebElement el = sidebar.findElement(By.xpath("//ul[@id='Ivisa']//a[@href='https://www.phptravels.net/admin/ivisa/"+ value+"']"));
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkBlogLinks(String value) {
        WebElement el;
        if (value.equals("")) {
            el = sidebar.findElement(By.xpath("//ul[@id='Blog']//a[@href='https://www.phptravels.net/admin/blog']"));
        } else {
            el = sidebar.findElement(By.xpath("//ul[@id='Blog']//a[@href='https://www.phptravels.net/admin/blog/"+ value +"']"));
        }
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkLocationsLinks() {
        WebElement el = sidebar.findElement(By.xpath("//ul[@id='Locations']//a[@href='https://www.phptravels.net/admin/locations']"));
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkSpecialOffersLinks(String value) {
        WebElement el;
        if (value.equals("")) {
            el = sidebar.findElement(By.xpath("//ul[@id='SPECIAL_OFFERS']//a[@href='https://www.phptravels.net/admin/offers/']"));
        } else {
            el = sidebar.findElement(By.xpath("//ul[@id='SPECIAL_OFFERS']//a[@href='https://www.phptravels.net/admin/offers/"+ value +"/']"));
        }
        if (el.isDisplayed()) {
            return true;
        }
        return false;
    }
}