package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    String ADD_TO_CART_LOCATOR = "//ul[@class='product_list row list']//a[@class='product-name'][contains(text(),'%s') and //div[@class='product-image-container']//span[@class='price product-price'][contains(text(),'%s') and //a[@class='button ajax_add_to_cart_button btn btn-default']]]";
    String NAME_OF_PRODUCT = "//ul[@class='product_list row list']//a[@class='product-name'][contains(text(),'%s')]";
    String PRICE_OF_PRODUCT = "//div[@class='product-image-container']//span[@class='price product-price'][contains(text(),'%s')]";
    By ADD_TO_CART = By.className("button ajax_add_to_cart_button btn btn-default");
    By ITEM_1 = By.xpath("//li[@class='ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_2 = By.xpath("//li[@class='ajax_block_product last-item-of-tablet-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_3 = By.xpath("//li[@class='ajax_block_product last-in-line first-item-of-tablet-line last-item-of-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_4 = By.xpath("//li[@class='ajax_block_product first-in-line last-item-of-tablet-line first-item-of-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_5 = By.xpath("//li[@class='ajax_block_product first-item-of-tablet-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_6 = By.xpath("//li[@class='ajax_block_product last-in-line last-item-of-tablet-line last-item-of-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By ITEM_7 = By.xpath("//li[@class='ajax_block_product first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line col-xs-12']//span[contains(text(),'Add to cart')]");
    By SORT_LIST = By.className("icon-th-list");
    By CART_LAYER = By.id("layer_cart");

    public InventoryPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public InventoryPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public InventoryPage addToCart_1() {
        isPageOpened();
        $(SORT_LIST).click();
        $(ITEM_1).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_2() {
        $(ITEM_2).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_3() {
        $(ITEM_3).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_4() {
        $(ITEM_4).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_5() {
        $(ITEM_5).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_6() {
        $(ITEM_6).click();
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public InventoryPage addToCart_7() {
        $(ITEM_7).click();
        //here is the line for add the item
        return this;
    }

    public CartPage proceedToCheckout() {
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(PROCEED_TO_CHECKOUT).click();
        CartPage cartPage = new CartPage();
        cartPage.isPageOpened();
        return cartPage;
    }
}