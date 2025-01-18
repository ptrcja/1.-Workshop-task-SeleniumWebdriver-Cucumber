package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickAddressesTile() {
        // Find Addresses tile and click it
        WebElement addressesTile = driver.findElement(By.id("addresses-link")); // (By.cssSelector("#addresses-link"));
        addressesTile.click();
    }
}
