package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BaseTest.BaseClass;
import Utilities.ActionUtilities;

public class CartPage {
	
	public static Logger logger = LogManager.getLogger(CartPage.class);
	public  WebDriver driver;
	ActionUtilities actUtil;
	
	By addedProductNameby = By.xpath("//table[@class='cart']//td[3]");
	
	
	
	
	
	
	

	
	public CartPage(WebDriver driver, ActionUtilities actUtil) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	       
        this.actUtil = actUtil;
	}
	
	public boolean verifyProductAdded()
	{
		 if(actUtil.getText(addedProductNameby).contains("Apple iPhone 16 128GB"))
			 {
			  return true;
			 }
		 
		 else
		 {
			 return false;
		 }
	}
	
	

}
