package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BookingsPage {
    private static String BASE_URL = "https://www.phptravels.net/account/";
    WebDriver driver;

    @FindBy(xpath = "//div[@id='bookings']/div[@class='row']")
    List<WebElement> bookingList;

    public BookingsPage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
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

    public boolean checkBookingRow() {
        if(locateBookingElement("Rendezvous Hotels") && locateBookingElement("Singapore")) {
            return true;
        }
        return false;
    }
}
