package st_addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

    // Создан конструктор, параметр - ссылка на драйвер.
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    // Метод - клик по элементу (находим элемент по локатору и кликаем).
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    // Метод - ввод текста (Находим поле ввода по локатору и вводим туда текст).
    // Ввод нового текста если параметр текст не пустой (text != null).
    // Проверка ранее введенного текста и нового, если совпадает новый текст не вводим.
    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    // Метод - проверка наличия элемента.
    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
