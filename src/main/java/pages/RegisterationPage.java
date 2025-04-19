package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterationPage {

    public WebDriver driver;

    By gender = By.id("id_gender2");
    By RegPassword = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By companyName = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton = By.cssSelector("button.btn.btn-default");
    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");

    public RegisterationPage(WebDriver driver){
        this.driver = driver;
    }
    /********************************* Assertions *********************************/

    public void checkThatRegistrationPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.findElement(pageTitle).getText() , "ENTER ACCOUNT INFORMATION");
    }

    /********************************* Actions *********************************/
    public void fillInRegistrationPage (){
        driver.findElement(gender).click();
        driver.findElement(RegPassword).sendKeys("123456");

        //to select from dropdown menu we use Select Class
        // i can save find element() in variable or use it direct in the select class
        WebElement dropDown1 = driver.findElement(By.id("days"));
        Select day = new Select(dropDown1);
        day.selectByValue("12");
        WebElement dropDown2 = driver.findElement(By.id("months"));
        Select month = new Select(dropDown2);
        month.selectByValue("10");
        WebElement dropDown3 = driver.findElement(By.id("years"));
        Select year = new Select(dropDown3);
        year.selectByValue("1993");

        driver.findElement(firstName).sendKeys("Doaa");
        driver.findElement(lastName).sendKeys("Hamdy");
        driver.findElement(companyName).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Alexandria");
        driver.findElement(address2).sendKeys("Qena");
        driver.findElement(country).click();
        driver.findElement(state).sendKeys("Egypt");
        driver.findElement(city).sendKeys("Alexandria");
        driver.findElement(zipcode).sendKeys("1234");
        driver.findElement(mobileNumber).sendKeys("01000000000");
        driver.findElement(createAccountButton).click();
    }

    public void clickOnCreateAccountButton(){
        driver.findElement(createAccountButton).click();
    }


}
