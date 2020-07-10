package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    String URL = "http://automationpractice.com/index.php?controller=order";
    String DELETE_FROM_CART = "//tr[%s]//a[@class='cart_quantity_delete']";
    String INCREASE_QUANTITY = "//tr[%s]//a[@class='cart_quantity_up btn btn-default button-plus']";
    String DECREASE_QUANTITY = "//tr[%s]//a[@class='cart_quantity_down btn btn-default button-minus']";
    String QUANTITY = "//tr[%s]//input[@class='cart_quantity_input form-control grey']";
    String Price = "#total_price";

    public CartPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public CartPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }
    public CartPage deleteFromCart(int delete, int quantityIncrease, int quantityDecrease, String quantitySetValue, int quantity) {
        By increaseQuantity = By.xpath(String.format(INCREASE_QUANTITY, quantityIncrease));
        By decreaseQuantity = By.xpath(String.format(DECREASE_QUANTITY, quantityDecrease));
        By quantityValue = By.xpath(String.format(QUANTITY, quantity));
        $(quantityValue).setValue(quantitySetValue);
        $(decreaseQuantity).click();
        $(increaseQuantity).doubleClick();
        By deleteFromCart = By.xpath(String.format(DELETE_FROM_CART, delete));
        $(deleteFromCart).shouldBe(Condition.visible).click();
        return this;
    }
    public CheckoutPage proceedToCheckout() {
        $(PROCEED_TO_CHECKOUT).click();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.isPageOpened();
        return checkoutPage;
    }
}
