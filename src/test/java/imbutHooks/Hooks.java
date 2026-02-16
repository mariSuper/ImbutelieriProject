package imbutHooks;

import imbutUtils.LoggerUtil;
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
    protected String testName;

    @BeforeMethod
    public void setup(){
        testName = this.getClass().getSimpleName();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Homepage
        driver.get("https://www.imbutelieri.ro/");

        // Logger pornire test automat
        LoggerUtil.startTest(testName);
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
        driver.quit();

        // Logger oprire test automat
        LoggerUtil.endTest(testName);
    }
}
