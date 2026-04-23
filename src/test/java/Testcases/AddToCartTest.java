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
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductDetailsPage;
import PageObjects.ProductSelectionPage;
import Utilities.ExtentLogger;
import Utilities.ScreenshotsUtilities;
public class AddToCartTest extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(LoginTest.class);
	
	
	@Test
	public void VerifyAddToCart() throws InterruptedException
	{
		ProductSelectionPage productselectionpage = new ProductSelectionPage(DriverManager.getDriver(),actUtil);
		ProductDetailsPage productdetailspage = new ProductDetailsPage(DriverManager.getDriver(),actUtil);
		CartPage cartpage = new CartPage(DriverManager.getDriver(),actUtil);
		Thread.sleep(15000);
		productselectionpage.selectProduct("Apple iPhone 16 128GB");
		productdetailspage.clickAddToCartBtn();
		productdetailspage.clickCart();
		if(cartpage.verifyProductAdded()==true)
		{
			logger.info("Product has been added successfully");
			ExtentLogger.pass("Product has been added successfully" );
		}
		
		else
		{
			logger.error("Product has not been added successfully");
			ExtentLogger.fail("Product has not been added successfully" );
		}
		
		
		
	}

}
