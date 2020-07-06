package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage extends BasePage{
    String URL = "http://automationpractice.com/index.php?controller=my-account";

    public MyAccountPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }


}
