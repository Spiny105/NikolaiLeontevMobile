package scenarios;

import Setup.DriverSetup;
import Setup.TestProperties;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareAndroid();
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    //@Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(TestProperties.getSut());
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }

}

