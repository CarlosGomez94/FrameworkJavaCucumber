package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    WebDriver ldriver;
    public LogInPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

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

    //LogInActions
    public void setUserName(String userName) {
        txtUserName.sendKeys(userName);
    }
    public void setPassword(String password) {
        passwordUserName.sendKeys(password);
    }
    public void clickBtnLogIn() {
        //Valida que este el Button y despues le da click
        btnLogIn.isDisplayed();
        btnLogIn.click();
    }

}
