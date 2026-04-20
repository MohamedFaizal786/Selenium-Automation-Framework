package Testcases;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObjects.HomePage;

public class RegisterTest extends BaseClass {
	
	@Test
	public void verifyLogin() throws InterruptedException
	{
		System.out.println("Logged in successfullly");
		HomePage homepage = new HomePage(driver);
		homepage.clickRegBtn();
	}


}
