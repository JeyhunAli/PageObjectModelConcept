package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestsBase;

public class LoginPage  extends TestsBase {
	
	//Page Factory --OB object repository 
	//It is used to initialize elements of a Page class without having to use ‘FindElement’ or ‘FindElements’.
	//Annotations can be used to supply descriptive names of target objects to improve code readability.
 
	@FindBy(name="username")
	WebElement  username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath = "//input[@class=\"btn btn-small\"]")
	WebElement loginBtn;
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;
	
	//now creating the constructor of the class and defining all the elements 
	//using here page factory to initializing the elements 
	public LoginPage() {
		//how will u initilaze your page factory? answer we have one method pagefactory.initelemets by using this method 
		PageFactory.initElements(driver, this); //here driver is driver this is pointing to current class 
			}
	 //here we are defining some actions 
	
	public String validatloginTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMimage() {
		return logo.isDisplayed();
	}
	
	public HomePage loginValidation(String un, String pswd) {
		username.sendKeys(un);
		password.sendKeys(pswd);
		loginBtn.click();
		
		//here after adding un, pswd and login button it will take us to home page 
		//thats why we adding return type home page then method void type changing to the HomePage 
		return new HomePage(); 
	}
	
	
	
}


























