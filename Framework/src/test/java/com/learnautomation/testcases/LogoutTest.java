package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class LogoutTest extends BaseClass  {

	
	@Test
	public void logoutApp() {
		System.out.println("--Running LogoutTest--");
		logger = report.createTest("Logout from Application");
		logger.info("Starting Application");
		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		loginPage.logintoDemo(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
		homePage.verifyLogoutBtn();
		
		logger.pass("Logout Success");
	}
}
