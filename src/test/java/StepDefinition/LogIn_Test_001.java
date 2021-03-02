package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pageObjects.LogInPage;
import pageObjects.Plus21Elements;

import java.io.IOException;



public class LogIn_Test_001 extends BaseClass{

    @Given("I click Yes im {int} years")
    public void iClickYesImYears(int arg0) {
        Plus21Elements plus21 = new Plus21Elements(driver);
        plus21.clickYes();
    }

    @Then("I entered User ID")
    public void iEnteredUserID() {
        LogInPage lp = new LogInPage(driver);
        lp.setUserName(username);
        logger.info("Entered Username");

    }

    @And("I entered Password")
    public void iEnteredPassword() {
        LogInPage lp = new LogInPage(driver);
        lp.setPassword(password);
        logger.info("Entered Password");

    }

    @And("I click LogIn button")
    public void iClickLogInButton() {
        LogInPage lp = new LogInPage(driver);
        lp.clickBtnLogIn();
    }

    @Then("The Login it's correct")
    public void theLoginItSCorrect() throws IOException {
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
