package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class RechargePage extends BasePage{

    public By phoneNumberInput = By.cssSelector("#allNumberInput");
    public By continueButton = By.id("showModalButton");
    public By invalidNumberMsg = By.xpath("/html[1]/body[1]/div[22]/div[2]");
    public By phoneNumberPopUp = By.id("showNumber");
    public By closeButton = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]");
    public HashMap<String, String> phoneNumbers;

    public RechargePage(WebDriver driver) {
        super(driver);
        phoneNumbers = setPhoneNumberData();
    }

    public void completePhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public RechargePage continueButtonClick(){
        driver.findElement(continueButton).click();
        return new RechargePage(driver);
    }

    public void closeButtonClick(){
        driver.findElement(closeButton).click();
    }

    public boolean invalidNumberMsgisVisible() {
        try {
            return driver.findElement(invalidNumberMsg).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public String getPhoneNumber(){
            return driver.findElement(phoneNumberPopUp).getText().replaceAll(" ","").replace(")","").replace("(","");
        }

        public HashMap<String, String> setPhoneNumberData(){
            HashMap<String, String> phoneNumbers = new HashMap<String, String>();
            phoneNumbers.put("short", "012345678");
            phoneNumbers.put("long", "012345678912");
            phoneNumbers.put("one", "1");
            //consultar valor invalido "0000000000"
            phoneNumbers.put("invalid", "0000000000");
            phoneNumbers.put("valid10", "0123456789");
            phoneNumbers.put("valid11", "01234567891");
            return phoneNumbers;
        }


    }



