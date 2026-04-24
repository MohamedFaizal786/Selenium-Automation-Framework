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

	@Test(dataProvider = "validLoginData" , dataProviderClass  = DataProviderClass.class)
	public void verifyValidLogin(String TestCaseId , String username , String password) throws InterruptedException, IOException
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

	@Test(dataProvider = "invalidLoginData" , dataProviderClass  = DataProviderClass.class)
	public void verifyInvalidLoginTest(String TestCaseId , String username , String password) throws InterruptedException
	{
		logger.info("Test started : " + TestCaseId );
		HomePage homepage = new HomePage(DriverManager.getDriver() ,actUtil);
		LoginPage loginpage = new LoginPage(DriverManager.getDriver() , actUtil);
		Thread.sleep(5000);
		homepage.clickLoginBtn();
		logger.info("Clicked on Login button");
		
		Thread.sleep(15000);
		loginpage.login(username, password);
		if(loginpage.verifyErrorMsg("Login was unsuccessful. Please correct the errors and try again."))
		{
			logger.info("Account is not logged for the username : " + username + " and password : " + password);
			ExtentLogger.pass("Account is not logged for the username : " + username + " and password : " + password );
		}
		
		else
		{
			logger.error("Invalid Login test failed for the username : " + username + " and password : " + password);
			ExtentLogger.fail("Invalid Login test failed for the username : " + username + " and password : " + password);
			Assert.fail();
		}
		
		
	}
}
