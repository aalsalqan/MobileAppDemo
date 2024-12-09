package tests;
import core.common.BaseTest;

import core.utilities.errorhandlers.RetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SignupPage;
import pages.SwipePage;

import java.net.MalformedURLException;


public class SwipTest extends BaseTest {
    SoftAssert  softAssert;
    SwipePage  swipePage;
    BaseTest baseTest;

    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {

        /** initilize the driver mobile & connect to appium server with defining capabilities for start testing */
        setUp();
        swipePage = new SwipePage(driver);
        softAssert = new SoftAssert();
    }


    // this testNg unit for defining the things that you want ( retry is for the test scenario 2 times count in case its failed , you can remove it )
    // if there are more scenarios priority should be defined but if its one then no need for it

    @Test(description = "get the support video card by swapping cards until finds it",priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void selectSupportVideoCardBySwapping() throws Exception {

        /**click on the swip widget from below bar to begin teting*/
        swipePage.goToSwipeScreen();

        /** keep swiping until getting the specified card ( support video card)*/
        swipePage.swipeUntilSupportVideosCardDisplay();

        /** verify the support card text for the current card after swiping */
        softAssert.assertEquals(swipePage.getSupportVideoCardText().getAttribute("text"), "SUPPORT VIDEOS");

        //this for closing the driver
        tearDown();
    }





}
