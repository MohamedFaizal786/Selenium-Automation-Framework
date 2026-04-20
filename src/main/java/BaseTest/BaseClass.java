package BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.ExtentReportManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	
	
//	@BeforeSuite
//	public void setupReport()
//	{
//		extent = ExtentReportManager.getExtentReportObject();
//	}

	
	@BeforeMethod
	public void setup()
	{
		BaseClass.configReader();
		BaseClass.invokeDriver();
		BaseClass.launchUrl();
	}
	
	
	public static void invokeDriver()
	{
		try {
			
			logger.info("Initiating Webdriver");
			ChromeOptions options = new ChromeOptions();

	        // IMPORTANT: avoid headless
	        // options.addArguments("--headless");  ❌ don't use

	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.setExperimentalOption("useAutomationExtension", false);
			
			driver = new ChromeDriver(options);
	
			
			driver.manage().window().maximize();

		    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		} catch (Exception e) {
			logger.info("Unable to load the webdriver");
			// TODO Auto-generated catch block
			throw new RuntimeException("Driver is not initialized");
		}
			
	}
	
	
	public static void configReader() {
        try {
        	logger.info("Configuring the properties file");
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties"
            );
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
        	logger.error("Unable to load the config file");
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }
	
	
	
	public static void launchUrl()
	{
		try {
			logger.info("launching the  Application");
			driver.get(prop.getProperty("url"));
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
		driver.quit();
	}
	
//	@AfterSuite
//	public void closeReport()
//	{
//		extent.flush();
//		
//	}

}
