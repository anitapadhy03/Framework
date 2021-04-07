package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[@href='https://ui.cogmento.com']")
	public WebElement btnLogin;
	
	
	//To identify the Driver
	public LandingPage(WebDriver iDriver)
	{
		this.driver= iDriver;
	}
	
	public void navigateToLoginPage()
	{
		
		btnLogin.click();
		
	}

}
