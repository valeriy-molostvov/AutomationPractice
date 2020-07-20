package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class MyWishlistPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";
    String SEARCH = "#name";
    String SAVE_BUTTON = "#submitWishlist";
    By ALL_ITEM_WISHLIST = By.xpath("//table[@class='table table-bordered']//tbody/tr");
    String WISHLIST_NAME = "//td[1]/a";
    String WISHLIST_QUANTITY = "//td[2]";
    String WISHLIST_CREATED = "//td[4]";
    By WISHLIST_DIRECT_LINK = By.partialLinkText("View");
    By WISHLIST_DELETE = By.xpath("//td[@class='wishlist_delete']/a");
    Map<String, WishlistComponent> wishlistComponent = new HashMap<>();

    public MyWishlistPage openPage() {
        open(URL);
        isPageOpened();
        initializeAllProductsInWishlist();
        return this;
    }

    public MyWishlistPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public MyWishlistPage initializeAllProductsInWishlist() {
        List<SelenideElement> wishlistName = $$(By.xpath(WISHLIST_NAME));
        List<SelenideElement> wishlistQuantity = $$(By.xpath(WISHLIST_QUANTITY));
        List<SelenideElement> wishlistCreated = $$(By.xpath(WISHLIST_CREATED));
        List<SelenideElement> wishlistDirectLink = $$(WISHLIST_DIRECT_LINK);
        List<SelenideElement> wishlistDelete = $$(WISHLIST_DELETE);
        for (int i = 0; i < $$(ALL_ITEM_WISHLIST).size(); i++) {
            wishlistComponent.put(wishlistName.get(i).getText(),
                    new WishlistComponent(
                            wishlistName.get(i),
                            wishlistQuantity.get(i),
                            wishlistCreated.get(i),
                            wishlistDirectLink.get(i),
                            wishlistDelete.get(i)
                    ));
        }
        return this;
    }

    public MyWishlistPage deleteFromWishlist(String itemName) {
        wishlistComponent.get(itemName).delete.click();
        confirm("Do you really want to delete this wishlist ?");
        initializeAllProductsInWishlist();
        return this;
    }

    public MyWishlistPage searchAndAddNewItemByName(String addNewItemToWishlist) {
        $(SEARCH).sendKeys(addNewItemToWishlist);
        $(SAVE_BUTTON).click();
        initializeAllProductsInWishlist();
        return this;
    }
}
