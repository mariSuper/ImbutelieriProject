package imbutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageImbut {

    WebDriver driver;

    @Test
    public void loginPageImbut() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imbutelieri.ro/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        // Cookies
        try {
            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not present");
        }

        // Click pe "Contul meu"
        WebElement loginButtonElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Contul meu']")));
        loginButtonElement.click();

        // Email
        WebElement emailElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        emailElement.sendKeys("gabimari2022art@gmail.com");

        // Parola
        WebElement passwordElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        passwordElement.sendKeys("Indexare1!");

        // Autentificare
        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@value='Autentificare']")));
        submitButton.click();
    }
}