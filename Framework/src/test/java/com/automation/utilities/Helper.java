package com.automation.utilities;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String fileName)
	{
		String path=System.getProperty("user.dir")+"/Screenshots/"+fileName+"_"+getCurrentDateTime()+".png";
		File file=new File(path);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(src, file);
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return path;
	}
	
	public static String getCurrentDateTime()
	{
		Date date = new Date();
		
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		
		return dateFormat.format(date);
	}
	

}
