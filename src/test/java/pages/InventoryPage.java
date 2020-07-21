package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    By SORT_LIST = By.className("icon-th-list");
    By CART_LAYER = By.id("layer_cart");
    String ITEM_COMPONENT = ".product-container";
    String ITEM_ADD_TO_CART = ".ajax_add_to_cart_button";
    String ITEM_NAME = "//ul[@class='product_list row list']//a[@class='product-name']";
    String ITEM_PRICE = "//div[@class='right-block-content row']//span[@class='price product-price']";
    String ITEM_MORE = ".lnk_view";
    String ITEM_WISHLIST = ".wishlist";
    String DELETE_ITEM_FROM_CART = ".ajax_cart_block_remove_link";
    String VALIDATE_POP_UP_AFTER_CLICKING_ON_WISHLIST = ".fancybox-skin";
    String CLOSE_WISHLIST_POP_UP = ".fancybox-close";
    Map<String, ProductComponent> productComponent = new HashMap<>();

    public InventoryPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public InventoryPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public InventoryPage initializeAllProducts() {
        List<SelenideElement> productsName = $$(By.xpath(ITEM_NAME));
        List<SelenideElement> productsPrices = $$(By.xpath(ITEM_PRICE));
        List<SelenideElement> productAddToCart = $$(ITEM_ADD_TO_CART);
        List<SelenideElement> productMore = $$(ITEM_MORE);
        List<SelenideElement> productWishlist = $$(ITEM_WISHLIST);
        for (int i = 0; i < $$(ITEM_COMPONENT).size(); i++) {
            productComponent.put(productsName.get(i).getText() + " " + productsPrices.get(i).getText(),
                    new ProductComponent(
                            productsPrices.get(i),
                            productsName.get(i),
                            productAddToCart.get(i),
                            productMore.get(i),
                            productWishlist.get(i)));
        }
        return this;
    }

    public InventoryPage addToCart(String productNameAndPrice) {
        productComponent.get(productNameAndPrice).addToCart.click();
        return this;
    }

    public InventoryPage addToWishlist(String productPrice) {
        productComponent.get(productPrice).addToWishlist.click();
        $(CLOSE_WISHLIST_POP_UP).click();
        return this;
    }

    public InventoryPage clickMore(String productPrice) {
        productComponent.get(productPrice).more.click();
        return this;
    }

    public InventoryPage continueShopping() {
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(CONTINUE_SHOPPING).click();
        isPageOpened();
        return this;
    }

    public CartPage proceedToCheckout() {
        $(CART_LAYER).waitUntil(Condition.visible, 30000);
        $(PROCEED_TO_CHECKOUT).click();
        CartPage cartPage = new CartPage();
        cartPage.isPageOpened();
        return cartPage;
    }

    public InventoryPage listViewOfProducts() {
        isPageOpened();
        $(SORT_LIST).click();
        return this;
    }
}