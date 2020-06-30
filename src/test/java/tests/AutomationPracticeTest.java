package tests;

import org.testng.annotations.Test;

public class AutomationPracticeTest extends BaseTest{
    @Test
    public void login() {
        loginPage
                .openPage();
    }
}
