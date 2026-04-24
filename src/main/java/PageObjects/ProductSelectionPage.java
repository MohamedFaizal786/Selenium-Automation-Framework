package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseTest.BaseClass;
import Utilities.ActionUtilities;

public class ProductSelectionPage {
	
	public static Logger logger = LogManager.getLogger(ProductSelectionPage.class);
	public WebDriver driver;
	public ActionUtilities actUtil;

	
//	By electronicsby = By.xpath("//a[text()='Electronics']");
//	By cellPhoneby = By.xpath("//div[@class='item-box']//a[text()=' Cell phones ']");
//	By phoneListby  = By.xpath("//div[@class='item-box']//h2[@class='product-title']/a");
	By searchBoxby = By.xpath("//input[@id='small-searchterms']");
	By searchListby = By.xpath("//div[@role='search']/ul/li[@class='ui-menu-item']/a/span");
	
	public ProductSelectionPage( WebDriver driver , ActionUtilities actUtil)
	{
		this.driver = driver;
		this.actUtil = actUtil;
		
	}
	
	
	public void selectProduct(String productName)
	{
		actUtil.setText(searchBoxby, productName);
		actUtil.selectElementfromList(searchListby, productName);
	}
	
	
	
	

}
