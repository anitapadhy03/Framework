package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BrowserFactory { 
	
	
	public static WebDriver startApplication(WebDriver driver, String browser, String url)
	{
		
		if (browser.equals("chrome"))
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void closeApplication(WebDriver driver)
	{
		driver.close();
	}
	

}
