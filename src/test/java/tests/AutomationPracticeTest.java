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
    public void addToCart() {
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToWishlist("$30.50")
                .addToCart("$28.98")
                .proceedToCheckout()
                .changeQuantity(1, "100");
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
                .addToWishlist("$30.50")
                .addToCart("$28.98")
                .proceedToCheckout();
        cartPage
                .isPageOpened()
                .changeQuantity(1, "50")
                .validateCheckoutAndConfirm();
    }
}
