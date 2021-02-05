package phptravelsadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL + "/profile";
    WebDriver driver;

    @FindBy(xpath = "//div[@id='content']/form/div[@class='panel panel-default']/div[@class='panel-body']//div[@class='col-md-12']/div/input")
    WebElement accountType;

    @FindBy(name = "fname")
    WebElement firstName;

    @FindBy(name = "lname")
    WebElement lastName;

    @FindBy(name = "mobile")
    WebElement mobile;

    @FindBy(name = "address1")
    WebElement addressOne;

    @FindBy(css = ".panel-footer .btn-primary")
    WebElement submitBtn;

    public ProfilePageAdmin(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void enterToElement(WebElement el, String value) {
        el.sendKeys(value);
    }

    public void setElementsValue(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }

    public void setProfileInformation(String firstname, String lastname, String mobileNumber, String addressone) {
        setElementsValue(firstName, firstname);
        setElementsValue(lastName, lastname);
        setElementsValue(mobile, mobileNumber);
        setElementsValue(addressOne, addressone);
        submitBtn.click();
    }
}