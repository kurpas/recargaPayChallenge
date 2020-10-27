
package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.util.logging.Logger;


public abstract class BaseTest {

    protected static WebDriver driver;
    public Logger logger = Logger.getLogger(BaseTest.class.getName());


    // this method set the web driver
    @BeforeClass
    @Parameters("browser")
    public static WebDriver setUp(String browser) throws Exception {

     if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver( options );

        }

        return driver;
    }

    //This method close the browser after tests
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    //This method delete all cookies
    @AfterMethod
    public void cleanCookies() {
        driver.manage().deleteAllCookies();
    }
}
