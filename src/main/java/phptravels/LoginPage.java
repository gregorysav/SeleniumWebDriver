package phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static String BASE_URL = "https://www.phptravels.net/login";
    WebDriver driver;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "loginbtn")
    WebElement btnSubmit;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void enterToElement(WebElement el, String value) {
        el.sendKeys(value);
    }

    public void submitForm() {
        enterToElement(username, "user@phptravels.com");
        enterToElement(password, "demouser");
        btnSubmit.click();
    }

}
