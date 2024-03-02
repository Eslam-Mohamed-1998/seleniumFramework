package UtilitiesORHelpers;

import org.testng.ITestResult;

public class CheckTheStatusCode {
	public ITestResult checkStatusCode (ITestResult result ) 
	{
		if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test Passed!");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed!");
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("Test Skipped!");
        }
		return result;
	}
}
