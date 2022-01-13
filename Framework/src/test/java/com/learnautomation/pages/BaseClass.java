package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;

	public ExcelDataProvider excel;

	public ConfigDataProvider config;

	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up Report and Test is getting ready ",true);

		excel = new ExcelDataProvider();	
		config = new ConfigDataProvider();

		ExtentSparkReporter extent  = new  ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));  
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
		Reporter.log("Setting done Test can be started",true);
	}

	@BeforeClass
	public void setup() {
		
//		Reporter.log("Setting up Report and Test is getting ready ",true);
//		ExtentSparkReporter extent = new ExtentSparkReporter( new File(System.getProperty("user.dir") + "/Reports/DemoFramework " + Helper.getCurrentDateTime() + ".html"));
//		report = new ExtentReports();
//		report.attachReporter(extent);
//		excel = new ExcelDataProvider();
//		config = new ConfigDataProvider();
//		Reporter.log("Setting done Test can be started",true);
		
		
		Reporter.log("Trying to Start Browser and Getting Application Ready",true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log(" Browser and  Application are Up and Running",true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end",true);
		if (result.getStatus() == ITestResult.FAILURE) {

			// Helper.captureScreenshot(driver);
			logger.fail("Test Failed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			// Helper.captureScreenshot(driver);
			logger.pass("Test Passed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();
		
		Reporter.log("Test Completed >> Reports generated",true);
		Reporter.log("",true);
	}
}
