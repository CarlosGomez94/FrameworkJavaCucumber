package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plus21Elements {

    WebDriver ldriver;
    public Plus21Elements(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //+21Element's
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    @CacheLookup
    WebElement btnYes;
    @FindBy(xpath = "//a[@class='btn btn-outline-light btn-lg btn-block border-width-lg']")
    @CacheLookup
    WebElement btnNo;

    public void clickYes() {
        btnYes.isDisplayed();
        btnYes.click();
    }
    public void clickNo() {
        btnNo.isDisplayed();
        btnNo.click();
    }

}
