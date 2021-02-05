package phptravelsadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarLinksAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL;

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

        return accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/accounts/"+ value +"/']")).isDisplayed();
    }

    public boolean checkCMSLinks(String value) {
        if (value.equals("menu")) {
            return accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/cms/menus/manage']")).isDisplayed();
        } else {
            return accounts.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/cms']")).isDisplayed();
        }
    }

    public boolean checkHotelsLinks(String value) {
        if (value.equals("")) {
            return hotelsDropdown.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/hotels']")).isDisplayed();
        } else {
            return hotelsDropdown.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/hotels/"+ value +"']")).isDisplayed();
        }
    }

    public boolean checkFlightsLinks(String value) {
        return flights.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/flights/"+ value +"']")).isDisplayed();
    }

    public boolean checkCartrawlerLinks() {
        return sidebar.findElement(By.xpath("//ul[@id='Cartrawler']//a[@href='https://www.phptravels.net/admin/cartrawler/settings']")).isDisplayed();
    }

    public boolean checkVisaLinks(String value) {
        return sidebar.findElement(By.xpath("//ul[@id='Ivisa']//a[@href='https://www.phptravels.net/admin/ivisa/"+ value+"']")).isDisplayed();
    }

    public boolean checkBlogLinks(String value) {
        if (value.equals("")) {
            return sidebar.findElement(By.xpath("//ul[@id='Blog']//a[@href='https://www.phptravels.net/admin/blog']")).isDisplayed();
        } else {
            return sidebar.findElement(By.xpath("//ul[@id='Blog']//a[@href='https://www.phptravels.net/admin/blog/"+ value +"']")).isDisplayed();         }
    }

    public boolean checkLocationsLinks() {
        return sidebar.findElement(By.xpath("//ul[@id='Locations']//a[@href='https://www.phptravels.net/admin/locations']")).isDisplayed();
    }

    public boolean checkSpecialOffersLinks(String value) {
        if (value.equals("")) {
            return sidebar.findElement(By.xpath("//ul[@id='SPECIAL_OFFERS']//a[@href='https://www.phptravels.net/admin/offers/']")).isDisplayed();
        } else {
            return sidebar.findElement(By.xpath("//ul[@id='SPECIAL_OFFERS']//a[@href='https://www.phptravels.net/admin/offers/"+ value +"/']")).isDisplayed();
        }
    }
}