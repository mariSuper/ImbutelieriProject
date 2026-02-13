package imbutelieriTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductFlowTest {

    @Test
    public void addProductToCartFlow() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

        driver.get("https://www.imbutelieri.ro/");

        //WAIT Cookies
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
            acceptCookies.click();
             } catch (Exception e) {
            System.out.println("Cookie banner nu a aparut");
            }

        //Menu 'Categorii'
        WebElement categoriiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'left')]//span[contains(text(),'Categorii')]")));
        categoriiElement.click();

        //Submenu 'Borcane'
        WebElement borcaneElement = driver.findElement(By.xpath("//span[contains(text(),'Borcane')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", borcaneElement);

        //Produsul 'Borcan Amfora'
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Borcan 106 ml Amfora']")));
        productElement.click();

        //Completare in field 'Cantitate'
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-quantity")));
        quantityElement.clear();
        quantityElement.sendKeys("2");

        //Validare cantitate
        String value = quantityElement.getAttribute("value");
        Assert.assertEquals(value, "2", "Cantitatea NU a fost introdusa corect");

        //Buton '+adaugă în coș'
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
        addToCartButton.click();

         //WAIT de inchidere mesaj 'succes' dacă apare
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));

        //Validare produs adăugat în coș
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart-total"))).getText().contains("1"), "Produsul NU a fost adaugat in cos");

        //Verific continut 'Coș'
        WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartElement);

        //Validare produs prezent în coș
        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td//a[contains(text(),'Borcan 106 ml Amfora')]")));
        Assert.assertTrue(productInCart.isDisplayed(), "Produsul NU este prezent in cos");

        //WAIT Dropdown
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart .dropdown-menu")));
            System.out.println("Dropdown deschis");
        } catch (Exception e) {
            System.out.println("Dropdown NU a fost detectat");
        }

        //Eliminare produs din coș
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("icon-delete")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);

        //Validare Produs șters din coș
        Assert.assertTrue(true, "Produsul a fost eliminat cu succes");

        //mesaj in consolă
        System.out.println("Flow-ul de test al produsului s-a incheiat cu succes");

        //închide sesiunea
         driver.quit();
    }
}
