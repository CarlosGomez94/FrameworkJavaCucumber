package StepDefinition;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {

    //From the Read Config i im bringing the Config Data.
    ReadConfig readconfig = new ReadConfig();
    public String baseURL = readconfig.GetApplicationURL();
    public String username = readconfig.GetApplicationUsername();
    public String password = readconfig.GetApplicationPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        //Messages name project
        logger = Logger.getLogger("Herb");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.GetApplicationChromePath());
            driver = new ChromeDriver();
        }else if (br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.GetApplicationFirefoxPath());
            driver = new FirefoxDriver();

            //Es el de Safari pero este no utiliza extencion.
        }else if (br.equals("safari")){
            driver = new SafariDriver();
        }
        driver.get(baseURL);
    }

    //Close Chrome Driver
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String tname) throws IOException {
        String timeStamp = new SimpleDateFormat(" - HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File( "Screenshots/"+  tname + timeStamp + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot Taken");
    }
}