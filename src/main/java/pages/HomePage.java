package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    public WebDriver driver;

    By logOutLink = By.linkText("Logout");
    By logInLink = By.xpath("//a[@href=\"/login\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");

    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatLogOutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logOutLink).isDisplayed());
    }

    public void checkThatLogInLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logInLink).isDisplayed());
    }

    public void checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
    }

    public void checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.automationexercise.com/");
    }

    /********************************* Actions *********************************/

    public void clickOnLogInLink(){
        driver.findElement(logInLink).click();
    }

    public void clickOnLogOutLink(){
        driver.findElement(logOutLink).click();
    }

    public void clickOnDeleteAccountLink(){
        driver.findElement(deleteAccountLink).click();
    }

    public void clickOnContactUsLink(){
        driver.findElement(contactUsLink).click();
    }
}
