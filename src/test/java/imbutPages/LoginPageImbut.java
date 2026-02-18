package imbutPages;

import imbutUtils.LoggerUtil;
import methodsImbutelieri.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageImbut {
    private WebDriver driver;
    private ElementsMethod elementsMethod;


    public LoginPageImbut(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    // Elemente
    // Butonul 'Contul meu'
    @FindBy(xpath = "//span[text()='Contul meu']")
    private WebElement loginButtonElement;

    // Field-ul 'email'
    @FindBy(id = "input-email")
    private WebElement emailElement;

    // Field-ul 'password'
    @FindBy(id = "input-password")
    private WebElement passwordElement;

    // Butonul de 'Autentificare'
    @FindBy(xpath = "//input[@value='Autentificare']")
    private WebElement submitButtonElement;

    // Actiuni
    // Click pe butonul 'Contul meu'
    public void clickLoginIcon() {LoggerUtil.infoLog("Click on Contul Meu button");
        elementsMethod.clickElement(loginButtonElement);
    }

    // Completez field-ul 'email'
    public void enterEmail(String email) {LoggerUtil.infoLog("Typing email field");
        elementsMethod.fillElement(emailElement, email);
    }
    // Completez field-ul 'password'
    public void enterPassword(String password) {LoggerUtil.infoLog("Typing password field");
        elementsMethod.fillElement(passwordElement, password);
    }
    // Click pe butonul de 'Autentificare'
    public void clickSubmit() {LoggerUtil.infoLog("Click on Autentificare button");
        elementsMethod.clickElement(submitButtonElement);
    }

    // Actiune compusa (Autentificare)
    public void login(String email, String password) {LoggerUtil.infoLog("Login action");
        clickLoginIcon();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
