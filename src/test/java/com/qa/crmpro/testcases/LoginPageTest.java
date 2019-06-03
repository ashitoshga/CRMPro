package com.qa.crmpro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crmpro.base.Testbase;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;

public class LoginPageTest extends Testbase{
	public LoginPage LPobj;
	public HomePage HPobj;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initilization();
		LPobj = new LoginPage();		
	}
	
	@Test(priority=1)
	public void verifyloginpagetest()
	{		
		String title = LPobj.validatelogintitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Login Page title verified");
			
	}
	@Test(priority=2)
	public void verifylogo()
	{
		boolean flag = LPobj.validatelogo();	
		Assert.assertTrue(true);
	}
	@Test(priority=3)
	public void verifylogintest() throws InterruptedException
	{
		HPobj = LPobj.getlogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(120);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
