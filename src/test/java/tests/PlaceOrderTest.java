package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class PlaceOrderTest {

    //WebDriver driver;
    Driver driver;

    HomePage homePage;
    SearchProductPage productPage;
    AddProductPage addProductPage;
    PlaceOrderPage placeOrderPage;
    LoginSignUpPage loginSignUpPage;
    RegisterationPage registerationPage;

    @BeforeClass
    public void setUp(){
        //driver = new ChromeDriver();
        driver = new Driver("Chrome");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void placeOrderTest() {

        homePage = new HomePage(driver.get());
        productPage = new SearchProductPage(driver.get());
        addProductPage = new AddProductPage(driver.get());
        placeOrderPage = new PlaceOrderPage(driver.get());
        loginSignUpPage = new LoginSignUpPage(driver.get());
        registerationPage = new RegisterationPage(driver.get());

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homePage.clickOnLogInLink();

        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
        loginSignUpPage.fillInSignUpName("Doaa");
        loginSignUpPage.fillInSignUpEmail("doaa1212@gmail.com");
        loginSignUpPage.clickOnSignUpButton();

        registerationPage.checkThatRegistrationPageIsLoadedSuccessfully();
        registerationPage.fillInRegistrationPage();
        registerationPage.clickOnCreateAccountButton();

        productPage.clickOnProductButtonLink();

        addProductPage.clickOnFirstProductAddToCart();
        addProductPage.clickOnContinueShoppingButton();
        addProductPage.clickOnSecondProductAddToCart();
        addProductPage.clickOnViewCartButton();
        addProductPage.checkThatBothProductsAreAddedToCart();

        placeOrderPage.clickOnProceedToCheckoutButton();
        placeOrderPage.clickOnPlaceOrderButton();
        placeOrderPage.fillTheCardDetailsField();
        placeOrderPage.clickOnPayAndConfirmOrderButton();
        placeOrderPage.checkThatOrderPlacedSuccessfully();

        homePage.clickOnDeleteAccountLink();
    }

    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
