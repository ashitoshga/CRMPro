package com.qa.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.crmpro.base.Testbase;

public class HomePage extends Testbase {
	
	public Actions action;
	//initilizing driver through constructor of class
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		action = new Actions(driver);		
	}

//Page Factory
	//finding user label
	@FindBy (xpath="//td[contains(text(), 'Ashitosh Gajare')]")
	WebElement userlabel;
	
	@FindBy (xpath=("//a[@title='Contacts']"))
	WebElement Contacts;
	
	@FindBy (xpath=("//a[@title='New Contact']"))
	WebElement NewContact;
	
	@FindBy (xpath=("//a[@title='Deals']"))
	WebElement Deals;
	
	public boolean verify_userlabel()
	{
		return userlabel.isDisplayed();
	}
	
	public ContactPage clickOncontactslink()
	{
		Contacts.click();
		return new ContactPage();		
	}
	public NewContactPage clickOnNewContact()
	{	
		action.moveToElement(Contacts).build().perform();
		NewContact.click();
		return new NewContactPage();		
	}
	
//	public DealsPage clickOnDeals()
//	{
//		Deals.click();
//		return new DealsPage();
//	}
	
	
}
