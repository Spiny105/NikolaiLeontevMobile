package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.TestProperties;

public class Hooks extends BaseTest {

    private static final String AUT_PROPERTIES_FILE_PATH = ".\\src\\test\\resources\\nativeTest.properties";
    private static final String SUT_PROPERTIES_FILE_PATH = ".\\src\\test\\resources\\webTest.properties";

    @BeforeSuite(groups = "native", description = "Prepare driver to run native test(s)")
    public void setUpNative() throws Exception {
        TestProperties.readPropertiesFromFile(AUT_PROPERTIES_FILE_PATH);
        driverWrapper.prepareDriver();
    }

    @BeforeSuite(groups = "web", description = "Prepare driver to run web test(s)")
    public void setUpWeb() throws Exception {
        TestProperties.readPropertiesFromFile(SUT_PROPERTIES_FILE_PATH);
        driverWrapper.prepareDriver();
    }

    //@AfterSuite(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driverWrapper.getDriver().quit();
    }
}
