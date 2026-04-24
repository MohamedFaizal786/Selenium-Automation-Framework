package DataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

import Utilities.ActionUtilities;
import Utilities.ExcelUtilities;

public class DataProviderClass {
	
	@DataProvider(name ="validLoginData")
	public Object[][] returnValidLoginDataFromExcel() throws IOException 
	{
		return ExcelUtilities.getData("Valid LoginTest");
	}
	
	@DataProvider(name ="invalidLoginData")
	public Object[][] returnInvalidLoginDataFromExcel() throws IOException 
	{
		return ExcelUtilities.getData("Invalid LoginTest");
	}
	
	
	@DataProvider(name ="RegistrationData")
	public Object[][] returnRegistrationData()
	{
		Faker faker = new Faker();
		
		return new Object[][]
				{
					{getRandomGender(), faker.name().firstName() , faker.name().lastName() , faker.internet().emailAddress() , faker.company().name() , "Faizal@123"},
					{getRandomGender(), faker.name().firstName() , faker.name().lastName() , faker.internet().emailAddress() , faker.company().name() , "Faizal@123"},
					{getRandomGender(), faker.name().firstName() , faker.name().lastName() , faker.internet().emailAddress() , faker.company().name() , "Faizal@123"}
			
				};
	}
	
	 private String getRandomGender() {
	        String[] genders = {"Male", "Female", "Other"};
	        return genders[new java.util.Random().nextInt(genders.length)];
	    }

}
