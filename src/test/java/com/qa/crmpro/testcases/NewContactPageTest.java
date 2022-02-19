package com.qa.crmpro.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crmpro.base.Testbase;
import com.qa.crmpro.pages.ContactPage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.pages.NewContactPage;
import com.qa.crmpro.util.Testutil;

public class NewContactPageTest extends Testbase {
	
	public LoginPage  LPobj;
	public HomePage HPobj;
	public ContactPage ContPobj;
	public NewContactPage NewContobj;
	
	public NewContactPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void initialsetup() throws InterruptedException
	{
		Initilization();
		LPobj = new LoginPage();	
//		HPobj = new HomePage();
//		ContPobj = new ContactPage();
//		NewContobj = new NewContactPage();
		
		HPobj = LPobj.getlogin(prop.getProperty("username"), prop.getProperty("password"));
		Testutil.switchto();
		HPobj.clickOnNewContact();		
	}
	
	@Test(priority=1)
	public void verify_NewContactPage()
	{
		Assert.assertTrue(NewContobj.verify_NewContactPage());
	}
	
	@DataProvider
	public Object[][] getexcel_data()
	{
		Object [][] data = Testutil.getexceldata("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getexcel_data", priority=2)
	public void fill_newcontact(String title, String firstname1, String middlename, String lastname,
			String category, String Status, String mobile1, String email1,
			String receiveemail, String receivesms,
			String allowcalls, String addresstitle, String address1, 
			String city1, String state1, String pincode, String country1)
	{
		
		NewContactPage.selecttitle.sendKeys(title);
		NewContactPage.firstname.sendKeys(firstname1);
		NewContactPage.middle_initial.sendKeys(middlename);
		NewContactPage.surname.sendKeys(lastname);
		NewContactPage.select_category.selectByValue(category);
		NewContactPage.select_status.selectByValue(Status);
		NewContactPage.mobile.sendKeys(mobile1);
		NewContactPage.email.sendKeys(email1);
		NewContactPage.receive_email.sendKeys(receiveemail);
		NewContactPage.receive_sms.sendKeys(receivesms);
		NewContactPage.allows_call.sendKeys(allowcalls);
		NewContactPage.address_title.sendKeys(addresstitle);
		NewContactPage.address.sendKeys(address1);
		NewContactPage.city.sendKeys(city1);
		NewContactPage.state.sendKeys(state1);
		NewContactPage.postcode.sendKeys(pincode);
		NewContactPage.country.sendKeys(country1);
	}
	
	
	
//	
//	public void fill_contactform()
//	{
//		//NewContactPage.selecttitle.sendKeys(title);
//		
//		NewContobj.fill_newcontact("test", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		//Testutil.getexceldata("login");
//	}
	
	
	

}
