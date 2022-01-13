package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;   

public class LoginTest extends BaseClass {
	
	@Test
	public void loginApp() {
		System.out.println("--Running LoginTest--");
	    logger =report.createTest("Login to Application");
	    logger.info("Starting Application");
	    
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.logintoDemo(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Success ");
	}
	
	
	@Test
	public void loginApp2() {
		System.out.println("--Running LoginTest2--");
	    logger =report.createTest("Login to Application 2");
	
		

		
		logger.fail("Logout Fail");
	}
	
	
	

}
