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
    String ITEM_NAME = "//a[@class='product-name'][contains(text(),'%s')]";
    String ITEM_PRICE = "//span[@class='price product-price'][contains(text(),'%s')]";
    String ITEM_MORE = ".lnk_view";
    String ITEM_WISHLIST = ".wishlist";
    String DELETE_ITEM_FROM_CART = ".ajax_cart_block_remove_link";
    Map<String, ProductComponent> productComponent = new HashMap<>();
    List<SelenideElement> productComponentRow = $$(ITEM_COMPONENT);
    List<SelenideElement> productNames = $$(By.xpath(ITEM_NAME));
    List<SelenideElement> productPrices = $$(By.xpath(ITEM_PRICE));
    List<SelenideElement> productAddToCart = $$(ITEM_ADD_TO_CART);
    List<SelenideElement> productMore = $$(ITEM_MORE);
    List<SelenideElement> productWishlist = $$(ITEM_WISHLIST);

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
        for (int i = 0; i < $$(productComponentRow).size(); i++) {
            productComponent.put($$(productNames).get(i).getText(),
                    new ProductComponent(
                            productNames.get(i),
                            productPrices.get(i),
                            productAddToCart.get(i),
                            productMore.get(i),
                            productWishlist.get(i)
                    ));
        }
        return this;
    }

    public InventoryPage addToCart(String productName) {
        productComponent.get(productName).addToCart.click();
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