package com.qa.crmpro.testcases;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crmpro.base.Testbase;
import com.qa.crmpro.pages.ContactPage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.pages.NewContactPage;
import com.qa.crmpro.util.Testutil;

public class HomePageTest extends Testbase {
	
	public LoginPage  LPobj;
	public HomePage HPobj;
	public ContactPage ContPobj;
	public NewContactPage NewContobj;
	//public Actions action;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		Initilization();
		//HPobj = LPobj.getlogin(prop.getProperty("username"), prop.getProperty("password"));
		LPobj = new LoginPage();
//		HPobj = new HomePage();		
//		ContPobj = new ContactPage();
//		NewContobj = new NewContactPage();
		HPobj = LPobj.getlogin(prop.getProperty("username"), prop.getProperty("password"));
		//LPobj.getlogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test(priority=1)
//	public void verifyuser()
//	{
//	//	WebElement test = HPobj.verify_userlabel();
//		Assert.assertTrue(true, "Invalid user");
//	}
//	
//	@Test(priority=2)
//	public void ContactsLinkTest()
//	{
//		//switching to frame
//		Testutil.switchto();
//		ContPobj = HPobj.clickOncontactslink();
//	}
	
	@Test(priority=3)
	public void AddNewContact()
	{		
		Testutil.switchto();
		NewContobj = HPobj.clickOnNewContact();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
