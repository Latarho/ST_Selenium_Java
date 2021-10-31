package st_addressbook.tests;

import org.junit.Test;
import st_addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Serg", "Pomytkin", "Kotik",
                "CryptoCat", "MoscowCity", "88000000", "89990000000"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }

}
