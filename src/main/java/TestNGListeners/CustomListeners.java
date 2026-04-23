package TestNGListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseTest.BaseClass;
import BaseTest.DriverManager;
import Utilities.ExtentLogger;
import Utilities.ExtentReportManager;
import Utilities.ScreenshotsUtilities;

public class CustomListeners implements ITestListener {
	
	ExtentReports extent = ExtentReportManager.getExtentReportObject();

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("Test case started" +  result.getMethod().getMethodName());
		
		ExtentTest test  = extent.createTest(result.getName());
		ExtentLogger.setTest(test);
		
		ExtentLogger.setInfo("Test Case stated : "+ result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		ExtentLogger.pass("Test case passed :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.fail("Test case failed :" + result.getName());
		try {
			String snapshotPath = ScreenshotsUtilities.getScreenshot(DriverManager.getDriver(), result.getName());
			ExtentLogger.getTest().addScreenCaptureFromPath(snapshotPath);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case skipped" + result.getMethod().getMethodName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Execution started" );
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		System.out.println("Test Execution Completed");
	}

}
