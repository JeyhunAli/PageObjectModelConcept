package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Utility.TestsUtils;
import com.crm.qa.base.TestsBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//here in this test in order to check some link some button first we have extend base class then 
//then call constructor by useing super keyword from base class in order to run our property files then call 
//set up method with initialization method in order login because without login to the website we wont be able to proceed 

public class HomePageTest extends TestsBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestsUtils testutils;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	
	public HomePageTest() {
		super();

}               
	
	 //whe theres home page  = ... becuse after executing program it has to return hompepage 
    //once we define the homepage here then we create global var as well 
	@BeforeMethod 
	public void setUp() {
		initialization(); 
		testutils = new TestsUtils();
		contactspage = new ContactsPage();
	    loginpage = new LoginPage();
	    dealspage = new DealsPage();
	    
        homepage =  loginpage.loginValidation(prop.getProperty ("username"), prop.getProperty("password"));
   
}
	@Test (priority = 1 )
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "PAGE TITLE IS NOT MATCHING");
		
	}
	
	@Test(priority = 2)
	public void verifyUserNameondashboard() {
		testutils.switchtoFrame();
		Assert.assertTrue(homepage.verifyUserName(), "its not true");
		
	}
	
	@Test(priority = 3)
	public void verifyContactslink() {
		testutils.switchtoFrame(); //here we are defining this method because contact link in a frame 
		                          //here , in before method and class level i mean global level we are creating this method 
		contactspage = homepage.clickOnContactslink();
		
	}
	
	@Test
	public void verifyDealslink() {
		testutils.switchtoFrame();
    	dealspage = homepage.clickOnDealspage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}