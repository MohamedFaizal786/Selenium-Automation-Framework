package BaseTest;


import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.ActionUtilities;


public class BaseClass {
	

	

	public ActionUtilities actUtil ;
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	
	@BeforeMethod
	public void setup() throws IOException

	{	
		ConfigReader.loadConfig();
		DriverManager.initDriver();
		createActionDriverObject();
		launchUrl();
	}
	
	public  ActionUtilities createActionDriverObject()
	{
		
			this.actUtil = new ActionUtilities(DriverManager.getDriver());
			return actUtil;
	}
	
	
	
	
	public  void launchUrl()
	{
		try {
			logger.info("launching the  Application");
			DriverManager.getDriver().get(ConfigReader.getproperty("url"));
			//System.out.println("Application url launced successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Unable to launch the application");
			throw new RuntimeException("url is not initialized");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{	
		logger.info("Closing the webdriver");
		DriverManager.quitDriver();
		
	}
	


}
