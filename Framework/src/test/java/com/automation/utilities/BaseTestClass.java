package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTestClass {
	
	public WebDriver driver;
	
	public ExcelDataprovider  excelDataParovider;
	public ConfigDataProvider  configDataProvider;
	public ExtentReports report;
	
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpData()
	{
	  excelDataParovider=new ExcelDataprovider();
	  configDataProvider=new ConfigDataProvider();
	 // ExtentHtmlReporter  extent=new ExtentHtmlReporter(new File("./Reports/"+Helper.getCurrentDateTime()+".html"));
	  ExtentHtmlReporter  extent=new ExtentHtmlReporter(new File("./Reports/ExtentReport.html"));
	  report=new ExtentReports();
	  report.attachReporter(extent);
	}
	
	@Parameters({"browser","url"})
	@BeforeClass
	 public void startApp(String browser,String url)
	 {
		//driver=BrowserFactory.startApplication(driver,configDataProvider.getConfigData("browser"),configDataProvider.getConfigData("url"));
		
		driver=BrowserFactory.startApplication(driver,browser,url);
		Reporter.log("Application launched");
	 }
	
	@AfterClass
	
	public void closeApplication()
	{
		
		
		BrowserFactory.closeApplication(driver);		
	}
	
	@AfterMethod
	public void captureScreenshot(ITestResult result) throws Exception
	{
		if (result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail(result.getName()+" -Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
		}
		report.flush();
	}
	

}
