package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    By PAGE_VALIDATION = By.cssSelector("img.logo.img-responsive");
    By EMAIL_ADDRESS = By.id("email_create");
    By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");

    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public LoginPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RegistrationPage openRegistrationPage(String email) {
        $(EMAIL_ADDRESS).sendKeys(email);
        $(CREATE_ACCOUNT_BUTTON).click();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.isPageOpened();
        return registrationPage;
    }
}
