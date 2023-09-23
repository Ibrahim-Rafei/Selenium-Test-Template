package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reuseable.ExtentReporterNG;

import java.io.IOException;

public class Listeners  extends BaseTest implements ITestListener {

    WebDriver driver ;
    ExtentTest test ;
    ExtentReports extentReports = new ExtentReporterNG().getReporterObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe

    @Override
    public void onTestStart(ITestResult result) {

        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS , "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        String testName = result.getName(); // Get the test method name
        int retryCount = result.getTestContext().getFailedTests().getResults(result.getMethod()).size() ;
        String retryName = testName + "_Retry" + retryCount; // Create a special name for each retry


        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String filePath = getScreenshot(retryName , driver);
            extentTest.get().addScreenCaptureFromPath(filePath,retryName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if(result.getStatus() == ITestResult.SKIP) {
            if (result.wasRetried())
                extentReports.removeTest(extentTest.get());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }




    // Other methods like onTestSkipped, onTestFailedButWithinSuccessPercentage, etc.


}
