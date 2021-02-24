package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.Plus21Elements;

import java.io.IOException;

public class TC_LogIn_Test_001 extends BaseClass {

    //BaseClass Element's are part of everything here.
    @Test
    public void logInTest() throws IOException {

        //CloseMessage "+21"
        Plus21Elements plus21 = new Plus21Elements(driver);
        plus21.clickYes();

        //LogInPage
        LogInPage lp = new LogInPage(driver);
        lp.setUserName(username);
        logger.info("Entered Username");
        lp.setPassword(password);
        logger.info("Entered Password");
        lp.clickBtnLogIn();

        //ValidarLogIn correcto
        if (driver.getTitle().equals("HERB Homepage THIS RIGHT HERE")){
            Assert.assertTrue(true);
            logger.info("LogIn Test Passed");
        }else{
            captureScreenshot( driver, "logInTest");
            Assert.assertTrue(false);
            logger.info("LogIn Test Failed");
        }
    }
}