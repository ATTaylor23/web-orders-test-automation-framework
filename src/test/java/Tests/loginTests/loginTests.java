package Tests.loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class loginTests {


    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupClass(){ WebDriverManager.chromedriver().setup(); }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }

    @Test (groups = {"smoke"})
    public void positiveLoginTest() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }


}
