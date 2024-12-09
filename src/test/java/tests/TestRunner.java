package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.LoginPage;
import pages.SignupPage;
import pages.SwipePage;

import java.util.Random;

public class TestRunner extends core.common.BaseTest {

    //note that this class is for all scenarios runing in same test class ( it can be seperated as sub classes we made & it can be written as this class below )
    @Test
    public void testScenario() throws Exception {
        setUp();
        // Pages
        LoginPage loginPage = new LoginPage(driver);
        SignupPage signupPage = new SignupPage(driver);
        FormsPage formsPage = new FormsPage(driver);
        SwipePage swipePage = new SwipePage(driver);

        loginPage.clickOnLoginWidgetFromBar();
        signupPage.goToSignupTab();
        String email = SignupPage.generateRandomEmailAddress();

        Random random= new Random();
        String password = "password@" + random.nextInt(100); ;

        signupPage.fillSignupForm(email, password);
        Assert.assertTrue(signupPage.verifySignupMessage());
        Assert.assertTrue(signupPage.verifySignupSuccessMessage());
        signupPage.clickOkButton();

        loginPage.clickOnLoginTab();
        loginPage.login(email, password);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.verifyDisplayingSuccessMessageText());
        Assert.assertTrue(loginPage.isLoginSuccessful());
        signupPage.clickOkButton();

        // Forms
        formsPage.FillFormsPage("Aseel");

        // Swipe
        swipePage.goToSwipeScreen();
        swipePage.swipeUntilSupportVideosCardDisplay();
        driver.quit();
        tearDown();
    }
}
