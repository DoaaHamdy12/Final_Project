package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {

   public WebDriver driver;

   By formTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
   By name = By.xpath("//input[@data-qa=\"name\"]");
   By email = By.xpath("//input[@data-qa=\"email\"]");
   By subject = By.xpath("//input[@data-qa=\"subject\"]");
   By message = By.id("message");
   By submitButton = By.name("submit");

   By successMessage = By.cssSelector("div.status.alert.alert-success");
   By homeButton = By.cssSelector("a.btn.btn-success");

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatContactUsPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"));
        Assert.assertEquals(driver.findElement(formTitle).getText() , "GET IN TOUCH");
    }

    public void checkThatFormShouldBeSubmittedSuccessfully(){
        Assert.assertEquals(driver.findElement(successMessage).getText() , "Success! Your details have been submitted successfully.");
    }

    /********************************* Actions *********************************/

    public void fillInContactUsForm(){
        driver.findElement(name).sendKeys("Doaa");
        driver.findElement(email).sendKeys("doaa1212@gmail.com");
        driver.findElement(subject).sendKeys("Greeting");
        driver.findElement(message).sendKeys("Hello Everyone");
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
        driver.switchTo().alert().accept();
    }

    public void clickOnHomeButton(){
        driver.findElement(homeButton).click();
    }
}
