package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public LoginPage openPage() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        isPageOpened();
        return this;
    }

    public LoginPage isPageOpened() {
        $("img.logo.img-responsive").waitUntil(Condition.visible, 30000);
        return this;
    }
}
