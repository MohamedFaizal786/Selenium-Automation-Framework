package Utilities;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {
	
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static void setTest(ExtentTest extenttest)
	{
		test.set(extenttest);
	}
	
	public static ExtentTest getTest()
	{
		return test.get();
		
	}
	
	public static void setInfo(String msg)
	{
		getTest().info(msg);
	}
	
	 public static void pass(String msg) {
	        getTest().pass(msg);
	    }

	  public static void fail(String msg) {
	        getTest().fail(msg);
	  }

}
