package PageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.ActionUtilities;

public class LoginPage {
	
	private static Logger logger = LogManager.getLogger(LoginPage.class);
	public  WebDriver driver;
	ActionUtilities actUtil;

	
	By emailTxtby = By.xpath("//input[@class='email']");
	By passwordTxtby = By.xpath("//input[@class='password']");
	By loginBtnby = By.xpath("//button[text()='Log in']");
	
//	@FindBy(xpath = "//input[@class='email']")
//	WebElement emailTxt;
//	
//	@FindBy(xpath = "//input[@class='password']")
//	WebElement passwordTxt;
//	
//	@FindBy(xpath = "//button[text()='Log in']")
//	WebElement loginBtn;
	
	
	
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        actUtil  = new ActionUtilities(driver);
    }
	
	
	public void setEmail(String email)
	{
		//emailTxt.sendKeys(email);
		actUtil.setText(emailTxtby, email);
		
	}
	
	
	public void setPassword(String password)
	{
		//passwordTxt.sendKeys(password);
		actUtil.setText(passwordTxtby, password);
	}
	
	public void clickLogin()
	{
		//loginBtn.click();
		actUtil.click(loginBtnby);
		
	}
	
	
	
	

}
