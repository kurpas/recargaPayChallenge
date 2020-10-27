package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitError;
    protected final String BASE_URL = "https://recargapay.com.br";

    public BasePage(WebDriver driver){
        System.setProperty("webdriver.crome.driver","c:\\Web");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.waitError = new WebDriverWait(driver,2);
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element =wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }



}
