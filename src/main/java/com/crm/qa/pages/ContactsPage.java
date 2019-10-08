package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestsBase;

public class ContactsPage extends TestsBase{
	
	
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	 
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(xpath ="//input[@name='client_lookup']")
	WebElement company;
	
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save' and@class='button']"
			+ "//parent::td[@align='center']//preceding-sibling::input[@type='button']")
	WebElement saveBtn;
	
	
	//how will u initilaze your page factory? answer we have one method pagefactory.initelemets by using this method 
    //initilazing pagefactory 
	//constructor here with same class name 
	public ContactsPage() {  
		PageFactory.initElements(driver, this); //here driver is driver this is pointing to current class 
			}
	
	//is displayed method boolean thats why i changed void type to boolean 
	//after that atomatically shows error because its asking add to return type 
	public boolean verifyContactsLabel() {   
		return contactsLabel.isDisplayed();
	}
	
	//here nneed to be more consantrated  ---> name here is paramater we addind to make it more generics if there some check box selecting its better to write method 
	//and define all the checkbox dynamic xpath inside the method, Lets say tomorrow i have 100 check box for each and every check box to write pagefactory find element 
	//find by this is not a good idea 
	
	public void selectContacts(String name) {  
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
		
	}
	
	public void createNewContact(String title, String FirstName, String LastName, String Company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		company.sendKeys(Company);
		saveBtn.click();
		
		
		
		
	}
	
	
	
	
}
