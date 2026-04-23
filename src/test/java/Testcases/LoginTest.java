package Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseTest.BaseClass;
import BaseTest.DriverManager;
import DataProviders.DataProviderClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.ExtentLogger;
import Utilities.ScreenshotsUtilities;

public class LoginTest extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(LoginTest.class);

	@Test(dataProvider = "loginData" , dataProviderClass  = DataProviderClass.class)
	public void verifyLogin(String TestCaseId , String username , String password) throws InterruptedException, IOException
	{
		
		
		logger.info("Test started : " + TestCaseId );
		HomePage homepage = new HomePage(DriverManager.getDriver() ,actUtil);
		LoginPage loginpage = new LoginPage(DriverManager.getDriver() , actUtil);
		Thread.sleep(5000);
		homepage.clickLoginBtn();
		logger.info("Clicked on Login button");
		
		Thread.sleep(15000);
		loginpage.login(username, password);
		if (homepage.isAccountLoggedIn("Log out",homepage.getlogoutText() ))
		{	
			logger.info("Logged in successful for " + username + " and " + password);
			ExtentLogger.pass("Logged in successful for " + username + " and " + password);
		
		
		}
		
		else
		{	
			logger.error("login unsuccessfull with " + username + " and " + password);
			ExtentLogger.fail("Logged in unsuccessful for " + username + " and " + password);
			Assert.fail();
			
		
		}
		
		
		
		
		
		
	
		
		
	}

}
