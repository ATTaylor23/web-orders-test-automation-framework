package Tests;

import Pages.AllOrdersPage;
import Pages.LoginPage;
import Utilities.Driver;
import Utilities.PropertyReader;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class allOrdersTest extends TestBase {


    @Test (groups = {"smoke"})
    public void verifyCheckAllButton() throws IOException {

        Driver.getDriver().get(PropertyReader.readProperties("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.readProperties("username"), Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test (groups = {"smoke"})
    public void verifyCheckAllButtonUsingPageObjectModel() throws IOException {

        Driver.getDriver().get(PropertyReader.readProperties("url"));

        //login page
        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys(PropertyReader.readProperties("username"));
        loginPage.password.sendKeys(PropertyReader.readProperties("password"));
        loginPage.loginButton.click();

        // all orders page
        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.checkAllButton.click();

        for (WebElement checkbox : allOrdersPage.checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test
    public void verifyUnCheckAllButton()  {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

    }


}
