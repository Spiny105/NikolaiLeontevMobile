package setup;

import io.appium.java_client.AppiumDriver;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

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
                //installApkToDevice(appPath, "", TestProperties.getUdid());

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

//    public void installApkToDevice(File apkFilePath, String cloudAddr, String deviceUdid){
//        RestAssured.given()
//                .header(new Header("Authorization", "1ba5d009-0335-42b9-ab45-5db207b5044e"))
//                .param("serial", deviceUdid)
//                .param("file", apkFilePath.getAbsolutePath())
//                .post("https://mobilecloud.epam.com/automation/api/storage/install/:serial[?doResign=true]");
//    }
}

