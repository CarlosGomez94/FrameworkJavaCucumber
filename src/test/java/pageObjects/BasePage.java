package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver ldriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver rdriver) {
        ldriver = rdriver;
        wait = new WebDriverWait(ldriver, 15);
        PageFactory.initElements(rdriver, this);
    }

    protected WebElement waitUntilDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}