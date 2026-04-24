package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BaseTest.BaseClass;
import Utilities.ActionUtilities;

public class RegistrationPage {
	
	public static Logger logger = LogManager.getLogger(RegistrationPage.class);
	
	public WebDriver driver;
	public ActionUtilities actUtil;
	
	
	By maleGenderby = By.xpath("//input[@id ='gender-male']");
	By femaleGenderby = By.xpath("//input[@id ='gender-female']");
	By firstNameby = By.xpath("//input[@name = 'FirstName']");
	By lastNameby = By.xpath("//input[@name = 'LastName']");
	By emailby = By.xpath("//input[@name = 'Email']");
	By companyby = By.xpath("//input[@id = 'Company']");
	By pwdby = By.xpath("//input[@id = 'Password']");
	By cnfPwdby = By.xpath("//input[@id = 'ConfirmPassword']");
	By regBtnby = By.xpath("//button[text() = 'Register']");
	
	
	public RegistrationPage(WebDriver driver , ActionUtilities actUtil)
	{
		this.driver = driver;
	       
        this.actUtil  = actUtil ;
	}
	
	
	
	
	
	public void setRegistrationDetails(String gender , String fname , String lname , String email , String company , String pwd)
	{	
		if(gender.equals("Male"))
		{
			actUtil.click(maleGenderby);
		}
		else
		{
			actUtil.click(femaleGenderby);
		}
		actUtil.setText(firstNameby, fname);
		actUtil.setText(lastNameby, lname);
		actUtil.setText(emailby, email);
		actUtil.setText(companyby, company);
		actUtil.setText(pwdby, pwd);
		actUtil.setText(cnfPwdby, pwd);
		
	}
	
	
	
	public void clickRegister()
	{
		actUtil.click(regBtnby);
	}
	
	
	
	
	
	

}
