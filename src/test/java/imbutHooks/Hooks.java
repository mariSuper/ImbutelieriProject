package imbutHooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hooks {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Homepage
        driver.get("https://www.imbutelieri.ro/");
    }
    // Metodă helper
    protected void acceptCookiesIfPresent(){
        try {
            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
            acceptCookies.click();
        } catch (Exception e){
            System.out.println("Cookie banner nu a aparut");
        }
    }

    @AfterMethod
    public void teardown(){
//        driver.quit();
    }
}
