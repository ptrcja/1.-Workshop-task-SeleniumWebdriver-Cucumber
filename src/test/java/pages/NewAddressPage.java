package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private final WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(name = "id_country")
    private WebElement countrySelect;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(css = "button.form-control-submit")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement successMessage;


    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillNewAddressForm(String alias, String address, String city,
                                   String postalCode, String country, String phone) {
        // Fill the actual form fields
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postalCode);

        countrySelect.click();
        countrySelect.sendKeys(country);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        submitButton.click();
    }

    // To verify that the address has been added - related with last Findby
    public boolean isAddressAddedSuccessfully() {
        return successMessage.isDisplayed();

    }
}

