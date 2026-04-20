package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseTest.BaseClass;
import DataProviders.DataProviderClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.ScreenshotsUtilities;

public class LoginTest extends BaseClass {
	
	
	
	@Test(dataProvider = "loginData" , dataProviderClass  = DataProviderClass.class)
	public void verifyLogin(String TestCaseId , String username , String password) throws InterruptedException, IOException
	{
		
		
		ExtentTest test = BaseClass.extent.createTest(TestCaseId);
		logger.info("Test started : " + TestCaseId );
		HomePage homepage = new HomePage(driver);
		Thread.sleep(5000);
		homepage.clickLoginBtn();
		logger.info("Clicked on Login button");
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(10000);
		loginpage.setEmail(username);
		logger.info("Entered Email");
		loginpage.setPassword(password);
		loginpage.clickLogin();
		logger.info("Clicked on Login button");
		if (homepage.getlogoutText().equals("Log out"))
		{	
			logger.info("Logged in successful for " + username + " and " + password);
			test.pass("Logged in successfully with " + username + " and " + password );
	
			//homepage.clickLogoutnBtn();
			
		
		}
		
		else
		{	
			logger.error("login unsuccessfull with " + username + " and " + password);
			//System.out.println("Login unsuccessfull");
			String path = ScreenshotsUtilities.getScreenshot(driver, this.getClass().getName());
			test.fail("Login unsuccessful   with " + username + " and " + password);
			test.addScreenCaptureFromPath(path);
			
		
		}
		
		
		
		
		
		
	
		
		
	}

}
