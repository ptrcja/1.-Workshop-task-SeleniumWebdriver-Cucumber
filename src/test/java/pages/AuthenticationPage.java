package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
 private final WebDriver driver;


    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        //First navigate to the login page
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        //Find and fill email field
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();    // Make sure field is focused
        loginInput.clear();   // Clear any existing field
        loginInput.sendKeys(email); // Type in the email

        //Find and fill password field
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        //Find and click sign in button
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
       // Username Verification
    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.cssSelector(".account"));
        return userName.getText();

}
}

