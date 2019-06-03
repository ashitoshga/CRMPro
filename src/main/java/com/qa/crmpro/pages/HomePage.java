package com.qa.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.crmpro.base.Testbase;

public class HomePage extends Testbase {

	public HomePage()
	{
		
	}
	
	@FindBy (xpath="//td[contains(text(), 'Ashitosh Gajare')]")
	WebElement user;
	
	
	
}
