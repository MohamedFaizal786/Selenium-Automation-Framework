package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtilities {
	
	public static TakesScreenshot ts;
	public static File src;
	public static String snapShotPath;
	public static File des;
	
	
	public static String  getScreenshot(WebDriver driver , String testName ) throws IOException
	{
		
		String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH_mm-ss").format(new Date());
		snapShotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + "_"+ timeStamp+".png";
		ts = (TakesScreenshot) driver;
		des = new File(snapShotPath);
		src = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, des);
		return snapShotPath;
		
	}

}
