package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.Utility.TestsUtils;
import com.crm.qa.Utility.WebEventListener;

public class TestsBase {

	public static WebDriver driver; //right after class name initializing webdriver
	public static Properties prop;  // initializing properties to read the file 
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
	
	public TestsBase() { //creating constructor of testsbase class

		try { 
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Ali-c\\eclipse-workspace\\PageObjectModelConcept"
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.Properties");
			prop.load(ip);
			//purpose of this code to read the properties file 
			//this the code from try to last catch to read the file from properties file 
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browsername =  prop.getProperty("browser");
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ali-c\\eclipse-workspace\\"
					+ "PageObjectModelConcept\\Drivers\\chromedriver.exe" );
			driver = new ChromeDriver();


		}
		else if(browsername.equals("gecko")) {
			System.setProperty("WebDriver.gecko.driver","C:\\Users\\Ali-c\\eclipse-workspace"
					+ "\\PageObjectModelConcept\\Drivers\\geckodriver.exe" );
			driver = new FirefoxDriver();

		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(TestsUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(TestsUtils.IMPILICIT_WAIT,  TimeUnit.SECONDS);
          //here we are calling page load and implicit wait from testutils class by class name
          
          driver.get(prop.getProperty("url"));





	}
}