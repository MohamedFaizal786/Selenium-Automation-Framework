package Utilities;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import BaseTest.BaseClass;
import BaseTest.ConfigReader;


public class ActionUtilities {
	
	private static Logger logger = LogManager.getLogger(ActionUtilities.class);
	public   WebDriver driver;
	public  WebDriverWait wait ;
	public int  explicitTime = Integer.parseInt(ConfigReader.getproperty("explicitwait"));
	

	public ActionUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(explicitTime));
		
			}
	
	
	public   void setText(By locator , String txt)
	{
		try {
			WebElement element = waitForElementVisible(locator);
			highlightElement(element);
			element.clear();
			element.sendKeys(txt);
			logger.info("Text value entered : " + txt);
			ExtentLogger.pass("Text value entered:" +txt  );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to enter the text value  : " + txt);
			ExtentLogger.fail("Text value entered:" +txt  );
			 throw new RuntimeException("SetText failed for: " + locator, e);
		}
	}
	
	
	public void click(By locator) {
		// TODO Auto-generated method stub
		
		try {
			WebElement element = waitForElementClickable(locator);
			highlightElement(element);
			element.click();
			logger.info("Clicked an  Element : " + locator);
			ExtentLogger.pass("Clicked an  Element : " + locator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Unable to click an  Element : " + locator);
			ExtentLogger.fail("Unable to click an  Element : " + locator);
			 throw new RuntimeException("Click failed for: " + locator, e);
		}
		
	}
	
	public   String getText(By locator)
	{
		try {
			WebElement element = waitForElementVisible(locator);
			highlightElement(element);
			String capturedTxt = element.getText();
			logger.info("Text value Captured : " + capturedTxt );
			ExtentLogger.pass(" Text value captured : "+ capturedTxt);
			return capturedTxt;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to capture the txt value for the locator : " + locator );
			ExtentLogger.fail("Unable to capture the txt value for the locator : " + locator );
			throw new RuntimeException("GetText failed for: " + locator, e);
		}
		
	}
	
	
	public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
	
	public void selectElementfromList(By locator , String expectedElement)
	{
		try {
			List <WebElement> elements = waitForElements(locator);
			for(WebElement element : elements )
			{
				if(element.getText().contains(expectedElement))
				{	
					
					element.click();
					logger.info("Clicked an Element from the list : " + element);
					ExtentLogger.pass("Clicked an Element from the list : "+ element);
					break;
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Unable to select the element from the list : " + expectedElement);
		}
		
	
	}
	
	
	public boolean compareText(String actual , String expected)
	{
		try {
			logger.info("Comparing the text value of : " + expected + " with " + actual);
			ExtentLogger.setInfo("Comparing the text value of : " + expected + " with " + actual);
			if(actual.equalsIgnoreCase(expected))
			{
				logger.info("Expected value matches with the actual value");
				ExtentLogger.pass("Expected value matches with the actual value");
				return true;
			}
			
			else
			{
				logger.info("Expected value matches with the actual value");

				ExtentLogger.fail("Expected value does not matches with the actual value");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to compare the expected value with the actual value");

			ExtentLogger.fail("Unable to compare the expected value with the actual value");
			 throw new RuntimeException("Comparison failed : ", e);
		}
		
	}
	
	
	private WebElement waitForElementVisible(By locator)
	{
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private WebElement waitForElementClickable(By locator)
	{
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public List<WebElement> waitForElements(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	




	
	
	
	
	
	
	
	
	
	

}
