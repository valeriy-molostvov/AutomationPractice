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
}
