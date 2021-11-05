package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import st_addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    /**
     * Метод - заполнение формы при создании группы.
     * @param groupData Объект модели для заполнения формы группы.
     */
    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name());
        type(By.name("group_header"), groupData.header());
        type(By.name("group_footer"), groupData.footer());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    /**
     * Метод - подсчет элементов на странице.
     * @return Количество элементов в формате int.
     */
    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

}
