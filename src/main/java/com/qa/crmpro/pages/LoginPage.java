package com.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crmpro.base.Testbase;

public class LoginPage extends Testbase {
	
	//VIMP//initilizing all @FindBy elements using PageFactory from constructor of class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//PageFactory-Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logo;
	
	public String validatelogintitle()
	{
		return driver.getTitle();
	}
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	public HomePage getlogin(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		//after clicking on login btn we are redirected to homepage 
		//HomePage is landing page of LoginPage
		//so here we are creating objects of Homepage class
		//we are creating chain between LoginPage & HomePage
		return new HomePage(); 		
	}

}
