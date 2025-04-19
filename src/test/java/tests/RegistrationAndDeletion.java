package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class RegistrationAndDeletion {

    WebDriver driver;

    LoginSignUpPage loginSignUpPage;
    RegistrationSuccessPage successPage;
    HomePage homePage;
    RegisterationPage registerationPage;
    AccountDeletion accountDeletion;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        loginSignUpPage = new LoginSignUpPage(driver);
        successPage = new RegistrationSuccessPage(driver);
        homePage = new HomePage(driver);
        registerationPage = new RegisterationPage(driver);

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homePage.clickOnLogInLink();

        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
        loginSignUpPage.fillInSignUpName("Doaa");
        loginSignUpPage.fillInSignUpEmail("doaa1212@gmail.com");
        loginSignUpPage.clickOnSignUpButton();

        registerationPage.checkThatRegistrationPageIsLoadedSuccessfully();
        registerationPage.fillInRegistrationPage();
        registerationPage.clickOnCreateAccountButton();

        successPage.checkThatSuccessMessageShouldBeDisplayed();

        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully" , priority = 2)
    public void userCanLoginSuccessfully() {
        driver.navigate().to("https://www.automationexercise.com/login");

        loginSignUpPage.fillInLoginEmail("doaa1212@gmail.com");
        loginSignUpPage.fillInLoginPassword("123456");
        loginSignUpPage.clickOnLoginButton();

        homePage.checkThatLogOutLinkShouldBeDisplayed();
    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully" , priority = 3)
    public void userCanLogOutSuccessfully(){
        homePage.clickOnLogOutLink();
        homePage.checkThatLogInLinkShouldBeDisplayed();
        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogOutSuccessfully" , priority = 4)
    public void userCanDeleteAccountSuccessfully(){

        accountDeletion = new AccountDeletion(driver);

        loginSignUpPage.fillInLoginEmail("doaa1212@gmail.com");
        loginSignUpPage.fillInLoginPassword("123456");
        loginSignUpPage.clickOnLoginButton();

        homePage.checkThatLogOutLinkShouldBeDisplayed();
        //new
        homePage.checkThatDeleteAccountLinkShouldBeDisplayed();
        homePage.clickOnDeleteAccountLink();

        accountDeletion.checkThatAccountShouldBeDeleted();
        accountDeletion.clickOnContinueButton();

        homePage.checkThatLogInLinkShouldBeDisplayed();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
