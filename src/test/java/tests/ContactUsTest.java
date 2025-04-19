package tests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.ScreenShotsManager;

public class ContactUsTest {

    Driver driver;
    //WebDriver driver;

    HomePage homePage;
    ContactUsPage contactUsPage;


    @BeforeClass
    public void setUp(){
        driver = new Driver("Chrome");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void contactUsTest() {

        homePage = new HomePage(driver.get());
        contactUsPage =new ContactUsPage(driver.get());

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homePage.clickOnContactUsLink();

        contactUsPage.checkThatContactUsPageIsLoadedSuccessfully();
        contactUsPage.fillInContactUsForm();
        contactUsPage.clickOnSubmitButton();
        contactUsPage.checkThatFormShouldBeSubmittedSuccessfully();
        contactUsPage.clickOnHomeButton();

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result) {
//        if(result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test Failed");
//            System.out.println("Taking Screen shot ..");
//            ScreenShotsManager.captureScreenshots(driver.get(), result.getName());
//        }
//    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
