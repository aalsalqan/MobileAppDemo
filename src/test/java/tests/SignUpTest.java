package tests;

import core.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SignupPage;

import java.net.MalformedURLException;
import java.util.Random;

public class SignUpTest extends BaseTest {

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

    @Test(description = "fill sign up form")
    public void SignUp() throws Exception {

        /** click on login widget from below tool bar*/
        loginPage.clickOnLoginWidgetFromBar();
        signupPage.goToSignupTab();

        /** Make random Email address creation so that each time user can select password & email differnt than the other */
        String email = SignupPage.generateRandomEmailAddress();
        Random random= new Random();
        String password = "password@" + random.nextInt(100); ;

        /** Make sign up with using the email & password that have been generated before in previous step */
        signupPage.fillSignupForm(email, password);

        /** verify the fillSignupForm successfull messages from popup getting correctly  */
        softAssert.assertTrue(signupPage.verifySignupMessage());
        softAssert.assertTrue(signupPage.verifySignupSuccessMessage());
        signupPage.clickOkButton();

        softAssert.assertAll();
        tearDown();
    }
}
