package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crmpro.base.Testbase;

public class LoginPage extends Testbase {
	
	//Very IMP//initilizing all @FindBy elements using PageFactory from constructor of class
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
		String tmp = driver.getTitle();
		System.out.println(tmp);
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
		
		//wait = new WebDriverWait(driver, 20);
		//not able to click on submit button because of preloader element 
		//In exception we can find exact problem 
		//following method also does not work
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']" )));
				//.elementToBeClickable(By.xpath("//input[@type='submit']")));
		
		//final solution
		WebElement ele = driver.findElement(By.xpath("//input[@type='submit']"));		
		JavascriptExecutor	js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		
		//other solution
		//by waiting for invisible element to become invisible
		//wait.until(ExpectedConditions.invisibilityOf(submitBtn));
		
		//another solution		
		//Thread.sleep(10000);
		
	//	boolean SubmitBtndisplayed = wait.until(ExpectedConditions.invisibilityOf(element)(driver.findElement(By.id("preloader"))));
//		if(SubmitBtndisplayed == true)
//		{
//			submitBtn.click();			
//		}
//		boolean Btn = submitBtn.isEnabled();
//		if (Btn == true)
//		{
//			submitBtn.click();
//		}
//		else
//		{
//			System.out.println("Submit button failed");
//		}
		
		//after clicking on login btn we are redirected to homepage 
		//HomePage is landing page of LoginPage
		//so here we are creating objects of Homepage class
		//we are creating chain between LoginPage & HomePage
		return new HomePage(); 		
	}

}
