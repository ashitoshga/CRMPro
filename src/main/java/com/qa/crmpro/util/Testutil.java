package com.qa.crmpro.util;

//import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.crmpro.base.Testbase;

public class Testutil extends Testbase{
	public static long implicitlyWait = 10;
	public static long pageLoadTimeout = 120;
	public static String excelfilepath;
	public static Workbook book;
	public static Sheet sheet;
	
	//public WebDriver driver;
	
	public static void switchto()
	{
		driver.switchTo().frame("mainpanel");
	}
	
//	File user_cofntacts_excel = new File("D:\\Home_Projects\\FreeCRMtest\\src\\main\\java\\com\\"
//			+ "qa\\crmpro\\testdata\\user_contacts.xlsx");
//	FileInputStream fis = FileInputStream(user_cofntacts_excel);
//	DataInputStream dis = DataInputStream(fis);
//	String str = dis.readUTF();
	
	public static Object[][] getexceldata(String sheetname) 
	{
		//excelfilepath = "D:\\Home_Projects\\FreeCRMtest\\src\\main\\java\\com\\qa\\crmpro\\testdata\\user_contacts.xlsx"; 
		excelfilepath = "C:\\Users\\Ashitosh\\Desktop\\user_contacts.xlsx";
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(excelfilepath);			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);			
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data [i][k] = sheet.getRow(i+1).getCell(k).toString();
 			}
		}
		return data; 
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
