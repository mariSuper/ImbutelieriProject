package imbutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageImbut {
    public WebDriver driver;

    //Homepage
    @Test
    public void Imbutelieri() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imbutelieri.ro/");

        // click pe butonul 'Contact'
        WebElement contactElement = driver.findElement(
                By.xpath("//a[@class='a-top-link']//span[contains(text(),'Contact')]"));
        contactElement.click();

        // click inapoi pe butonul 'ACASA'
        WebElement acasaElement = driver.findElement(
                By.xpath("//a[@class='a-top-link']//span[contains(text(),'Acasa')]"));
        acasaElement.click();
    }
}

