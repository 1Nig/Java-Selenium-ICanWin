package PageObject_model.Test;

import PageObject_model.Page.PasteBin_HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasteBinTest {
    WebDriver driver;
    PasteBin_HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com");

        // Инициализируем Page Object
        homePage = new PasteBin_HomePage(driver);
    }

    @Test
    public void createNewPaste() {
        // Закрываем всплывающее окно, если оно появится
        homePage.closePopup();

        // Вводим текст нового паста
        homePage.NewPaste("Hello from WebDriver");

        // Выбираем время жизни паста
        homePage.ExpirationPasteChoice.click();
        homePage.TenMinutes();

        // Вводим название паста
        homePage.PasteNameChoice("helloweb");

        // Создаем новый паст
        homePage.CreateNewPasteButton();

        // Здесь можно добавить проверки, чтобы убедиться, что паст был создан успешно
    }

    @AfterClass
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}