package FrameworkBuildTestNGTest.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FrameworkBuildTestNGTest.data.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
    public void onTestStart(ITestResult result) {
        // Called when a test starts
	  System.out.println("Currently in method name = "+result.getMethod().getMethodName());
	  test = extent.createTest(result.getMethod().getMethodName());
	  extentTest.set(test); // unique thread id -> test object
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Called when a test passes
    	extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Called when a test fails
    	extentTest.get().fail(result.getThrowable());
    	
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String filepath = null;
		try {
			filepath = getScreenshotFilepath(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Called when a test is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Called when a test fails but is within success percentage
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Called when a test fails due to timeout
    }

    @Override
    public void onStart(ITestContext context) {
        // Called before any test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Called after all tests finish
    	extent.flush();
    }
    
	
}
