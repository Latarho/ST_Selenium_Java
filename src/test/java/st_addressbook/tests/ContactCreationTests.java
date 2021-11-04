package st_addressbook.tests;

import org.junit.Test;
import st_addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Serg", "Pomytkin", "Kotik",
                "CryptoCat", "MoscowCity", "88000000", "89990000000",
                "test1"), true);
    }

}

