package imbutelieriTests;

import imbutHooks.Hooks;
import imbutModels.UserModel;
import imbutUtils.JsonUtils;
import imbutUtils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPageTest extends Hooks {

    @Test
    public void loginValidUser() {
        LoggerUtil.infoLog("Loading user data from JSON");
        UserModel user = JsonUtils.getTestData().getValidUser();
        acceptCookiesIfPresent();

        // Click pe Menu "Contul meu"
        LoggerUtil.infoLog("Click on Contul Meu");
        WebElement contulMeu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Contul meu']")));
        contulMeu.click();

        // Completare in field 'Email'
        LoggerUtil.infoLog("Typing email");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-email")));
        emailField.sendKeys(user.getEmail());

        // Completare in field 'Password'
        LoggerUtil.infoLog("Typing password");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-password")));
        passwordField.sendKeys(user.getPassword());

        // Click pe butonul 'Autentificare'
        LoggerUtil.infoLog("Click on Login");
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Autentificare']")));
        loginBtn.click();
    }
}




