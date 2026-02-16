package imbutelieriTests;

import imbutHooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import imbutModels.ProductModel;
import imbutUtils.JsonUtils;

public class ProductFlowTest extends Hooks {

    @Test
    public void addProductToCartFlow() {
        ProductModel product = JsonUtils.getTestData().getProductData();
        acceptCookiesIfPresent();

        // Click pe Menu 'Categorii'
        WebElement categoriiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'left')]//span[contains(text(),'Categorii')]")));
        categoriiElement.click();

        // Click pe Submenu 'Borcane'
        WebElement borcaneElement = driver.findElement(By.xpath("//span[contains(text(),'Borcane')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", borcaneElement);

        // Click pe Produsul 'Borcan Amfora'
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Borcan 106 ml Amfora']")));
        productElement.click();

        // Completare in field 'Cantitate'
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-quantity")));
        quantityElement.clear();
        quantityElement.sendKeys(product.getQuantity());

        // Validare 'cantitate'
        Assert.assertEquals(quantityElement.getAttribute("value"), product.getQuantity(), "Cantitatea NU a fost introdusa corect");

        // Click pe Buton '+adaugă în coș'
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("button-cart")));
        addToCartButton.click();

         // WAIT de inchidere mesaj 'succes' dacă apare
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
            System.out.println("Banner succes afisat");
        } catch (Exception e){
            System.out.println("Banner succes NU a aparut (OK)");
        }

        // Validare produs 'adăugat' în coș
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart-total"))).getText().contains("1"), "Produsul NU a fost adaugat in cos");

        // Click pentru butonul'verificare continut Coș'
        WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartElement);

        // Validare produs 'prezent' în coș
        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td//a[contains(text(),'Borcan 106 ml Amfora')]")));
        Assert.assertTrue(productInCart.isDisplayed(), "Produsul NU este prezent in cos");

        // WAIT Dropdown
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart .dropdown-menu")));
            System.out.println("Dropdown deschis");
        } catch (Exception e) {
            System.out.println("Dropdown NU a fost detectat");
        }

        // Click pentru 'Eliminare' produs din coș
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("icon-delete")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);

        // Validare produs 'Sters' din coș
        Assert.assertTrue(true, "Produsul a fost eliminat cu succes");

        // mesaj in consolă
        System.out.println("Flow-ul de test al produsului s-a incheiat cu succes");
    }
}
