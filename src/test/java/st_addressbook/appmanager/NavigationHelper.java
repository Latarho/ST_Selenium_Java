package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}
