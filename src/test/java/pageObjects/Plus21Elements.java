package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plus21Elements extends BasePage {

    //+21Element's
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    @CacheLookup
    WebElement btnYes;
    @FindBy(xpath = "//a[@class='btn btn-outline-light btn-lg btn-block border-width-lg']")
    @CacheLookup
    WebElement btnNo;

    //Metodo a todas las clases
    public Plus21Elements(WebDriver rdriver) {
        super(rdriver);
    }

    public void clickYes() {
        waitUntilDisplayed(btnYes).click();
    }

    public void clickNo() {
        waitUntilDisplayed(btnNo).click();
    }
}
