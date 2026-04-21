package DataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

import Utilities.ActionUtilities;
import Utilities.ExcelUtilities;

public class DataProviderClass {
	
	@DataProvider(name ="loginData")
	public Object[][] returnDataFromExcel() throws IOException 
	{
		return ExcelUtilities.getData("LoginTest");
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
