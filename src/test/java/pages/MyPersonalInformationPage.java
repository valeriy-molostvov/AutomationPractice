package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyPersonalInformationPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=identity";

    public MyPersonalInformationPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyPersonalInformationPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
}
