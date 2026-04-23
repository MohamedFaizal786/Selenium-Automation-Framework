package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.ActionUtilities;

public class ProductDetailsPage {

		public WebDriver driver;
		public ActionUtilities actUtil;
		
		By productTitleby = By.xpath("//div[@class='product-name']/h1");
		By productDescby = By.xpath("//div[@class='short-description']");
		By productpriceby = By.xpath("//div[@class='prices']/div[@class='product-price']/span");
		By addToCartby = By.xpath("//button[text()='Add to cart']");
		By productAddedMsgby = By.xpath("//div[@class='bar-notification success']/p[@class='content']");
		By shoppingCartby = By.xpath("//a[@class='ico-cart']");
	
	public ProductDetailsPage(WebDriver driver , ActionUtilities actUtil )
	{
		this.driver = driver;
		this.actUtil = actUtil;
		
	}
	
	
//	public void getProductDetails()
//	{
//		String prodDesc = actUtil.getText(productDescby);
//		String prodPrice = actUtil.getText(productpriceby);
//		String productTitle = actUtil.getText(productTitleby);
//		
//		
//	}
	
	
	
	public void clickAddToCartBtn()
	{
		actUtil.click(addToCartby);
	}
	
	public String productAddedMsg()
	{
		
		return actUtil.getText(productAddedMsgby);
		
	}
	
	public void clickCart()
	{
		actUtil.click(shoppingCartby);
	}
	
	
}
