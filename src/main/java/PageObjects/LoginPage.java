package PageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.ActionUtilities;

public class LoginPage {
	
	public static Logger logger = LogManager.getLogger(LoginPage.class);
	public  WebDriver driver;
	ActionUtilities actUtil;

	
	By emailTxtby = By.xpath("//input[@class='email']");
	By passwordTxtby = By.xpath("//input[@class='password']");
	By loginBtnby = By.xpath("//button[text()='Log in']");
	By erroMsgby = By.xpath("//div[contains(@class , 'message-error validation')]");
	
//	@FindBy(xpath = "//input[@class='email']")
//	WebElement emailTxt;
//	
//	@FindBy(xpath = "//input[@class='password']")
//	WebElement passwordTxt;
//	
//	@FindBy(xpath = "//button[text()='Log in']")
//	WebElement loginBtn;
	
	
	
	
	public LoginPage(WebDriver driver , ActionUtilities actUtil ) {
        this.driver = driver;
        this.actUtil  = actUtil;
    }
	
	public void login(String email , String password)
	{
		actUtil.setText(emailTxtby, email);
		actUtil.setText(passwordTxtby, password);
		actUtil.click(loginBtnby);
	}
	
	
	public boolean verifyErrorMsg(String expectedMsg)
	{
		if (actUtil.getText(erroMsgby).contains (expectedMsg))
		{	
			
			return true;
		}
		else
		{
			return false;
		}
		
				
	}
	
	
	

	
	
	
	

}
