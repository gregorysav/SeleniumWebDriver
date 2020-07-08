package phptravelsadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementSectionAdmin extends BasePageAdmin {
    private static String loginURL = BASE_URL;
    WebDriver driver;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[1]/div[2]/div")
    WebElement managementTools;

    @FindBy(xpath = "//a[@href='https://accounts.google.com']")
    WebElement googleAccounts;

    @FindBy(xpath = "//a[@href='https://analytics.google.com/']")
    WebElement googleAnalytics;

    @FindBy(xpath = "//a[@href='https://developers.google.com/speed/pagespeed/insights/?url=https://www.phptravels.net/']")
    WebElement googleDevs;

    @FindBy(xpath = "//a[@href='https://lc.chat/9DXgj']")
    WebElement liveChat;

    @FindBy(xpath = "//a[@href='https://www.sendinblue.com/?tap_a=30591-fb13f0&tap_s=695091-c3a1d0']")
    WebElement sendinBlue;

    @FindBy(xpath = "//a[@href='http://inmotion-hosting.evyy.net/c/2032933/260033/4222']")
    WebElement inmotionHosting;


    public ManagementSectionAdmin(WebDriver driver){
        super(driver);
        driver.get(loginURL);
    }

    public void clickOnGoogleAccountsLink() { googleAccounts.click(); }

    public void clickOnGoogleAnalyticsLink() { googleAnalytics.click(); }

    public void clickOnGoogleDevsLink() { googleDevs.click(); }

    public void clickOnLiveChatLink() { liveChat.click(); }

    public void clickOnSendinBlueLink() { sendinBlue.click(); }

    public void clickOnInmotionHostingLink() { inmotionHosting.click(); }

}
