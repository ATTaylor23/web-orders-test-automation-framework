package Tests;

import Pages.AllOrdersPage;
import Pages.AllProductsPage;
import Pages.LoginPage;
import Utilities.Driver;
import Utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
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
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class allProductsTest extends TestBase {


    @Test
    public void verifyColumnNames() throws IOException {

        Driver.getDriver().get(PropertyReader.readProperties("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.readProperties("username"), Keys.TAB, PropertyReader.readProperties("password"), Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("View all products")).click();

        List<WebElement> columns = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//tr[1]/th"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(columns.get(0).getText(), "Product name");
        softAssert.assertEquals(columns.get(1).getText(), "Price");
        softAssert.assertEquals(columns.get(2).getText(), "Discount");

        softAssert.assertAll();
        // used to keep executing and find out the error IF one of them fails


    }

    @Test
    public void verifyProductNames()  {

        Driver.getDriver().get(PropertyReader.readProperties("url"));

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys(PropertyReader.readProperties("username"));
        loginPage.password.sendKeys(PropertyReader.readProperties("password"));
        loginPage.loginButton.click();


        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.allProductsLink.click();

        AllProductsPage allProductsPage = new AllProductsPage();

        Assert.assertEquals(allProductsPage.productNamesList.get(0).getText(), "MyMoney");
        Assert.assertEquals(allProductsPage.productNamesList.get(1).getText(), "FamilyAlbum");
        Assert.assertEquals(allProductsPage.productNamesList.get(2).getText(), "ScreenSaver");




    }




}
