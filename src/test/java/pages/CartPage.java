package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    String URL = "http://automationpractice.com/index.php?controller=order";
    String DELETE_FROM_CART = "//table[@id='cart_summary']//tbody//tr[%s]//td[7]//a[@class='cart_quantity_delete']";
    String INCREASE_QUANTITY = "//table[@id='cart_summary']//tbody//tr[%s]//td[5]//a[@class='cart_quantity_up btn btn-default button-plus']";
    String DECREASE_QUANTITY = "//table[@id='cart_summary']//tbody//tr[%s]//td[5]//a[@class='cart_quantity_down btn btn-default button-minus']";
    String QUANTITY = "//table[@id='cart_summary']//tbody//tr[%s]//td[5]//input[@class='cart_quantity_input form-control grey']";

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
}
