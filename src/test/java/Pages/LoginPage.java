package Pages;

import Utilities.Driver;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Non-pageFactory style page object class:

//    public WebElement username = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
//    public WebElement password = Driver.getDriver().findElement(By.id("ctl00_MainContent_password"));
//    public WebElement loginButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button"));



    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_username")
    public WebElement username;

    @FindBy (name = "ctl00$MainContent$password")
    public WebElement password;

    @FindBy (xpath = "//input[@value='Login']")
    public WebElement loginButton;





}
