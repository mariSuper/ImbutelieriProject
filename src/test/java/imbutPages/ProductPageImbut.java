package imbutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductPageImbut {
    public WebDriver driver;

    @Test
    public void imbutelieriProductsTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imbutelieri.ro/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click pe meniul 'CATEGORII'
        WebElement categoriiElement = driver.findElement(
                By.xpath("//div[contains(@class,'left')]//span[contains(text(),'Categorii')]"));
        categoriiElement.click();

        // Click pe submeniul 'Borcane'
        WebElement borcaneElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'a-top-link a-item')]//span[contains(text(),'Borcane')]")));
        borcaneElement.click();

        // Click pe produsul 'Borcan Amfora'
        WebElement amforaElement = driver.findElement(
                By.xpath("//a[normalize-space()='Borcan 106 ml Amfora']"));
        amforaElement.click();

        // Completare in field 'Cantitate'
        WebElement cantitateElement = driver.findElement(By.id("input-quantity"));
        cantitateElement.click();
        cantitateElement.clear();
        cantitateElement.sendKeys("2");

        // Click Buton '+adauga in cos'
        WebElement addCosElement = driver.findElement(By.id("button-cart"));
        addCosElement.click();

        // Apelez metoda pt popup
        closeLoginModalIfPresent();

        // Inchidere mesaj de 'succes' daca apare
        try {
            WebElement closeSuccessMessage = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector(".alert-success .close")));
            closeSuccessMessage.click();
            System.out.println("Success message closed");
        } catch (Exception e) {
            System.out.println("Success message not present");
        }

        // Verific 'cos'
        WebElement iconCosElement = driver.findElement(By.id("cart"));
        iconCosElement.click();

        // Apelez metoda pt popup
        closeLoginModalIfPresent();

        // Click buton 'X' (Eliminare produs)
        WebElement buttonDeleteElement = driver.findElement(By.className("icon-delete"));
        buttonDeleteElement.click();
    }

        // Metoda inchidere pop-up de login
        public void closeLoginModalIfPresent() {
          try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement loginModal = shortWait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("loginModal")));
            System.out.println("Login modal detected");
            WebElement closeBtn = driver.findElement(
                    By.cssSelector("#loginModal .close"));
            closeBtn.click();
            System.out.println("Login modal closed");
              } catch (Exception e) {
          }
        }
    }

