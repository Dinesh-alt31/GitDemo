package FrameworkBuildTestNGTest.data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import FrameworkBuildTestNGTest.TestComponents.BaseTest;

public class ExtentReportNG extends BaseTest{
	

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reportForFrameWork\\extentReportIndex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation tests");
		reporter.config().setDocumentTitle("Test title");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//if(headlessFlag. )
		extent.setSystemInfo("Tester", "Rahul shetty");
		return extent;
	}

}
