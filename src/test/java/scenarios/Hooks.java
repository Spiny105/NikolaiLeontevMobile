package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.DriverWrapper;

@Test(groups = {"native, web"})
public class Hooks extends DriverWrapper {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
