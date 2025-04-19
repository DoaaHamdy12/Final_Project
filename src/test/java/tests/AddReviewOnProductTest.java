package tests;

import driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewOnProductTest {

    //WebDriver driver;
    Driver driver;

    HomePage homePage;
    SearchProductPage productPage;
    LoginSignUpPage loginSignUpPage;
    RegisterationPage registerationPage;
    AddReviewOnProduct addReviewOnProduct;

    @BeforeClass
    public void setUp(){
        //driver = new ChromeDriver();
        driver = new Driver("Chrome");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void AddReviewOnProduct() {

        homePage = new HomePage(driver.get());
        productPage = new SearchProductPage(driver.get());
        loginSignUpPage = new LoginSignUpPage(driver.get());
        registerationPage = new RegisterationPage(driver.get());
        addReviewOnProduct = new AddReviewOnProduct(driver.get());

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

        addReviewOnProduct.clickOnViewProduct();
        addReviewOnProduct.fillEmailAddressField();
        addReviewOnProduct.fillReviewField();
        addReviewOnProduct.clickOnSubmitButton();

        homePage.clickOnDeleteAccountLink();
    }

    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
