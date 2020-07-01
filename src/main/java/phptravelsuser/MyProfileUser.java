package phptravelsuser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfileUser extends BasePageUser {
    private static String accountURL = BASE_URL + "account/";
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "address1")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "zip")
    WebElement zip;


    public MyProfileUser(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void setElementsValue(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }

    public void setMyProfileInformation(String newAddress, String newCity, String newZIP, String newCountry) {
        setElementsValue(address, newAddress);
        setElementsValue(city, newCity);
        setElementsValue(zip, newZIP);
        zip.sendKeys(Keys.ENTER);
    }

}
