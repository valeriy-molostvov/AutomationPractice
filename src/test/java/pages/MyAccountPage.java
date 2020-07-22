package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage extends BasePage {
    String URL = "http://automationpractice.com/index.php?controller=my-account";
    By ORDER_HISTORY_AND_DETAILS = By.className("icon-list-ol");
    By MY_WISHLIST = By.className("icon-heart");

    public MyAccountPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(PAGE_VALIDATION).waitUntil(Condition.visible, 30000);
        return this;
    }

    public OrderHistoryPage goToOrderHistoryAndDetails() {
        isPageOpened();
        $(ORDER_HISTORY_AND_DETAILS).shouldBe(Condition.visible).click();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
        orderHistoryPage.isPageOpened();
        return orderHistoryPage;
    }

    public MyWishlistPage goToMyWishlistPage() {
        isPageOpened();
        $(MY_WISHLIST).shouldBe(Condition.visible).click();
        MyWishlistPage myWishlistPage = new MyWishlistPage();
        myWishlistPage.isPageOpened();
        return myWishlistPage;
    }
}