package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class DriverWrapper {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    public void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Device caps
        capabilities.setCapability("deviceName", TestProperties.getDevice());
        capabilities.setCapability("platformName", TestProperties.getTestPlatform().getItem());

        switch (TestProperties.getTestType()) {
            case AUT:
                capabilities.setCapability("app", TestProperties.getAut());
                break;
            case SUT:
                capabilities.setCapability("browserName", "Chrome");
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
