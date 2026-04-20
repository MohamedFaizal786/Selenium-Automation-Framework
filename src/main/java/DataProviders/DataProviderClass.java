package DataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.ExcelUtilities;

public class DataProviderClass {
	
	@DataProvider(name ="loginData")
	public Object[][] returnDataFromExcel() throws IOException 
	{
		return ExcelUtilities.getData("LoginTest");
	}

}
