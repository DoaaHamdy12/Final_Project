package driverfactory;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    //constructor
    public Driver(String driverType){
        driver = getDriver(driverType).startDriver();
    }

    private DriverAbstract getDriver(String driver){
        switch (driver){
            case "Chrome" : {
                return new ChromeDriverFactory();
            }
            case "Firefox" : {
                return new FirefoxDriverFactory();
            }
            case "Edge" : {
                return new EdgeDriverFactory();
            }
            default: {
                throw new IllegalStateException("Unexpected value : " + driver);
            }
        }
    }

    //to can expose selenium's method
    public static WebDriver get() {
        return driver;
    }

    public void quit(){
        driver.quit();
    }
}
