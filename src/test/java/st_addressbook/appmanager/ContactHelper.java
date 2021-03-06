package st_addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import st_addressbook.model.ContactData;
import st_addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    /**
     * Метод - заполнение формы при создании контакта.
     * @param contactData Объект модели для заполнения формы контакта.
     * @param creation True для теста - создание нового контакта, False для теста - модификация выбранного контакта.
     */
    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());

        // Если доступен выпадающий список, то выбираем группу (тест на создании контакта).
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    /**
     * Метод - подсчет элементов на странице.
     * @return Количество элементов в формате int.
     */
    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    /**
     * Метод - формирование списка элементов представленных на странице.
     * @return Список контактов.
     */
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null,
                    null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}