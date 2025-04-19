package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;

public class ScreenShotsManager {

    //define the path folder as a string ,using "."cause the folder in root
    //static to be visible
    static String screenshotsDirectorypath = "./screenshots" ;

    //object to deal with and save in file
    //File screenshotsDirector = new File(screenshotsDirectorypath);

    //method to take the action & the name to rename the shot as per the test
    public static void captureScreenshots(WebDriver driver,String screenshotName){
        Path destination = Paths.get(screenshotsDirectorypath , screenshotName + " .jpg");
        //To save the screen should define as a byte
        byte[] byteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(destination , byteArray , StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Unable to save screenshot");
        }
    }
}
