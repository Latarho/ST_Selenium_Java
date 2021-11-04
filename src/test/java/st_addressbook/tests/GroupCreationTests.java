package st_addressbook.tests;

import org.junit.Test;
import st_addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }

}