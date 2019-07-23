package scenarios.webTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.DriverWrapper;
import setup.TestProperties;

@Test(groups = "web")
public class simpleWebTests extends DriverWrapper {

    @Test(groups = "web", description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(TestProperties.getSut());
        wait.until(ExpectedConditions.urlToBe(TestProperties.getSut() + "/"));
        System.out.println("Site opening done");
    }

}
