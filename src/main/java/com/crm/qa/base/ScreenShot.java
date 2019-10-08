package com.crm.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
//here static is java keyword unique and we cannot create a copy 
	//we can access this class from another class 
//we dont take main method in order reusiblity purpose 
	public static void  screenShot(WebDriver driver, String sShot) {
		//this is a interface of selenium 
		//because of the takesscreenshot is interface we cannot create of object of that  
		TakesScreenshot  tkss  = (TakesScreenshot)driver;
		File fl = tkss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fl, new File(sShot+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();   //(try catch is blog and its handling any exception )
		}                           //another 10-12 exception more 
		
		
		
	}
		
		
	}






















