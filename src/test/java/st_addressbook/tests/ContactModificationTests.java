package st_addressbook.tests;

import org.junit.Test;
import st_addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("SergKing", "Pomytkin", "Kotik",
                "CryptoCat", "MoscowCity", "88000000", "89990000000"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }

}
