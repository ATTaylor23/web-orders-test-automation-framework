package Tests;

import Pages.LoginPage;
import Utilities.Driver;
import Utilities.PropertyReader;
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


public class loginTests extends TestBase {


    @Test (groups = {"smoke"})
    public void positiveLoginTest() throws InterruptedException {

        Driver.getDriver().get(PropertyReader.readProperties("url"));

       // Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.readProperties("username"), Keys.TAB, PropertyReader.readProperties("password"), Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.readProperties("username"));

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(PropertyReader.readProperties("password"));

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Test (groups = {"smoke"})
    public void positiveLoginTestUsingPageObjectModel() {

        Driver.getDriver().get(PropertyReader.readProperties("url"));

        LoginPage loginPage = new LoginPage();


        loginPage.username.sendKeys(PropertyReader.readProperties("username"));

        loginPage.password.sendKeys(PropertyReader.readProperties("password"));

        loginPage.loginButton.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");

    }

    @Test (groups = {"smoke"})
    public void negativeLoginTestUsingPageObjectModel() {

        Driver.getDriver().get(PropertyReader.readProperties("url"));

        LoginPage loginPage = new LoginPage();


        loginPage.username.sendKeys(PropertyReader.readProperties("Tester"));

        loginPage.password.sendKeys(PropertyReader.readProperties("pass"));

        loginPage.loginButton.click();

        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");

    }

}
