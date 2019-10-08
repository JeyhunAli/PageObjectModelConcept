//so here how it works clearly let me explain once we execute the code first it will come here in this class to setup method 
//it will initialize the method but before the initializatin it will go to the super keyword to call the super constructor 
//from base class and all the property file reader will define 
//then it will go to base class it will do all the stuff over there maximize ppage load implicit wait vrything that we defined


package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.ScreenShot;
import com.crm.qa.base.TestsBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestsBase{
	LoginPage loginpage; //defining loginpage at class level after creating object of loginpage
	HomePage homepage; 
	ScreenShot scrnShot;
	
	
	//storing home page from loginpage class and importing because of the this method returning home page after all 
	//here we define all the annotations 
	
	//and the we are creating constructor of current class as well 
	
	
	
	public LoginPageTest() {
		super();   // this super keyword will call super constructor from base class in order 
		           //to call property reader file to this method also 
	}
	
	@BeforeMethod 
	public void setUp() {
		initialization(); //here in this class we are calling from base class initialization method
		
		 loginpage = new LoginPage(); //creating object of LoginPage class from loginpage 
		                             //in order to access all the methods in our test class in @test annotation
	}
	
	@Test (priority = 1)
	public void loginPageTitletest() {
		String title =loginpage.validatloginTitle(); //here we are storing our method in string data type 
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmlogoimagetest() {
		boolean flag = loginpage.validateCRMimage();
		Assert.assertTrue(flag);
		
		}
	@Test(priority = 3)
	public void loginTest() {
		 homepage = loginpage.loginValidation(prop.getProperty ("username"), prop.getProperty("password"));
		//here we are passing username,password just like that because we extended base class and we defined prop.property at
		//the base class 
		 ScreenShot.screenShot(driver, "sShot");
	}

	
	@AfterMethod
	public void teardown() {
		
	driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
}