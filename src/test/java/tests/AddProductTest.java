package tests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddProductPage;
import pages.HomePage;
import pages.SearchProductPage;

public class AddProductTest {

    //WebDriver driver;
    Driver driver;

    HomePage homePage;
    SearchProductPage productPage;
    AddProductPage addProductPage;

    @BeforeClass
    public void setUp(){
        //driver = new ChromeDriver();
        driver = new Driver("Chrome");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void addProductTest() {

        homePage = new HomePage(driver.get());
        productPage = new SearchProductPage(driver.get());
        addProductPage = new AddProductPage(driver.get());

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        productPage.clickOnProductButtonLink();
        addProductPage.clickOnFirstProductAddToCart();
        addProductPage.clickOnContinueShoppingButton();
        addProductPage.clickOnSecondProductAddToCart();
        addProductPage.clickOnViewCartButton();
        addProductPage.checkThatBothProductsAreAddedToCart();

    }

    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
