package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PlaceOrderPage {

    public WebDriver driver;

    By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By placeOrderButton = By.xpath("//a[@href=\"/payment\"]");
    By nameOnCardField = By.xpath("//input[@name=\"name_on_card\"]");
    By cardNumberField = By.xpath("//input[@name=\"card_number\"]");
    By cardCVCField = By.xpath("//input[@name=\"cvc\"]");
    By cardExpirationMonthField = By.xpath("//input[@name=\"expiry_month\"]");
    By cardYearField = By.xpath("//input[@name=\"expiry_year\"]");
    By payAndConfirmOrderButton = By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]");
    By orderPlacedMessage = By.xpath("//h2[@class=\"title text-center\"]/b");

    public PlaceOrderPage(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatOrderPlacedSuccessfully(){
        Assert.assertTrue(driver.findElement(orderPlacedMessage).isDisplayed());
    }

    /*********************************  Actions  **********************************/

    public void clickOnProceedToCheckoutButton(){
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickOnPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }

    public void fillTheCardDetailsField(){
        driver.findElement(nameOnCardField).sendKeys("DOAA HAMDY");
        driver.findElement(cardNumberField).sendKeys("123456789");
        driver.findElement(cardCVCField).sendKeys("222");
        driver.findElement(cardExpirationMonthField).sendKeys("12");
        driver.findElement(cardYearField).sendKeys("2026");
    }

    public void clickOnPayAndConfirmOrderButton(){
        driver.findElement(payAndConfirmOrderButton).click();
    }
}
