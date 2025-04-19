package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProductPage {

    public WebDriver driver;

    By productLink = By.xpath("//a[@href=\"/products\"]");
    By searchProductBar = By.xpath("//input[@id=\"search_product\"]");
    By submitSearchButton = By.id("submit_search");
    By viewProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By blueTopPrice = By.xpath("(//div[@class=\"product-information\"]//span)[2]");
    By blueTopAvailability = By.xpath("(//div[@class=\"product-information\"]//p//b)[1]");
    By blueTopCondition = By.xpath("(//div[@class=\"product-information\"]//p//b)[2]");
    By blueTopBrand = By.xpath("(//div[@class=\"product-information\"]//p//b)[3]");

    public SearchProductPage(WebDriver driver){
        this.driver = driver;
    }

    /********************************* Assertions *********************************/

    public void checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.automationexercise.com/");
    }

    public void checkThatUserIsNavigatedToAllProductPageSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.automationexercise.com/products");
    }

    public void checkThatBlueTopDetailsAreVisiblePriceAvailabilityConditionBrand() {
        Assert.assertTrue(driver.findElement(blueTopPrice).isDisplayed());
        Assert.assertTrue(driver.findElement(blueTopAvailability).isDisplayed());
        Assert.assertTrue(driver.findElement(blueTopCondition).isDisplayed());
        Assert.assertTrue(driver.findElement(blueTopBrand).isDisplayed());
    }

    /********************************* Actions *********************************/

    public void clickOnProductButtonLink(){
        driver.findElement(productLink).click();
    }

    public void searchForBlueTopProduct() {
        driver.findElement(searchProductBar).sendKeys("blue top");
    }

    public void clickOnSearchBarButton() {
        driver.findElement(submitSearchButton).click();
    }

    public void clickOnViewProduct() {
        driver.findElement(viewProduct).click();
    }

}
