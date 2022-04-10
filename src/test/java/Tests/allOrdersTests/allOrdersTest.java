package Tests.allOrdersTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class allOrdersTest {


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
    public void verifyCheckAllButton()  {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test
    public void verifyUnCheckAllButton()  {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

    }


}
