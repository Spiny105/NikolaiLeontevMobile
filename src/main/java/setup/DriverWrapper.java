package setup;

import io.appium.java_client.AppiumDriver;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {

    private static DriverWrapper instance = new DriverWrapper();

    private DriverWrapper(){}

    public static DriverWrapper getInstance(){
        return instance;
    }

    private AppiumDriver driver;
    private WebDriverWait wait;

    public void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Device caps
        capabilities.setCapability("udid", TestProperties.getUdid());
        capabilities.setCapability("platformName", TestProperties.getTestPlatform().getItem());
        capabilities.setCapability("platformVersion", TestProperties.getPlatformVersion());

        switch (TestProperties.getTestType()) {

            case AUT:
                File appPath = new File(TestProperties.getAut());
                installApkToDevice(System.getenv("EPAM cloud token"), appPath.getAbsolutePath(), TestProperties.getUdid());

                capabilities.setCapability("appPackage", TestProperties.getAppPackage());
                capabilities.setCapability("appActivity", TestProperties.getAppActivity());
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

    public void installApkToDevice(String token, String filePath, String udid){
        String curlCommand = String.format("curl -k -v -H \"Authorization: Bearer %s\" -F \"file=@%s\" \"https://mobilecloud.epam.com/automation/api/storage/install/%s\"", token, filePath, udid);
        try {
            Process process = Runtime.getRuntime().exec(curlCommand);
            process.waitFor(5000, TimeUnit.MILLISECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

