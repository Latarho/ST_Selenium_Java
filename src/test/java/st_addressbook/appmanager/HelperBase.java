package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {
    protected ChromeDriver driver;

    // Создан конструктор, параметр - ссылка на драйвер.
    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
