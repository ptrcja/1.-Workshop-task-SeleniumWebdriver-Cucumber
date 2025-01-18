package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AddressSteps {
    private WebDriver driver;

    @Given("I'm on mystore main page")
    public void openMyStoreMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I sign in with email {string} and password {string}")
    public void iSignInWithEmailAndPassword(String email, String password) {
        driver.findElement(By.cssSelector("a[title='Log in to your customer account']")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("I click on addresses tile")
    public void iClickOnAddressesTile() {
        driver.findElement(By.id("addresses-link")).click();
    }

    @And("I click Create new address")
    public void iClickCreateNewAddress() {
        driver.findElement(By.cssSelector("a[data-link-action='add-address']")).click();
    }

    @And("I fill the address form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void iFillAddressFormWithData(String alias, String address, String city,
                                         String postalCode, String country, String phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(postalCode);

        // Select country from dropdown
        driver.findElement(By.name("id_country")).click();


        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.cssSelector("button.form-control-submit")).click();
    }

    @Then("the address data should be correct for {string}, {string}, {string}, {string}, {string}, {string}")
    public void verifyAddressData(String alias, String address, String city,
                                  String postalCode, String country, String phone) {

        // Find the specific address block containing alias
        WebElement targetAddress = driver.findElement(
                By.xpath("//article[contains(@class, 'address')]//h4[text()='" + alias + "']/../..")
        );

        String addressText = targetAddress.getText();

        //  Verification that all details are present
        Assert.assertTrue("Address details verification failed",
                addressText.contains(address) &&
                        addressText.contains(city) &&
                        addressText.contains(postalCode) &&
                        addressText.contains(phone));
    }

    @When("I delete the address")
    public void iDeleteTheAddress() {
        // There is more specific selector to find the delete button within the "Home" address block
        String xpathForHomeAddressDelete = "//article[contains(@class, 'address')]//h4[text()='Home']/../..//a[@data-link-action='delete-address']";
        WebElement deleteButton = driver.findElement(By.xpath(xpathForHomeAddressDelete));
        deleteButton.click();
    }

    @Then("I can see success message {string}")
    public void iCanSeeSuccessMessage(String expectedMessage) {
        WebElement alert = driver.findElement(By.cssSelector("article.alert.alert-success"));
        Assert.assertEquals(expectedMessage, alert.getText().trim());
    }

    @And("I close mystore browser")
    public void closeMyStoreBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}