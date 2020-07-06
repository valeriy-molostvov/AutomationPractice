package tests;

import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class AutomationPracticeTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registration() {
        loginPage
                .openPage()
                .openRegistrationPage("helel@mailinator.com")
                .fillRegistrationForm("Ms.","Hell", "Yeah","11111",
                        20, 3, "1996", "Hello kitty street, 19",
                        "Miami","Florida", "12345", "United States",
                        "Hate women clothes", "99129045", "Miami Beach")
                .submitRegistration();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void login() {
        loginPage
                .openPage()
                .loggingToAccount("moodpanda@mailinator.com","12345");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCart() {
     inventoryPage
             .openPage()
             .addToCart_1()
             .addToCart_2()
             .addToCart_3()
             .addToCart_4()
             .addToCart_5()
             .addToCart_6()
             .addToCart_7()
             .proceedToCheckout()
             .openPage()
             .deleteFromCart(2,5,4, "100", 1);
    }
}
