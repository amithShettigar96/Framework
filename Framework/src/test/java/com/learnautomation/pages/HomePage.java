package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;

	public HomePage (WebDriver hdriver) {

		this.driver = hdriver;

	}
	
	@FindBy(id="logout") WebElement logoutBtn;
	
	public void verifyLogoutBtn() {
		System.out.println("Logout is running");
		logoutBtn.isDisplayed();
		logoutBtn.click();
	}

}
