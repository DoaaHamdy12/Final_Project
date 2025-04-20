package pages;

import io.qameta.allure.Step;
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

    @Step("check That LogOut Link Should Be Displayed")
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

    @Step("User click on login link")
    public void clickOnLogInLink(){
        driver.findElement(logInLink).click();
    }

    @Step("User click on logout link")
    public void clickOnLogOutLink(){
        driver.findElement(logOutLink).click();
    }

    @Step("User click on delete account link")
    public void clickOnDeleteAccountLink(){
        driver.findElement(deleteAccountLink).click();
    }

    @Step("User click on ContactUs link")
    public void clickOnContactUsLink(){
        driver.findElement(contactUsLink).click();
    }
}
