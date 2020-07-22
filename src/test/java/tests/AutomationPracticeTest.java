package tests;

import models.Account;
import models.AccountCreation;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static utils.EmailData.*;

public class AutomationPracticeTest extends BaseTest {
    Account account = new Account("moodpanda@mailinator.com", "12345");
    AccountCreation accountCreation = new AccountCreation("Mr.", "Hell", "Yeah", "11111",
            20, 3, "1996", "Hello kitty street, 19", "Miami",
            "Florida", "12345", "United States", "Hate women clothes",
            "99129045", "Miami Beach");

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationTest() {
        String email = createEmail(10,true,true);
        loginPage
                .openPage()
                .openRegistrationPage(email)
                .fillRegistrationForm(accountCreation)
                .submitRegistration()
                .isPageOpened();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest() {
        loginPage
                .openPage()
                .loggingToAccount(account)
                .isPageOpened();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void logOutTest() {
        loginPage
                .openPage()
                .loggingToAccount(account)
                .isPageOpened();
        myAccountPage
                .logoutFromAccount()
                .isPageOpened();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCartTest() {
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("Printed Summer Dress $28.98")
                .verifyProductAddedToCart()
                .continueShopping()
                .addToCart("Faded Short Sleeve T-shirts $16.51")
                .verifyProductAddedToCart()
                .continueShopping()
                .addToCart("Printed Dress $26.00")
                .verifyProductAddedToCart()
                .proceedToCheckout()
                .initializeAllProductsInCart()
                .setQuantityValue("Printed Summer Dress $28.98", "10");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void buyingProductTest() {
        loginPage
                .openPage()
                .loggingToAccount(account)
                .isPageOpened();
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("Blouse $27.00")
                .verifyProductAddedToCart()
                .continueShopping()
                .addToCart("Faded Short Sleeve T-shirts $16.51")
                .verifyProductAddedToCart()
                .continueShopping()
                .addToCart("Printed Dress $26.00")
                .verifyProductAddedToCart()
                .proceedToCheckout();
        cartPage
                .isPageOpened()
                .initializeAllProductsInCart()
                .validateNumberOfProducts(3)
                .checkoutAndConfirm();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void wishlistTest() {
        loginPage
                .openPage()
                .loggingToAccount(account);
        myWishlistPage
                .openPage()
                .addNewWishlist("New WishList")
                .addNewWishlist("New president")
                .deleteWishlist("New president");
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToWishlist("Blouse $27.00")
                .addToWishlist("Printed Dress $50.99")
                .addToWishlist("Printed Summer Dress $28.98")
                .addToWishlist("Printed Chiffon Dress $16.40");
        myWishlistPage
                .openPage()
                .clickOnView("New WishList")
                .validateNumberOfProductsInTheView(4)
                .deleteWishlist("New WishList");
    }
}