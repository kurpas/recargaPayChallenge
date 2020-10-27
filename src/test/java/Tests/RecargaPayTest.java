package Tests;

import Pages.HomePage;
import Pages.RechargePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecargaPayTest extends BaseTest {

        private HomePage home;

        @BeforeMethod
        public void initialize() throws InterruptedException {
            home = new HomePage(driver);
        }

        @Test()
        public void coco(){

            RechargePage recharge = home.rechargeButtonClick();
            Assert.assertFalse(recharge.invalidNumberMsgisVisible(), "El mensaje de error esta visible");
            recharge.continueButtonClick();
            Assert.assertTrue(recharge.invalidNumberMsgisVisible(), "El mensaje de error esta visible");

            recharge.completePhoneNumber(recharge.phoneNumbers.get("one"));
            recharge.continueButtonClick();
            Assert.assertTrue(recharge.invalidNumberMsgisVisible(), "El mensaje de error NO esta visible");

            recharge.completePhoneNumber(recharge.phoneNumbers.get("short"));
            recharge.continueButtonClick();
            Assert.assertTrue(recharge.invalidNumberMsgisVisible(), "El mensaje de error NO esta visible");

            recharge.completePhoneNumber(recharge.phoneNumbers.get("valid10"));
            Assert.assertFalse(recharge.invalidNumberMsgisVisible(), "El mensaje de error esta visible");
            recharge.continueButtonClick();

            Assert.assertTrue(recharge.getPhoneNumber().equalsIgnoreCase(recharge.phoneNumbers.get("valid10")), "El mensaje de error NO esta visible");
            recharge.closeButtonClick();

            recharge.completePhoneNumber(recharge.phoneNumbers.get("valid11"));
            Assert.assertFalse(recharge.invalidNumberMsgisVisible(), "El mensaje de error esta visible");
            recharge.continueButtonClick();

            Assert.assertTrue(recharge.getPhoneNumber().equalsIgnoreCase(recharge.phoneNumbers.get("valid11")), "El mensaje de error NO esta visible");

        }
    }
