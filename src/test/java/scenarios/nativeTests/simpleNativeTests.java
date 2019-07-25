package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import scenarios.BaseTest;

import static org.testng.Assert.assertTrue;

public class simpleNativeTests extends BaseTest {

    @Test(groups = "native", description = "This simple test just click on button 'Add contact'")
    public void simplestTest() {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driverWrapper.getDriver().findElement(add_btn).click();
        assertNewContactView();
        System.out.println("Simplest Appium test done");
    }

    //This method checks for items on the add new contact screen
    public void assertNewContactView() {
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactPhoneTypeSpinner")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("com.example.android.contactmanager:id/contactEmailTypeSpinner")).isDisplayed());
        assertTrue(driverWrapper.getDriver().findElement(By.id("android:id/title")).isDisplayed());
    }
}
