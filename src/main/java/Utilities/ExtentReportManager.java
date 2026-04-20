package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	
	
	



	public static ExtentReports getExtentReportObject() {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH_mm-ss").format(new Date());
		String reportPath = System.getProperty("user.dir")+ "/Report/"  +"Report_" + timeStamp + ".html";
		reporter = new ExtentSparkReporter(reportPath);
		
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Execution Report ");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		
		extent.setSystemInfo("Tester", "Mohamed Faizal A");
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Application", "Chrome");
		
		
		return extent;
		

	}
	
	
	
}
