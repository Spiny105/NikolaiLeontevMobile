package Setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    protected AndroidDriver driver;

    protected void prepareAndroid() throws Exception {
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
        driver = new AndroidDriver(new URL(TestProperties.getDriverUrl()), capabilities);
    }

}

