package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    //LogInElement's
    @FindBy(xpath = "//input[@id='spree_user_email']")
    @CacheLookup
    WebElement txtUserName;
    @FindBy(xpath = "//input[@id='spree_user_password']")
    @CacheLookup
    WebElement passwordUserName;
    @FindBy(xpath = "//input[@type='submit']")
    @CacheLookup
    WebElement btnLogIn;

    public LogInPage(WebDriver rdriver) {
        super(rdriver);
    }

    //LogInActions
    public void setUserName(String userName) {
        waitUntilDisplayed(txtUserName).sendKeys(userName);
    }

    public void setPassword(String password) {
        waitUntilDisplayed(passwordUserName).sendKeys(password);
    }

    public void clickBtnLogIn() {
        //Valida que este el Button y despues le da click
        waitUntilDisplayed(btnLogIn).click();
    }
}