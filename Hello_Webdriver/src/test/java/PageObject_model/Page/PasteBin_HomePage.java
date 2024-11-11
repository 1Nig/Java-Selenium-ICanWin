package PageObject_model.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PasteBin_HomePage {
    WebDriver driver;
    public PasteBin_HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "postform-text")
    public WebElement NewPaste;
    @FindBy(id = "hideSlideBanner")
    public WebElement closeButton;
     @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[4]/div/span/span[1]")
     public WebElement ExpirationPasteChoice;
    @FindBy(xpath = "//li[contains(text(), '10 Minutes')]")
    WebElement TenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
            WebElement PasteNameChoice;
    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button")
            WebElement CreateNewPasteButton;
    public void closePopup() {
        try {
            // Ожидаем появления элемента всплывающего окна
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hideSlideBanner")));

            // Нажимаем на кнопку закрытия всплывающего окна
            closeButton.click();

            System.out.println("Всплывающее окно закрыто.");
        } catch (TimeoutException e) {
            // Если всплывающее окно не появилось
            System.out.println("Всплывающее окно не появилось.");
        }
    }
    public void NewPaste(String NewPasteString){
        NewPaste.sendKeys(NewPasteString);
    }
    public void TenMinutes() {
        TenMinutes.click();
    }
    public void PasteNameChoice(String PasteNameChoiceString) {
        PasteNameChoice.sendKeys(PasteNameChoiceString);
        PasteNameChoiceString = "helloweb";
    }
    public void CreateNewPasteButton() {
        CreateNewPasteButton.click();
    }
}



