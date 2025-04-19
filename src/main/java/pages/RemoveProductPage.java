package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class RemoveProductPage {

    WebDriver driver;

    By removeFirstProductButton = By.xpath("(//i[@class=\"fa fa-times\"])[1]");
    By removeSecondProductButton = By.xpath("(//i[@class=\"fa fa-times\"])[2]");
    By textOfCartIsEmpty = By.xpath("//*[@id=\"empty_cart\"]/p/b");
    By emptyMessage = By.xpath("(//p[@class=\"text-center\"])[3]");
    By herLink = By.xpath("//a[@href=\"/products\"]//u");

    public RemoveProductPage (WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

//    public void checkThatProductsAreRemovedSuccessfully(){
//        Assert.assertTrue(driver.findElement(emptyMessage).isDisplayed());
//    }

    /********************************* Actions **********************************/

    public void clickOnFirstRemoveProductButton(){
        driver.findElement(removeFirstProductButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

    }

    public void clickOnSecondRemoveProductButton(){
        driver.findElement(removeSecondProductButton).click();
    }
}
