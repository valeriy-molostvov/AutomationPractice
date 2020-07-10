package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAddressesPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=addresses";

    public MyAddressesPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyAddressesPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
}
