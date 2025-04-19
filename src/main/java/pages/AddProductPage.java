package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class AddProductPage {

    public WebDriver driver;

    By firstProductAddToCartButton = By.xpath("(//a[@data-product-id=\"1\"])[1]");
    By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    By secondProductAddToCartButton = By.xpath("(//a[@data-product-id=\"2\"])[1]");
    By viewCartButton = By.xpath("(//a[@href=\"/view_cart\"])[2]");

    By firstproductInCart = By.xpath("//a[@href=\"/product_details/1\"]");
    By secondproductInCart = By.xpath("//a[@href=\"/product_details/2\"]");

    public AddProductPage(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatBothProductsAreAddedToCart(){
        Assert.assertTrue(driver.findElement(firstproductInCart).isDisplayed());
        Assert.assertTrue(driver.findElement(secondproductInCart).isDisplayed());
    }

    /********************************* Actions *********************************/

    public void clickOnFirstProductAddToCart(){
        driver.findElement(firstProductAddToCartButton).click();
    }

    public void clickOnContinueShoppingButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(continueShoppingButton).click();
    }

    public void clickOnSecondProductAddToCart(){
        driver.findElement(secondProductAddToCartButton).click();
    }

    public void clickOnViewCartButton(){
        driver.findElement(viewCartButton).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
    }

}
