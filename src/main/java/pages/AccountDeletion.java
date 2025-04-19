package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletion {

    public WebDriver driver;

    By deletionsuccessMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public AccountDeletion(WebDriver driver) {
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatAccountShouldBeDeleted(){
        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.findElement(deletionsuccessMessage).isDisplayed());
    }

    /********************************* Actions *********************************/

    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }

}
