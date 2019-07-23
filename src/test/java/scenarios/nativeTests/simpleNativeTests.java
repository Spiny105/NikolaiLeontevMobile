package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.DriverWrapper;

@Test(groups = "native")
public class simpleNativeTests extends DriverWrapper {

    @Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }
}
