package FrameworkBuildTestNGTest.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFlakyTest implements IRetryAnalyzer {

	int count = 0;
	int maxRetry = 1;
	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		if(count<maxRetry)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
