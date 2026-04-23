package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	
	private static  Properties prop = new Properties();
	private static Logger logger = LogManager.getLogger(BaseClass.class);
	
	public static void loadConfig() throws IOException
	{
		
		try {
			String file_path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
			FileInputStream fis = new FileInputStream(file_path);
			logger.info("Loading the config file");
			prop.load(fis);
			logger.info("Config file loaded");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Unable to load config file");
			e.printStackTrace();
		} 
	}
	
	public static String getproperty(String key)
	{
		
		return prop.getProperty(key);
		
		
	}

}
