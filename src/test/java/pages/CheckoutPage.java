package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckoutPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=order&step=1";
    String TERMS_OF_SERVICE = "#uniform-cgv";
    String PAY_BY_BANK_WIRE = ".bankwire";
    String PAY_BY_CHEQUE = ".cheque";
    String OTHER_PAYMENT_METHOD = ".button-exclusive";
    String ORDER_CONFIRMATION = ".box";

    public CheckoutPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public CheckoutPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
    public CheckoutPage validateCheckoutAndConfirm() {
        isPageOpened();
        $(PROCEED_TO_CHECKOUT).click();
        $(TERMS_OF_SERVICE).shouldBe(Condition.checked);
        $(PROCEED_TO_CHECKOUT).click();
        $(PAY_BY_BANK_WIRE).click();
        $(PROCEED_TO_CHECKOUT).shouldHave(text("I confirm my order")).click();
        $(ORDER_CONFIRMATION).shouldHave(text("Your order on My Store is complete."),
                text("Amount"));
        return this;
    }

}
