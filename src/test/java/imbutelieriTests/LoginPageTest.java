package imbutelieriTests;

import imbutHooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPageTest extends Hooks {

    @Test
    public void loginValidUser() {
        acceptCookiesIfPresent();

        // Click pe Menu "Contul meu"
        WebElement contulMeu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Contul meu']")));
        contulMeu.click();

        // Completare in field 'Email'
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-email")));
        emailField.sendKeys("gabimari2022art@gmail.com");

        // Completare in field 'Password'
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-password")));
        passwordField.sendKeys("Indexare1!");

        // Click pe butonul 'Autentificare'
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Autentificare']")));
        loginBtn.click();
    }
}




