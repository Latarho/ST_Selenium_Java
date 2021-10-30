package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(ChromeDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.cssSelector("input:nth-child(7)"));
    }
}
