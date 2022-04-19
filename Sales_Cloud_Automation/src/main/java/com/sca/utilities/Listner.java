package com.sca.utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sca.commosActions.TestBase;
import com.sca.reports.ExtentReportNG;

public class Listner implements ITestListener {

	ExtentReportNG report=new ExtentReportNG();
	
	public void onTestSuccess(ITestResult result) {
		String name=result.getTestContext().getClass().getName();
	}
	
	/*public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	try {
		TestBase.takeScreenshotAtEndOfTest(methodName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/
}
