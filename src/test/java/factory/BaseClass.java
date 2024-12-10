package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
		static Properties p;
		static Logger logger;
		static WebDriver driver;
		
	// communicating with config.properties file
	public static Properties getProperties() throws IOException
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties"); 
		p = new Properties(); //declare object
		p.load(file); //load file information in to the object
		return p; //send outside the method with in the class
		
	}
	
	// used as a tool to log the user actions
	public static Logger getLogger()
	{
		logger=LogManager.getLogger(); //Log4j
		return logger;
		
	}
	public static WebDriver initilizeBrower() 
	{
		
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--headless");
		
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String rndAlphaNumeric() {
		String  str = RandomStringUtils.randomAlphabetic(5);
		String  num = RandomStringUtils.randomNumeric(2);
		return str+num;
	}
}
