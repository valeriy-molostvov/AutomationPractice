package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    By REGISTER_BUTTON = By.id("submitAccount");
    By GENDER_MALE = By.id("id_gender1");
    By GENDER_FEMALE = By.id("id_gender2");
    By FIRST_NAME = By.id("customer_firstname");
    By LAST_NAME = By.id("customer_lastname");
    By PASSWORD = By.id("passwd");
    By DATE_OF_BIRTH_DAYS = By.id("days");
    By DATE_OF_BIRTH_MONTHS = By.id("months");
    By DATE_OF_BIRTH_YEARS = By.id("years");
    By ADDRESS = By.id("address1");
    By CITY = By.id("city");
    By STATE = By.id("id_state");
    By ZIP_CODE = By.id("postcode");
    By COUNTRY = By.id("id_country");
    By ADDITIONAL_INFORMATION = By.id("other");
    By MOBILE_PHONE = By.id("phone_mobile");
    By ADDRESS_ALIAS = By.id("alias");
    By SUBMIT_REGISTRATION = By.id("submitAccount");


    public RegistrationPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public RegistrationPage isPageOpened() {
        $(REGISTER_BUTTON).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RegistrationPage fillRegistrationForm( String gender,
            String first_name, String last_name, String password, int day, int month,
            String year, String address, String city, String state, String zip_code, String country,
            String additional_information, String mobile_phone, String address_alias) {
        String Ms = "Ms.";

        if (!gender.equals(Ms)) {$(GENDER_FEMALE).click();}
        else {$(GENDER_MALE).click();}
        $(FIRST_NAME).sendKeys(first_name);
        $(LAST_NAME).sendKeys(last_name);
        $(PASSWORD).sendKeys(password);
        $(DATE_OF_BIRTH_DAYS).selectOption(day);
        $(DATE_OF_BIRTH_MONTHS).selectOption(month);
        $(DATE_OF_BIRTH_YEARS).selectOptionByValue(year);
        $(ADDRESS).sendKeys(address);
        $(CITY).sendKeys(city);
        $(STATE).selectOptionContainingText(state);
        $(ZIP_CODE).sendKeys(zip_code);
        $(COUNTRY).selectOption(country);
        $(ADDITIONAL_INFORMATION).sendKeys(additional_information);
        $(MOBILE_PHONE).sendKeys(mobile_phone);
        $(ADDRESS_ALIAS).clear();
        $(ADDRESS_ALIAS).sendKeys(address_alias);
        return this;
    }

    public void submitRegistration() {
        $(SUBMIT_REGISTRATION).click();
    }
}