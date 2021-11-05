package st_addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import st_addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Serg", "Pomytkin", "Kotik",
                    "CryptoCat", "MoscowCity", "88000000", "89990000000",
                    "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("SergKing", "Pomytkin",
                "Kotik", "CryptoCat", "MoscowCity", "88000000",
                "89990000000", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }

}
