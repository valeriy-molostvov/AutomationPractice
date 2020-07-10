package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    String URL = "http://automationpractice.com/index.php?controller=order";
    String DELETE_FROM_CART = "//tr[%s]//a[@class='cart_quantity_delete']";
    String QUANTITY = "//tr[%s]//input[@class='cart_quantity_input form-control grey']";
    String Price = "#total_price";
    String TERMS_OF_SERVICE = "#cgv";
    String PAY_BY_BANK_WIRE = ".bankwire";
    String PAY_BY_CHEQUE = ".cheque";
    String OTHER_PAYMENT_METHOD = ".button-exclusive";
    String ORDER_CONFIRMATION = ".box";
    String PROCEED_TO_CHECKOUT_SUMMARY = ".standard-checkout";
    String PROCEED_TO_CHECKOUT_PAYMENT = "//span[contains(text(),'I confirm my order')]";
    By PROCEED_TO_CHECKOUT_ADDRESS = By.name("processAddress");
    By PROCEED_TO_CHECKOUT_SHIPPING = By.name("processCarrier");

    public CartPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public CartPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
    public CartPage deleteFromCart(int columnNumberOfProduct) {
        By deleteFromCart = By.xpath(String.format(DELETE_FROM_CART, columnNumberOfProduct));
        $(deleteFromCart).shouldBe(Condition.visible).click();
        return this;
    }
    public CartPage changeQuantity(int columnNumberOfProduct, String quantitySetValue) {
        By quantityValue = By.xpath(String.format(QUANTITY, columnNumberOfProduct));
        $(quantityValue).setValue(quantitySetValue);
        return this;
    }

    public CartPage validateCheckoutAndConfirm() {
        isPageOpened();
        $(PROCEED_TO_CHECKOUT_SUMMARY).click();
        $(PROCEED_TO_CHECKOUT_ADDRESS).click();
        $(TERMS_OF_SERVICE).click();
        $(TERMS_OF_SERVICE).shouldBe(checked);
        $(PROCEED_TO_CHECKOUT).click();
        $(PAY_BY_BANK_WIRE).click();
        $(PROCEED_TO_CHECKOUT_PAYMENT).click();
        $(ORDER_CONFIRMATION).shouldHave(text("Your order on My Store is complete."),
                text("Amount"));
        return this;
    }
}
