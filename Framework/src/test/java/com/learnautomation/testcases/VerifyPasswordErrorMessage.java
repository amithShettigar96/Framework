package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class VerifyPasswordErrorMessage extends BaseClass {

	
	
	@Test
	public void verifyPasswordErrorMessage() {
		System.out.println("--Running verifyPasswordErrorMessage--");
		logger = report.createTest("Running verifyPasswordErrorMessage Functionality");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		
		logger.info("Starting Application");
		
		loginPage.logintoDemo(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		loginPage.verifyPasswordErrorMessage();
		
		logger.pass("Password Error Message Success");
	}
}
