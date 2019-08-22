package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactManagerAddContactPage extends ContactManagerBasePage{

    public ContactManagerAddContactPage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactSaveButton")
    private RemoteWebElement contactSaveButton;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private RemoteWebElement contactEmailEditText;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private RemoteWebElement contactPhoneEditText;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private RemoteWebElement contactNameEditText;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneTypeSpinner")
    private RemoteWebElement contactPhoneTypeSpinner;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailTypeSpinner")
    private RemoteWebElement contactEmailTypeSpinner;

    @AndroidFindBy(id = "android:id/title")
    private RemoteWebElement title;

    public RemoteWebElement getContactSaveButton() {
        return contactSaveButton;
    }

    public RemoteWebElement getContactEmailEditText() {
        return contactEmailEditText;
    }

    public RemoteWebElement getContactPhoneEditText() {
        return contactPhoneEditText;
    }

    public RemoteWebElement getContactNameEditText() {
        return contactNameEditText;
    }

    public RemoteWebElement getContactPhoneTypeSpinner() {
        return contactPhoneTypeSpinner;
    }

    public RemoteWebElement getContactEmailTypeSpinner() {
        return contactEmailTypeSpinner;
    }

    public RemoteWebElement getTitle() {
        return title;
    }

    public void enterTextUsingKeyboard(String text){
        driver.getKeyboard().pressKey(text);
    }
}
