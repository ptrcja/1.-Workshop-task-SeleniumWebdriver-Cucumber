package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressesPage {
    private final WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateNewAddress() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[data-link-action='add-address']"));
        createNewAddress.click();
    }

    public void deleteAddress() {
        WebElement deleteButton = driver.findElement(By.cssSelector("[data-link-action='delete-address']"));
        deleteButton.click();
    }

    public boolean isAddressDeleted() {
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        return successMessage.isDisplayed();
    }
}

