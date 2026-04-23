package BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverManager {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static int impicitTime = Integer.parseInt(ConfigReader.getproperty("implicitwait"));
	
	
	public static void initDriver()
	{
		
			ChromeOptions options = new ChromeOptions();

	        // Basic stability
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-infobars");
	        options.addArguments("--disable-extensions");

	        // Reduce automation fingerprint
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        options.setExperimentalOption("excludeSwitches",
	                new String[]{"enable-automation"});

	        options.setExperimentalOption("useAutomationExtension", false);

	        // Optional: incognito
	        options.addArguments("--incognito");

			driver.set(new ChromeDriver(options));
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(impicitTime));
		
	}
	
	public static WebDriver getDriver()
	{
		if (driver.get() == null)
		{ 
			throw new RuntimeException("Driver is not initialized");
		}
		
		return driver.get();
	}
	
	 public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove(); // very important to avoid memory leaks
	        }
	    }
	}


