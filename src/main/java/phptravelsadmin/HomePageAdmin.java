package phptravelsadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL;
    WebDriver driver;

    @FindBy(xpath = "//li[@id='account']/a[@href='https://www.phptravels.net/admin/profile']")
    WebElement accountLink;

    @FindBy(linkText = "SEE MORE ON THE BLOG")
    WebElement moreOnBlog;

    @FindBy(css = ".hZRXsd.sc-emmjRN")
    WebElement documentation;

    @FindBy(css = ".ciBMsP.sc-emmjRN")
    WebElement integrations;

    public HomePageAdmin(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void enterToElement(WebElement el, String value) {
        el.sendKeys(value);
    }

    public HomePageAdmin clickOnAccountLink() {
        accountLink.click();
        return this;
    }

    public void clickOnMoreOnBlogLink() {
        moreOnBlog.click();
    }

    public void clickOnDocumentationLink() {
        documentation.click();
    }

    public void clickOnIntegrationsLink() {
        integrations.click();
    }
}