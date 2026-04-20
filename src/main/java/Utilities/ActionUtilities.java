package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtilities {
	
	public   WebDriver driver;
	public  WebDriverWait wait ;

	public ActionUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	}
	
	
	public   void setText(By locator , String txt)
	{
		WebElement element = waitForElementVisible(locator);
		highlightElement(element);
		element.clear();
		element.sendKeys(txt);
	}
	
	
	public void click(By locator) {
		// TODO Auto-generated method stub
		
		WebElement element = waitForElementClickable(locator);
		highlightElement(element);
		element.click();
		
	}
	
	public   String getText(By locator)
	{
		WebElement element = waitForElementVisible(locator);
		highlightElement(element);
		return element.getText();
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
