package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ActionUtilities;

public class HomePage {
	
	
	public  WebDriver driver;
	ActionUtilities actUtil;
	
	By registbtnby = By.linkText("Register");
	By loginbtnby = By.linkText("Log in");
	By logoutbtnby = By.xpath("//div[@class='header-links']/ul/li[2]/a");
	
	
	
	
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
       
        actUtil = new ActionUtilities(driver);
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
	
	public void clickLogoutnBtn()
	{
		actUtil.click(logoutbtnby);
	}



	

}
