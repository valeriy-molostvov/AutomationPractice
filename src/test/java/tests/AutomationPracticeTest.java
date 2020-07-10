package tests;

import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class AutomationPracticeTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registration() {
        loginPage
                .openPage()
                .openRegistrationPage("helel@mailinator.com")
                .fillRegistrationForm("Ms.","Hell","Yeah","11111",
                        20,3,"1996","Hello kitty street, 19","Miami",
                        "Florida","12345","United States",
                        "Hate women clothes","99129045","Miami Beach")
                .submitRegistration();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void login() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com", "12345");
    }
//test doesn't work
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCart() {
        inventoryPage
                .openPage()
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("Blouse");
    }
//test doesn't work
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void buyingProductTest() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com", "12345");
        inventoryPage
                .listViewOfProducts()
                .initializeAllProducts()
                .addToCart("")
                .proceedToCheckout();
        cartPage
                .isPageOpened()
                .proceedToCheckout()
                .isPageOpened()
                .validateCheckoutAndConfirm();
    }
}
