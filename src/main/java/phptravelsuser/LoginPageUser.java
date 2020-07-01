package phptravelsuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageUser extends BasePageUser {
    private static String loginURL = BASE_URL + "login";
    WebDriver driver;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "loginbtn")
    WebElement btnSubmit;

    @FindBy(className = "resultlogin")
    WebElement resultLogin;

    public LoginPageUser(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void enterToElement(WebElement el, String value) {
        el.sendKeys(value);
    }

    public void submitForm() {
        enterToElement(username, "user@phptravels.com");
        enterToElement(password, "demouser");
        btnSubmit.click();
    }

    public boolean isResultLoginDisplayed() {
        return resultLogin.isDisplayed();
    }
}
