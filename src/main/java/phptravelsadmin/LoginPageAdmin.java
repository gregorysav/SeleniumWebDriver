package phptravelsadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL;
    WebDriver driver;

    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "btn-lg")
    WebElement btnSubmit;

    @FindBy(className = "alert-danger")
    WebElement resultLogin;

    @FindBy(xpath = "//a[contains(@href, 'https://www.phptravels.net/admin/logout')]")
    WebElement logoutLink;

    public LoginPageAdmin(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void enterToElement(WebElement el, String value) {
        el.sendKeys(value);
    }

    public void submitForm() {
        enterToElement(username, "admin@phptravels.com");
        enterToElement(password, "demoadmin");
        btnSubmit.click();
    }

    public boolean isResultLoginDisplayed() {
        return resultLogin.isDisplayed();
    }

    public void clickOnLogoutLink() { logoutLink.click(); }
}