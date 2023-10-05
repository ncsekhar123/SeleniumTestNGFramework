package testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static WebDriver driver;
	
	public static FileInputStream fis;
	public static Properties config = new Properties();
	
	public static String browser;

	public baseClass() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	void setup() throws IOException {
		
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			        config.load(fis);
			        
  			        //logger.info("Config file is loaded !");			  
		} 
		
		catch (FileNotFoundException e) {

			e.printStackTrace();
			//logger.info("Config file - FileNotFoundException !");
			//logger.debug("Config file - Debug information !");
		}
		

        browser = config.getProperty("browser");
		//logger.info("browserLaunch() - Browser is " + browser);


		// Firefox driver implementation
		if (browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			//logger.info("Browser is setup - " + browser);
	   		driver = new FirefoxDriver();
	   		//logger.info("Selenium driver - " + browser);
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
			} 

		// Chrome driver implementation
		
		else if (browser.equalsIgnoreCase("chrome")) {  
			
			WebDriverManager.chromedriver().setup();
			//logger.info("Browser is setup - " + browser);
	   		driver = new ChromeDriver();
	   		//logger.info("Selenium driver - " + browser);
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
			} 
		
		// Edge driver implementation
		else if (browser.equalsIgnoreCase("edge")) {  
			
			WebDriverManager.edgedriver().setup();
			//logger.info("Browser is setup - " + browser);
			driver = new EdgeDriver();
			//logger.info("Selenium driver - " + browser);
			
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
			}
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	@AfterClass()
		void tearDown() {
		
		driver.quit();
		
	}

}
