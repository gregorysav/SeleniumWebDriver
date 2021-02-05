package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private static WebDriver driver;

    public TestBase() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\workspace_offline\\chromedriver.exe");
//        this.driver = new ChromeDriver();
//        this.driver.manage().window().maximize();
//        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("version", "87.0.4280.66");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:5555/wd/hub"), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }
}
