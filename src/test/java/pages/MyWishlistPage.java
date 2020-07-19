package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyWishlistPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";
    String SEARCH = "#name";
    String DELETE = ".icon-remove";



    public MyWishlistPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyWishlistPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }


}
