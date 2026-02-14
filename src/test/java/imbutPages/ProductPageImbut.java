package imbutPages;

import methodsImbutelieri.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageImbut {
    public WebDriver driver;
    private ElementsMethod elementsMethod;

    public ProductPageImbut(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    // Elemente
    // Meniul 'CATEGORII'
    @FindBy(xpath = "//div[contains(@class,'left')]//span[contains(text(),'Categorii')]")
    private WebElement categoriiElement;

    // Submeniul 'Borcane'
    @FindBy(xpath = "//a[contains(@class,'a-top-link a-item')]//span[contains(text(),'Borcane')]")
    private WebElement borcaneElement;

    // Produsul 'Borcan Amfora'
    @FindBy(xpath = "//a[normalize-space()='Borcan 106 ml Amfora']")
    private WebElement amforaElement;

    // Field 'Cantitate'
    @FindBy(id = "input-quantity")
    private WebElement cantitateElement;

    // Buton '+adauga in cos'
    @FindBy(id = "button-cart")
    private WebElement addCosElement;

    // Verificare 'cos'
    @FindBy(id = "cart")
    private WebElement iconCosElement;

    // Stergere produs din Cos
    @FindBy(id = "icon-delete")
    private WebElement buttonDeleteElement;

    // Actiuni
    // Click pe meniul 'CATEGORII'
    public void clickCategoriiElement() {elementsMethod.clickElement(categoriiElement);
    }

    // Click pe submeniul 'Borcane'
    public void clickBorcaneElement() {elementsMethod.clickElement(borcaneElement);
    }

    // Click pe produsul 'Borcan Amfora'
    public void clickAmforaElement() {elementsMethod.clickElement(amforaElement);
    }

    // Completare in field 'Cantitate'
    public void setQuantityElement() {elementsMethod.fillElement(cantitateElement, "2");
    }

    // Click pe Buton '+adauga in cos'
    public void clickAddToCartElement() {elementsMethod.clickElement(addCosElement);
    }

    // Verific 'cos'
    public void openCartElement() {elementsMethod.clickElement(iconCosElement);
    }

    // Sterg produsul din Cos
    public void deleteProductElement() {elementsMethod.clickElement(buttonDeleteElement);
    }
}








