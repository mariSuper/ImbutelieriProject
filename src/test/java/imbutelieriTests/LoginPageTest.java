package imbutelieriTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    @Test
    public void loginValidUser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Homepage
        driver.get("https://www.imbutelieri.ro/");

        // Click "Contul meu"
        WebElement contulMeu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Contul meu']")));
        contulMeu.click();

        // Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-email")));
        emailField.sendKeys("gabimari2022art@gmail.com");

        // Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-password")));
        passwordField.sendKeys("Indexare1!");

        // Login
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Autentificare']")));
        loginBtn.click();

        // închide sesiunea
        driver.quit();
    }
}




