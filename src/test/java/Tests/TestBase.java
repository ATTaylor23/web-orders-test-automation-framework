package Tests;

import Utilities.Driver;
import Utilities.PropertyReader;
import Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Locale;

public class TestBase {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){


        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){ Driver.quitDriver(); }

    public static void main(String[] args) throws InterruptedException {

        Driver.getDriver().get("https://www.duotech.io/");
        Thread.sleep(2000);
        SeleniumUtils.getScreenshotOnPass();

    }
}
