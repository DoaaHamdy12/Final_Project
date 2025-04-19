package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSuccessPage {
    public WebDriver driver;

    By successMessage = By.cssSelector("h2.title.text-center");


    public RegistrationSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatSuccessMessageShouldBeDisplayed(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }

}