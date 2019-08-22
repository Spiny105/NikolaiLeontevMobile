package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactManagerAddContactPage;
import scenarios.BaseTest;
import pages.ContactManagerMainPage;

import static org.testng.Assert.assertTrue;

public class simpleNativeTests extends BaseTest {

    static final String KEY_BOARD_TEST_STRING = "Test text";
    ContactManagerMainPage mainPage;
    ContactManagerAddContactPage addContactPage;

    @BeforeMethod(groups = "native")
    public void setUp(){
        mainPage = new ContactManagerMainPage(driverWrapper.getDriver());
        addContactPage = new ContactManagerAddContactPage(driverWrapper.getDriver());
    }

    @Test(groups = "native", description = "This simple test just click on button 'Add contact'")
    public void simplestTest() {
        mainPage.openAddContactPage();


        assertNewContactView();
        assertKeyBoard(KEY_BOARD_TEST_STRING);
        System.out.println("Simplest Appium test done");
    }

    //This method checks for items on the add new contact screen
    public void assertNewContactView() {
        assertTrue(addContactPage.getContactEmailEditText().isDisplayed());
        assertTrue(addContactPage.getContactEmailTypeSpinner().isDisplayed());
        assertTrue(addContactPage.getContactNameEditText().isDisplayed());
        assertTrue(addContactPage.getContactPhoneEditText().isDisplayed());
        assertTrue(addContactPage.getContactSaveButton().isDisplayed());
        assertTrue(addContactPage.getTitle().isDisplayed());
    }

    //This method checks, that keyboard is displayed
    public void assertKeyBoard(String inputText){
        addContactPage.enterTextUsingKeyboard(inputText);
        addContactPage.getContactNameEditText().getText().equals(inputText);
    }
}
