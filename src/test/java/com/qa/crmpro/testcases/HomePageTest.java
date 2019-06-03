package com.qa.crmpro.testcases;

import org.testng.annotations.BeforeMethod;

import com.qa.crmpro.base.Testbase;
import com.qa.crmpro.pages.LoginPage;

public class HomePageTest extends Testbase {
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initilization();
		//LPobj = new LoginPage();		
	}
	

}
