package testplayground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPlayground {
    WebDriver driver;

    @BeforeTest(description = "Start chrome web driver")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\workspace_offline\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @AfterTest(description = "Close web driver")
    public void cleanup() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.close();
    }

    @Test(dataProvider = "MyProvidedData", dataProviderClass = TheDataProvider.class)
    public void TestDemo(String url, String value) {
        driver.navigate().to(url);
        Assert.assertTrue(driver.getCurrentUrl().contains(value));
    }
}