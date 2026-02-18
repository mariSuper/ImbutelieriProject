package imbutPages;

import imbutUtils.LoggerUtil;
import methodsImbutelieri.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageImbut {
    private WebDriver driver;
    private ElementsMethod elementsMethod;

    public HomePageImbut(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    // Elemente
    // Buton 'Contact'
    @FindBy(xpath = "//a[@class='a-top-link']//span[contains(text(),'Contact')]")
    private WebElement contactElement;

    // Buton 'Acasa'
    @FindBy(xpath = "//a[@class='a-top-link']//span[contains(text(),'Acasa')]")
    private WebElement acasaElement;

    // Acțiuni
    // Click pe buton 'Contact'
    public void clickContact() {
        LoggerUtil.infoLog("Click on Contact button");
        elementsMethod.clickElement(contactElement);
    }

    // Click pe buton 'Acasa'
    public void clickAcasa() {
        LoggerUtil.infoLog("Click on Acasa button");
        elementsMethod.clickElement(acasaElement);
    }
}








