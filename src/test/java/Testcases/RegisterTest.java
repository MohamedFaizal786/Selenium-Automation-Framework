package Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.DriverManager;
import DataProviders.DataProviderClass;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import Utilities.ExtentLogger;

public class RegisterTest extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(RegisterTest.class);
	String actualMsg = "Your registration completed";
	
	@Test(dataProvider = "RegistrationData" , dataProviderClass = DataProviderClass.class)
	public void verifyRegistration(String gender , String fisrtName , String lastName , String email , String company , String password) throws InterruptedException
	{
		//System.out.println("Logged in successfullly");
		HomePage homepage = new HomePage(DriverManager.getDriver(), actUtil);
		Thread.sleep(5000);
		homepage.clickRegBtn();
		Thread.sleep(5000);
		RegistrationPage registerationpage = new RegistrationPage(DriverManager.getDriver()  , actUtil);
		registerationpage.setRegistrationDetails(gender, fisrtName, lastName, email, company, password);
		registerationpage.clickRegister();
		
		String expectedMsg = DriverManager.getDriver().findElement(By.xpath("//div[text()='Your registration completed']")).getText();
		
		logger.info("Validating the registeration message");
		if(homepage.isAccountRegistered(expectedMsg, homepage.getRegisteredMsgText()))
		{
			logger.info("Account registered successfully with : " + email + " and " + password );
			ExtentLogger.pass("Account registered successfully with : " + email + " and " + password );
		}
		
		else
		{
			logger.info("Account registration unsuccessfull with : " + email + " and " + password );
			ExtentLogger.fail("Account registration  unsuccessfull with : " + email + " and " + password );

			Assert.fail();
		}
		
		
				
		
	}


}
