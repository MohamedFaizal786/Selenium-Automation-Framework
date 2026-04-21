package Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import DataProviders.DataProviderClass;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;

public class RegisterTest extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(RegisterTest.class);
	String actualMsg = "Your registration completed";
	
	@Test(dataProvider = "RegistrationData" , dataProviderClass = DataProviderClass.class)
	public void verifyRegistration(String gender , String fisrtName , String lastName , String email , String company , String password) throws InterruptedException
	{
		//System.out.println("Logged in successfullly");
		HomePage homepage = new HomePage(driver);
		Thread.sleep(5000);
		homepage.clickRegBtn();
		Thread.sleep(5000);
		RegistrationPage registerationpage = new RegistrationPage(driver);
		logger.info("Entering the user details");
		registerationpage.setRegistrationDetails(gender, fisrtName, lastName, email, company, password);
		logger.info("Clicking register");
		registerationpage.clickRegister();
		
		String expectedMsg = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
		
		logger.info("Validating the registeration message");
		if(expectedMsg.equals(actualMsg))
		{
			logger.info("Account registered successfull with : " + email + " and " + password );
			
		}
		
		else
		{
			logger.info("Account registered unsuccessfull with : " + email + " and " + password );
			Assert.fail();
		}
		
		
				
		
	}


}
