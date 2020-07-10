package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage extends BasePage{
    String URL = "http://automationpractice.com/index.php?controller=my-account";
    By ORDER_HISTORY_AND_DETAILS = By.className("icon-list-ol");
    By MY_CREDIT_SLIPS = By.className("icon-ban-circle");
    By MY_ADDRESSES = By.className("icon-building");
    By MY_PERSONAL_INFORMATION = By.className("icon-user");
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
    public MyCreditSlipsPage goToMyCreditSlips() {
        isPageOpened();
        $(MY_CREDIT_SLIPS).shouldBe(Condition.visible).click();
        MyCreditSlipsPage myCreditSlipsPage = new MyCreditSlipsPage();
        myCreditSlipsPage.isPageOpened();
        return myCreditSlipsPage;
    }
    public MyAddressesPage goToMyAddressesPage() {
        isPageOpened();
        $(MY_ADDRESSES).shouldBe(Condition.visible).click();
        MyAddressesPage myAddressesPage = new MyAddressesPage();
        myAddressesPage.isPageOpened();
        return myAddressesPage;
    }
    public MyPersonalInformationPage goToMyPersonalInformationPage() {
        isPageOpened();
        $(MY_PERSONAL_INFORMATION).shouldBe(Condition.visible).click();
        MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage();
        myPersonalInformationPage.isPageOpened();
        return myPersonalInformationPage;
    }
    public MyWishlistPage goToMyWishlistPage() {
        isPageOpened();
        $(MY_WISHLIST).shouldBe(Condition.visible).click();
        MyWishlistPage myWishlistPage = new MyWishlistPage();
        myWishlistPage.isPageOpened();
        return myWishlistPage;
    }
}
