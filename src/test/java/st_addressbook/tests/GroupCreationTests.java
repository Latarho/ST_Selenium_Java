package st_addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import st_addressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}