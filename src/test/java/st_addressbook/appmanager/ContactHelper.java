package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import st_addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("nickname"), contactData.nickName());
        type(By.name("company"), contactData.company());
        type(By.name("address"), contactData.address());
        type(By.name("home"), contactData.homePhone());
        type(By.name("mobile"), contactData.mobilePhone());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

}