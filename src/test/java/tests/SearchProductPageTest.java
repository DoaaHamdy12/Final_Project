package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class SearchProductPageTest {

    WebDriver driver;

    SearchProductPage productPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void searchProductPageTest(){

        productPage = new SearchProductPage(driver);

        productPage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        productPage.clickOnProductButtonLink();
        productPage.checkThatUserIsNavigatedToAllProductPageSuccessfully();
        productPage.searchForBlueTopProduct();
        productPage.clickOnSearchBarButton();
        productPage.clickOnViewProduct();
        productPage.checkThatBlueTopDetailsAreVisiblePriceAvailabilityConditionBrand();
    }

    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
