package tests;

import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class AutomationPracticeTest extends BaseTest {
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void registration() {
//        loginPage
//                .openPage()
//                .openRegistrationPage("helel@mailinator.com")
//                .fillRegistrationForm("Ms.","Hell","Yeah","11111",
//                        20,3,"1996","Hello kitty street, 19","Miami",
//                        "Florida","12345","United States",
//                        "Hate women clothes","99129045","Miami Beach")
//                .submitRegistration();
//    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void login() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com", "12345");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCartTest() {
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("Printed Summer Dress $28.98")
                .continueShopping()
                .addToCart("Faded Short Sleeve T-shirts $16.51")
                .continueShopping()
                .addToCart("Printed Dress $26.00")
                .proceedToCheckout()
                .initializeAllProductsInCart()
                .setQuantityValue("Printed Summer Dress $28.98", "10");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void buyingProductTest() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com", "12345");
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("Blouse $27.00")
                .continueShopping()
                .addToCart("Faded Short Sleeve T-shirts $16.51")
                .continueShopping()
                .addToCart("Printed Dress $26.00")
                .proceedToCheckout();
        cartPage
                .isPageOpened()
                .initializeAllProductsInCart()
                .validateCheckoutAndConfirm();
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void wishlistTest() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com", "12345");
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToWishlist("Printed Dress $26.00")
                .addToWishlist("Printed Dress $50.99")
                .addToWishlist("Printed Summer Dress $28.98")
                .addToWishlist("Printed Chiffon Dress $16.40");
        myWishlistPage
                .openPage()
                .searchAndAddNewItemByName("Adidas")
                .searchAndAddNewItemByName("New president")
                .searchAndAddNewItemByName("Blouse")
                .deleteFromWishlist("Blouse")
                .deleteFromWishlist("Adidas")
                .deleteFromWishlist("My wishlist");
    }
}
