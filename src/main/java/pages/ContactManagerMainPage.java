package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactManagerMainPage extends ContactManagerBasePage {

    private AppiumDriver driver;

    public ContactManagerMainPage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
    private RemoteWebElement addContactButton;

    public void openAddContactPage(){
        addContactButton.click();
    }

}
