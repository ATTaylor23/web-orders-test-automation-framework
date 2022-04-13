package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllOrdersPage {


    // Non-pageFactory style page object class:

//    public WebElement checkAllButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll"));
//
//    public List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;

    @FindBy(linkText = "View all orders")
    public WebElement allOrdersLink;

    @FindBy(partialLinkText = "all products")
    public WebElement allProductsLink;

    @FindBy(linkText = "Order")
    public WebElement singleOrderLink;

    



}
