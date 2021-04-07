package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		
	}
	@FindBy(name="email")
	public WebElement txtuser;
	
	
	@FindBy(name="password")
	public WebElement txtpassword;
	
	
	@FindBy(xpath="//div[contains(text(), 'Login')]")
	public WebElement btnSubmit;
	
	
	public  void login(String user, String pw)
	{
		txtuser.sendKeys(user);
		txtpassword.sendKeys(pw);
		
		btnSubmit.click();
	}

}
