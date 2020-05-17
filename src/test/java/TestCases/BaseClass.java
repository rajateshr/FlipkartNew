package TestCases;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataUtilities.BrowserFactory;
import DataUtilities.ConfigDataProvider;
import DataUtilities.ExcelProvider;

public class BaseClass   {
	public static WebDriver driver;
	public ExcelProvider excel;
	public ConfigDataProvider config;
	public static ExtentTest logger;
	public static ExtentReports extent;


	  
	  @BeforeSuite
	  public void launchBrowser()throws IOException
	  {
		  ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ExtentReportResults"+BrowserFactory.getCurrentDateTime()+".html"));
		  excel=new ExcelProvider();
		  config=new ConfigDataProvider();
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
		 
	  }
	  @AfterSuite
	  public void tearDown()  throws IOException
	  {
      BrowserFactory.quitBrowser(driver);		   
     }
	  
	  @AfterMethod
	  public void tearDownMethod(ITestResult result) throws IOException 
	  {
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());
		  }
		  if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());

		  }
		  extent.flush();
	  }
}
