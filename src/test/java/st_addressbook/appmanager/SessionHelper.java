package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {
    private ChromeDriver driver;

    public SessionHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }
}
