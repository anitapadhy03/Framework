package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.LandingPage;
import com.automation.pages.LoginPage;
import com.automation.utilities.BaseTestClass;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.Helper;

public class LandingPageTest extends BaseTestClass{
	
	@Test
	public void testLogin()
	{
		Reporter.log("Application started-Reporter");
		logger=report.createTest("LogintoCRM");
		//To initialize the page object. It returns the object of the same class.
		LandingPage landingPage=PageFactory.initElements(driver, LandingPage.class);
		landingPage.navigateToLoginPage();
		logger.info("Navigated to login page");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(excelDataParovider.getStringValue("Login", 0, 0),excelDataParovider.getStringValue("Login", 0, 1));
		logger.pass("Login successful");
		Reporter.log("Login Successful-Reporter");
		
	}
	

	

}
