package st_addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import st_addressbook.model.ContactData;

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
        type(By.name("firstname"), contactData.firstName());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("nickname"), contactData.nickName());
        type(By.name("company"), contactData.company());
        type(By.name("address"), contactData.address());
        type(By.name("home"), contactData.homePhone());
        type(By.name("mobile"), contactData.mobilePhone());

        // Если доступен выпадающий список, то выбираем группу (тест на создании контакта).
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
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
}