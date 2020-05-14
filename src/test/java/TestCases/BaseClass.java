package TestCases;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataUtilities.BrowserFactory;
import DataUtilities.ConfigDataProvider;
import DataUtilities.ExcelProvider;

public class BaseClass   {
	public static WebDriver driver;
	public ExcelProvider excel;
	public ConfigDataProvider config;
	public static ExtentTest test;
	public static ExtentReports report;


	  
	  @BeforeSuite
	  public void launchBrowser()
	  {
		  excel=new ExcelProvider();
		  config=new ConfigDataProvider();
		  report = new ExtentReports("C:\\workspace\\QaAutomation\\Flipkart\\Reports\\ExtentReportResults.html");
		  driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
		 
	  }
	  @AfterSuite
	  public void tearDown()  
	  {
      BrowserFactory.quitBrowser(driver);		   
     }
	  
	  @AfterMethod
	  public void tearDownMethod() 
	  {
		  /*if(result.getStatus()==ITestResult.FAILURE)
		  {
			  logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());

		  }*/
		  report.endTest(test);  
	  report.flush();
	  }
}
