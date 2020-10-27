package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public By logoIcon = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/a[1]");
    public By recargaButton = By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]");
    public HomePage(WebDriver driver) throws InterruptedException {
        super(driver);
        driver.get(BASE_URL);
        driver.navigate().refresh();
        waitForElementToBeVisible(driver, driver.findElement(logoIcon), 30);

    }

    public RechargePage rechargeButtonClick(){
        driver.findElement(recargaButton).click();
        return new RechargePage(driver);
    }

}
