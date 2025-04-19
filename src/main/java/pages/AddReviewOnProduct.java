package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddReviewOnProduct {

    public WebDriver driver;

    By viewProduct = By.xpath("//a[@href=\"/product_details/12\"]");
    By emailAddressField = By.id("email");
    By myReview = By.name("review");
    By submitButton = By.xpath("//button[@id=\"button-review\"]");

    public AddReviewOnProduct(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Actions *********************************/

    public void clickOnViewProduct(){
        driver.findElement(viewProduct).click();
    }

    public void fillEmailAddressField(){
        driver.findElement(emailAddressField).sendKeys("doaa1212@gmail.com");
    }

    public void fillReviewField(){
        driver.findElement(myReview).sendKeys("What a great Product !");
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

}
