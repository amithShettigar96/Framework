package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	
	@FindBy(id="name") WebElement unameTxt;
	@FindBy(id="password") WebElement passTxt;
	@FindBy(id="login") WebElement loginBtn;
	@FindBy(xpath="//div[text()='Password is invalid']") WebElement errorPass;
	
	public void logintoDemo(String username, String password) {
		unameTxt.sendKeys(username);
		System.out.println("Username = "+username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		passTxt.sendKeys(String.valueOf(password));
		System.out.println("Password  = "+password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		loginBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		
		
	}
	
	public boolean verifyPasswordErrorMessage() {
		System.out.println("verification is running");
		return errorPass.isDisplayed();
	}
	
	public boolean verifyLoginBtn() {
		
		return loginBtn.isDisplayed();
	}
	
}
