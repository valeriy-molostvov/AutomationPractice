package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyCreditSlipsPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=order-slip";

    public MyCreditSlipsPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyCreditSlipsPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
}
