package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.ActionUtilities;

public class HomePage {
	
	public static Logger logger = LogManager.getLogger(HomePage.class);
	public  WebDriver driver;
	ActionUtilities actUtil;
	
	By registbtnby = By.linkText("Register");
	By loginbtnby = By.linkText("Log in");
	By logoutbtnby = By.xpath("//div[@class='header-links']/ul/li[2]/a");
	By regMsgby = By.xpath("//div[text()='Your registration completed']");
	
	
	
	
	
	
	

	
	public HomePage(WebDriver driver, ActionUtilities actUtil) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	       
        this.actUtil = actUtil;
	}
	



	public void clickLoginBtn()
	{
		
		
		actUtil.click(loginbtnby);
		
		
	}


	public void clickRegBtn() {
		// TODO Auto-generated method stub
		
		actUtil.click(registbtnby);
		
	}
	
	



	public String getlogoutText() {
		// TODO Auto-generated method stub
		return actUtil.getText(logoutbtnby);
	}
	
	public String getRegisteredMsgText() {
		// TODO Auto-generated method stub
		return actUtil.getText(regMsgby);
		
	}
	
	public void clickLogoutnBtn()
	{
		actUtil.click(logoutbtnby);
	}
	
	
	
	public boolean isAccountLoggedIn(String actual ,String expected ) {
		return actUtil.compareText(actual, expected);
		
	}
	
	public boolean isAccountRegistered(String actual ,String expected ) {
		return actUtil.compareText(actual, expected);
		
	}




	
	
	


	

}
