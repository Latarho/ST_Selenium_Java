package st_addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import st_addressbook.model.ContactData;

import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("Serg", "Pomytkin", "Kotik",
                "CryptoCat", "MoscowCity", "88000000", "89990000000",
                "test1"), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}

