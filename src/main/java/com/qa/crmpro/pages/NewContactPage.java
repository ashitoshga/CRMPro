package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crmpro.base.Testbase;

public class NewContactPage extends Testbase{
			
	public NewContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy (xpath="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy (xpath="//select[@name='title']")
	public static WebElement selecttitle;
	
	@FindBy (name="first_name")
	public static WebElement firstname;
	
	@FindBy (name="middle_initial")
	public static WebElement middle_initial;
	
	@FindBy (name="surname")
	public static WebElement surname;
	
	@FindBy (name="category")
	public static WebElement category;
	public static Select select_category = new Select(category);
	
	@FindBy (name="status")
	public static WebElement status;
	public static Select select_status = new Select(status);
	
	@FindBy (name="phone")
	public static WebElement phone;
	
	@FindBy (name="mobile")
	public static WebElement mobile;
	
	@FindBy (name="email")
	public static WebElement email;
	
	@FindBy (xpath="//input[@name='receive_email']")
	public static WebElement receive_email;
	
	@FindBy (xpath="//input[@name='receive_sms']")
	public static WebElement receive_sms;
	
	@FindBy (xpath="//input[@name='allows_call']")
	public static WebElement allows_call; 
	
	@FindBy (xpath="//input[@name='address_title']")
	public static WebElement address_title;
	
	@FindBy (xpath="//textarea[@name='address']")
	public static WebElement address;
	
	@FindBy (xpath="//input[@name='city']")
	public static WebElement city;
	
	@FindBy (xpath="//input[@name='state']")
	public static WebElement state;
	
	@FindBy (xpath="//input[@name='postcode']")
	public static WebElement postcode;
	
	@FindBy (xpath="//input[@name='country']")
	public static WebElement country;

	public boolean verify_NewContactPage()
	{
		boolean button = SaveBtn.isDisplayed();
		return button;
	}
	
	public void fill_newcontact(String title, String firstname1, String middlename, String lastname,
			String category, String Status, String mobile1, String email1,
			String receiveemail, String receivesms,
			String allowcalls, String addresstitle, String address1, 
			String city1, String state1, String pincode, String country1)
	{
		selecttitle.sendKeys(title);
		firstname.sendKeys(firstname1);
		middle_initial.sendKeys(middlename);
		surname.sendKeys(lastname);
		select_category.selectByValue(category);
		select_status.selectByValue(Status);
		mobile.sendKeys(mobile1);
		email.sendKeys(email1);
		receive_email.sendKeys(receiveemail);
		receive_sms.sendKeys(receivesms);
		allows_call.sendKeys(allowcalls);
		address_title.sendKeys(addresstitle);
		address.sendKeys(address1);
		city.sendKeys(city1);
		state.sendKeys(state1);
		postcode.sendKeys(pincode);
		country.sendKeys(country1);
	}
	

}
