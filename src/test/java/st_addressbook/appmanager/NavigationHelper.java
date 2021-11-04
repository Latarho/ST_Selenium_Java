package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        // Обращение к конструктору базового класса.
        super(driver);
    }

    /**
     * Метод - переход на страницу со списком групп.
     * Включает проверки наличия: текста Groups в заголовке h1 и кнопки New group (локатор name = "new").
     */
    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    /**
     * Метод - переход на страницу со списком контактов.
     */
    public void gotoContactPage() {
        if (isElementPresent(By.tagName("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

}
