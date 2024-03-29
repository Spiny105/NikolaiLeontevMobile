package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class DriverWrapper {

    private static DriverWrapper instance = new DriverWrapper();

    private DriverWrapper(){}

    public static  DriverWrapper getInstance(){
        return instance;
    }

    private AppiumDriver driver;
    private WebDriverWait wait;

    public void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Device caps
        capabilities.setCapability("deviceName", TestProperties.getDevice());
        capabilities.setCapability("platformName", TestProperties.getTestPlatform().getItem());

        switch (TestProperties.getTestType()) {

            case AUT:
                File appPath = new File(TestProperties.getAut());
                capabilities.setCapability("app", appPath.getAbsoluteFile());
                break;

            case SUT:
                capabilities.setCapability("browserName", TestProperties.getBrowserName());
                break;

            default:
                throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        driver = new AppiumDriver(new URL(TestProperties.getDriverUrl()), capabilities);

        wait = new WebDriverWait(driver, 5);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

