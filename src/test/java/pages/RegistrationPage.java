package pages;

import com.codeborne.selenide.Condition;
import models.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
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
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RegistrationPage fillRegistrationForm(Account account) {
        isPageOpened();
        if (!account.getGender().equals("Mr.")) {
            $(GENDER_FEMALE).click();
        } else {
            $(GENDER_MALE).click();
        }
        $(FIRST_NAME).sendKeys(account.getFirst_name());
        $(LAST_NAME).sendKeys(account.getLast_name());
        $(PASSWORD).setValue(account.getPassword());
        $(DATE_OF_BIRTH_DAYS).selectOption(account.getDay());
        $(DATE_OF_BIRTH_MONTHS).selectOption(account.getMonth());
        $(DATE_OF_BIRTH_YEARS).selectOptionByValue(account.getYear());
        $(ADDRESS).sendKeys(account.getAddress());
        $(CITY).sendKeys(account.getCity());
        $(STATE).selectOptionContainingText(account.getState());
        $(ZIP_CODE).sendKeys(account.getZip_code());
        $(COUNTRY).selectOption(account.getCountry());
        $(ADDITIONAL_INFORMATION).sendKeys(account.getAdditional_information());
        $(MOBILE_PHONE).sendKeys(account.getMobile_phone());
        $(ADDRESS_ALIAS).clear();
        $(ADDRESS_ALIAS).sendKeys(account.getAddress_alias());
        return this;
    }

    public void submitRegistration() {
        isPageOpened();
        $(SUBMIT_REGISTRATION).click();
    }
}