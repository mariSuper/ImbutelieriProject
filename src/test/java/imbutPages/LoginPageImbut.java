package imbutPages;

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
    public void clickLoginIcon() {elementsMethod.clickElement(loginButtonElement);
    }
    // Completez field-ul 'email'
    public void enterEmail(String email) {elementsMethod.fillElement(emailElement, email);
    }
    // Completez field-ul 'password'
    public void enterPassword(String password) {elementsMethod.fillElement(passwordElement, password);
    }
    // Click pe butonul de 'Autentificare'
    public void clickSubmit() {
        elementsMethod.clickElement(submitButtonElement);
    }

    // Actiune compusa (FLOW)
    public void login(String email, String password) {
        clickLoginIcon();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
