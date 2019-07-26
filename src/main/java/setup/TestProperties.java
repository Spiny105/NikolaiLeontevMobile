package setup;

import enums.TestPlatforms;
import enums.TestTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* This class contains test properties, that are read from *.properties files
* */
public class TestProperties {

    private static String aut;
    private static String sut;
    private static String device;
    private static String driverUrl;
    private static TestTypes testType;
    private static TestPlatforms testPlatform;
    private static String browserName;
    private static String udid;
    private static String platformVersion;

    public static void readPropertiesFromFile(String filePath){
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        aut = prop.getProperty("aut");
        sut = prop.getProperty("sut");
        String platformString = prop.getProperty("platform.name");
        device = prop.getProperty("device.name");
        driverUrl = prop.getProperty("driver.url");
        browserName = prop.getProperty("browserName");
        udid = prop.getProperty("udid");
        platformVersion=prop.getProperty("platform.version");

        if (TestProperties.getSut() != null && TestProperties.getAut() == null) {
            testType = TestTypes.SUT;
        } else if (TestProperties.getSut() == null && TestProperties.getAut() != null) {
            testType = TestTypes.AUT;
        } else {
            testType = TestTypes.UNCNOWN_TYPE;
        }

        switch (platformString) {
            case "Android":
                testPlatform = TestPlatforms.ANDROID;
                break;
            case "iOS":
                testPlatform = TestPlatforms.IOS;
                break;
            default:
                testPlatform = TestPlatforms.UNKNOWN;
        }

        System.out.println(browserName);
    }

    public static String getAut() {
        return aut;
    }

    public static String getSut() {
        return sut;
    }

    public static TestPlatforms getTestPlatform() {
        return testPlatform;
    }

    public static String getDevice() {
        return device;
    }

    public static String getDriverUrl() {
        return driverUrl;
    }

    public static TestTypes getTestType() {
        return testType;
    }

    public static String getBrowserName() {
        return browserName;
    }

    public static String getUdid() {
        return udid;
    }

    public static String getPlatformVersion() {
        return platformVersion;
    }
}
