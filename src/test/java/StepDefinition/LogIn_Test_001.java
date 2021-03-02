package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pageObjects.LogInPage;
import pageObjects.Plus21Elements;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LogIn_Test_001 {

    //From the Read Config i im bringing the Config Data.
    ReadConfig readconfig = new ReadConfig();
    public String baseURL = readconfig.GetApplicationURL();
    public String username = readconfig.GetApplicationUsername();
    public String password = readconfig.GetApplicationPassword();

    public static Logger logger;

    private WebDriver driver;

    @Before
    public void before() {

        logger = Logger.getLogger("Herb");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("I browser to page using {word}")
    public void iBrowsetoPageUsing(String br) {
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.GetApplicationChromePath());
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readconfig.GetApplicationFirefoxPath());
            driver = new FirefoxDriver();

            //Es el de Safari pero este no utiliza extencion.
        } else if (br.equals("safari")) {
            driver = new SafariDriver();
        }
        driver.get(baseURL);
    }

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
        if (driver.getTitle().equals("HERB Homepage THIS RIGHT HERE")) {
            Assert.assertTrue(true);
            logger.info("LogIn Test Passed");
        } else {
            captureScreenshot(driver, "logInTest");
            Assert.assertTrue(false);
            logger.info("LogIn Test Failed");
        }
    }

    public void captureScreenshot(WebDriver driver, String tname) throws IOException {
        String timeStamp = new SimpleDateFormat(" - HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("Screenshots/" + tname + timeStamp + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }

}
