package com.qa.crmpro.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crmpro.util.Testutil;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	//public static Actions action;
	
	//Initilizing/loading config file into java class
	public Testbase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Home_Projects\\FreeCRMtest\\src\\main\\"
					+ "java\\com\\qa\\crmpro\\config\\config.properties");
			prop.load(fis);
			//System.out.println(prop.getProperty("browser"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		//action = new Actions(driver);
	}
	
	//Initilizing 
	public void Initilization()
	{
		//getting browser name from config file
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			//System.getProperty("F:\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Practice\\Selenium_installable\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("IE"))
		{
			//System.getProperty("F:\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Practice\\Selenium_installable\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//Pageload timeout,maximize,delete cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageLoadTimeout, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(Testutil.implicitlyWait, TimeUnit.SECONDS);
		
		//getting url
		driver.get(prop.getProperty("url"));
	}

	
	

}
