package Utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import BaseTest.BaseClass;


public class ActionUtilities {
	
	private static Logger logger = LogManager.getLogger(ActionUtilities.class);
	public   WebDriver driver;
	public  WebDriverWait wait ;
	

	public ActionUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		
			}
	
	
	public   void setText(By locator , String txt)
	{
		try {
			WebElement element = waitForElementVisible(locator);
			highlightElement(element);
			element.clear();
			element.sendKeys(txt);
			ExtentLogger.setInfo("Setting the text:" +txt  );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void click(By locator) {
		// TODO Auto-generated method stub
		
		try {
			WebElement element = waitForElementClickable(locator);
			highlightElement(element);
			element.click();
			ExtentLogger.setInfo("Clicked and Element : " + locator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public   String getText(By locator)
	{
		try {
			WebElement element = waitForElementVisible(locator);
			highlightElement(element);
			ExtentLogger.setInfo("Captured the text : "+  element.getText());
			return element.getText();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
	
	
	
	
	
	private WebElement waitForElementVisible(By locator)
	{
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private WebElement waitForElementClickable(By locator)
	{
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


	
	
	
	
	
	
	
	
	
	

}
