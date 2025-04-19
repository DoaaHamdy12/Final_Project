package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class RemoveProductTest {

    Driver driver;

    HomePage homePage;
    SearchProductPage productPage;
    AddProductPage addProductPage;
    RemoveProductPage removeProductPage;

    @BeforeClass
    public void setUp(){
        driver = new Driver("Chrome");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void RemoveProduct(){

        homePage = new HomePage(driver.get());
        productPage = new SearchProductPage(driver.get());
        addProductPage = new AddProductPage(driver.get());
        removeProductPage = new RemoveProductPage(driver.get());

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        productPage.clickOnProductButtonLink();
        addProductPage.clickOnFirstProductAddToCart();
        addProductPage.clickOnContinueShoppingButton();
        addProductPage.clickOnSecondProductAddToCart();
        addProductPage.clickOnViewCartButton();
        addProductPage.checkThatBothProductsAreAddedToCart();
        removeProductPage.clickOnFirstRemoveProductButton();
        removeProductPage.clickOnSecondRemoveProductButton();
        //removeProductPage.checkThatProductsAreRemovedSuccessfully();

    }

    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
