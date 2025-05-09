package listeners;

import driverfactory.Driver;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utilities.ScreenShotsManager;

import java.io.IOException;

//to listen to event like failure and success , will call in every method implementation
public class TestNGListener implements IInvokedMethodListener , ITestListener , IExecutionListener {

    @Override
    public void onExecutionStart(){
        System.out.println("** Welcome to Selenium Framework **");
    }

    @Override
    public void onExecutionFinish (){
        System.out.println(" Generating Report ..... ");
        try {
            Runtime.getRuntime().exec("reportGeneration.bat");
        } catch (IOException e) {
            System.out.println("Unable to Generate Allure Report , may be there's an issue in the batch file");        }
        System.out.println(" ** End of Execution ** ");

    }

    @Override
    public void onTestStart (ITestResult result){
        System.out.println("** starting test: "+ result.getName() + " **");
    }

    @Override
    public void onTestSuccess (ITestResult result){
        System.out.println("** success of test: "+ result.getName() + " **");
    }

    @Override
    public void onTestFailure (ITestResult result){
        System.out.println("Test Failed");
        System.out.println("Taking Screen shot ..");
        ScreenShotsManager.captureScreenshots(Driver.get(), result.getName());

        System.out.println("** failure of test: "+ result.getName() + " **");
    }

    //the old way before i configure listener
/*    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed");
            System.out.println("Taking Screen shot ..");
            ScreenShotsManager.captureScreenshots(driver.get(), result.getName());
        }
   }
*/

}
