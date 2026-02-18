package methodsImbutelieri;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsMethod {
    WebDriver driver;
    WebDriverWait wait;

    public ElementsMethod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // WAIT element clickabil
    public void waitClickableElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // WAIT element vizibil
    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // CLICK simplu
    public void clickElement(WebElement element) {
        waitClickableElement(element);
        element.click();
    }

    // COMPLETEAZA input
    public void fillElement(WebElement element, String text) {
        waitVisibleElement(element);
        element.clear();
        element.sendKeys(text);
    }

    // CLICK cu JavaScript
    public void clickElementJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}



