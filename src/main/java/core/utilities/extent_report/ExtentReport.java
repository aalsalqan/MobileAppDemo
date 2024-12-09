package core.utilities.extent_report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ahmad AlObra
 */
public class ExtentReport {

    private ExtentReports extentReportsObject;
    private ExtentTest extentTestObject;

    public void setExtent() {
        extentReportsObject = new ExtentReports("target/test_results/Test_Report_"+new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) +".html", true);
    }

    public void fillReport(ITestResult result, WebDriver driver) {
        extentTestObject = extentReportsObject.startTest(result.getInstanceName().substring(result.getInstanceName().lastIndexOf(".") + 1));
        if (ITestResult.FAILURE == result.getStatus()) {
            extentTestObject.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //to add name in extent report
            extentTestObject.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); //to add error/exception in extent report
            extentTestObject.log(LogStatus.FAIL, extentTestObject.addScreenCapture("./screenshots/" + Screenshots.takeScreenshot(driver))); //to add screenshot in extent report
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTestObject.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTestObject.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
        }
        extentReportsObject.endTest(extentTestObject);
    }

    public void endReport() {
        extentReportsObject.flush();
        extentReportsObject.close();
    }
}
