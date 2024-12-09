package tests;

import core.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SignupPage;

import java.net.MalformedURLException;
import java.util.Random;

public class LoginTest extends BaseTest {

    SoftAssert  softAssert;
    LoginPage loginPage;
    SignupPage signupPage;

    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {
        /** initilize the driver mobile & connect to appium server with defining capabilities for start testing */
        setUp();
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        softAssert = new SoftAssert();
    }



    @Test(description = "make login for existing username")
    public void loginUser() throws Exception {

        /** click on login widget from below tool bar*/
        loginPage.clickOnLoginWidgetFromBar();

        /** getting random email & password when sign up user*/
        String email = SignupPage.generateRandomEmailAddress();
        Random random= new Random();
        String password = "password@" + random.nextInt(100);

        /** this method made for the sign up steps */
        signupPage.commonMethodForLoginPage(email,password);
        // click on login tab after sign up
        loginPage.clickOnLoginTab();
        loginPage.login(email, password);
        loginPage.clickOnLoginButton();

        /** verify the sign up messages text  */
        Assert.assertTrue(loginPage.verifyDisplayingSuccessMessageText());
        Assert.assertTrue(loginPage.isLoginSuccessful());

        /** close the sign up pop up message by clicking ok button   */
        signupPage.clickOkButton();

        tearDown();
    }
}
