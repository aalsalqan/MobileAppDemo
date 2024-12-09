package tests;
import core.common.BaseTest;
import core.utilities.errorhandlers.RetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.SwipePage;

import java.net.MalformedURLException;


public class FormsTest extends BaseTest {
    FormsPage formsPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {

        /** initilize the driver mobile & connect to appium server with defining capabilities for start testing */
        setUp();
        formsPage = new FormsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test(description = "fill the forms page fields")
    public void fillFormsPage() throws Exception {
        // Forms
        /** filling the form inputs & verify the text  */

        formsPage.FillFormsPage("Aseel");
        tearDown();
    }
}
