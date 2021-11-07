package st_addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import st_addressbook.model.ContactData;

import java.util.List;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Serg", "Pomytkin", "Kotik",
                    "CryptoCat", "MoscowCity", "88000000", "89990000000",
                    "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("SergKing", "Pomytkin",
                "Kotik", "CryptoCat", "MoscowCity", "88000000",
                "89990000000", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }

}
