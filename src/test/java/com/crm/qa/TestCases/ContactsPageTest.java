

//here in this test i used test driven approach it very handy lets say tomorrow i ll have 100 test cases 
//all of them not possible to write inside of the script and define them in pageclasses then import from page class to test then pass 
// all the paramaters inside the brackets this would be wrong approach 
// data driven is perfectly works with excel sheet 
//creating excel sheet with diffrenet set of data then executing the test case 






 
package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Utility.TestsUtils;
import com.crm.qa.base.TestsBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestsBase{
	
	LoginPage loginpage;
	HomePage homepage;            
	TestsUtils testutils;              //all these here are the class name and reference name 
	ContactsPage contactspage;
	DealsPage dealspage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();

}      
	
	@BeforeMethod 
	public void setUp() {
		initialization(); 
		testutils = new TestsUtils();
		contactspage = new ContactsPage();
	    loginpage = new LoginPage();
	    dealspage = new DealsPage();
	    
        homepage =  loginpage.loginValidation(prop.getProperty ("username"), prop.getProperty("password"));
        testutils.switchtoFrame(); 
        contactspage = homepage.clickOnContactslink();
}
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "label is not displayed");
		
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactspage.selectContacts("test2 test2 ali");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactspage.selectContacts("test2 test2 ali");
		contactspage.selectContacts("famil ali");
	}
	
	
	
	
	@DataProvider
	public Object[][] getCRMDataTest() {
		Object data [][] = TestsUtils.getTestData(sheetName); //storing into two dimension array in order to read excel row and column 
		return data;
	}
	
	
	
	
	//whenever we are creating method which is fetching data from excell sheet inside of the method we have to 
	//pass to parameter column names other wise it will not execute it will give missmatch error 
	@Test(priority = 4, dataProvider= "getCRMDataTest" )
	public void validateCreateNewContacts(String title, String FirstName, String LastName, String Company) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("Mr.", "Tom", "peter", "google");
		contactspage.createNewContact(title, FirstName, LastName, Company);
		
	}

	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
