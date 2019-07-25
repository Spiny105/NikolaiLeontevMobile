package scenarios.webTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scenarios.BaseTest;
import setup.TestProperties;

@Test(groups = "web")
public class simpleWebTests extends BaseTest {

    @Test(groups = "web", description = "Open website")
    public void webTest() throws InterruptedException {
        driverWrapper.getDriver().get(TestProperties.getSut());
        driverWrapper.getWait().until(ExpectedConditions.urlMatches(TestProperties.getSut() + "*"));
        driverWrapper.getWait().until(ExpectedConditions.titleIs("Internet Assigned Numbers Authority"));

        System.out.println("Site opening done");
    }

}
