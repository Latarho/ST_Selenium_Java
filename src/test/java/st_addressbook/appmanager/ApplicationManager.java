package st_addressbook.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public ChromeDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;


    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        // Инициализация атрибута класса.
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        // Вызов метода, в нем можно использовать данный атрибут.
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}