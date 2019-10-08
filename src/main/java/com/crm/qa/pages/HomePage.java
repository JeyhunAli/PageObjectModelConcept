package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestsBase;
//always need to remember in pageobject model if you clikin some button or link and it goes to another page 
//need to write retur type of the new landing page 
public class HomePage  extends TestsBase{

	@FindBy(xpath = "//td[contains(text(),'User: jeyhun aliyev')]")
	WebElement userNameOnDashboard;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLinks;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewcontactsLinks;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath = "//a[contains(text(),\"Reports\")]")
    WebElement reports;
	

	public void setTaskLink(WebElement taskLink) {
		this.taskLink = taskLink;
	}

	public HomePage() {        //here we are creating constructor of class in order to access all the web elements and perform 
		                      //pagefactory initializing
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {  //always verufy home page title 
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameOnDashboard.isDisplayed();
	}
	
	public ContactsPage clickOnContactslink() {
		contactsLinks.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealspage() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskPage() {
		taskLink.click();
		return new  TaskPage();
	}
	
	public ReportsPage clickonReports() {
		reports.click();
		return new ReportsPage();
		  
		//here if you want to create another method which is not created of class in page package it gonna give error first create a class 
		//extend base class then define it here 
		
	}
	public void clickOnNewContactsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLinks).build().perform();
		NewcontactsLinks.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
