package Utilities;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestDriverClass {

    @Test
    public void testSomething(){
        Driver.getDriver().get("https://www.google.com/");

        Driver.getDriver().findElement(By.name("q")).sendKeys("Nice job");

        Driver.quitDriver();

    }


}
