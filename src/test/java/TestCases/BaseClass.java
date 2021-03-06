package TestCases;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataUtilities.BrowserFactoryFK;
import DataUtilities.ConfigDataProviderFK;
import DataUtilities.ExcelProviderFK;



public class BaseClass extends BrowserFactoryFK   {
	public static WebDriver driver;
	public static ExcelProviderFK excel;
	public ConfigDataProviderFK config;
	public static ExtentTest logger;
	public static ExtentReports extent;


    @Parameters({"browser","urlToBeTest"}) 
	@BeforeSuite
	  public void launchBrowser(String browser,String url)throws IOException
	  {
    	ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ExtentReportResults.html"));
		  excel=new ExcelProviderFK();
		  config=new ConfigDataProviderFK();
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  //driver=BrowserFactoryFK.startApplication(driver,config.getBrowser(),config.getStagingUrl());
		  driver=BrowserFactoryFK.startApplication(driver,browser,url);
		 
	  }
	  @AfterSuite
	  public void tearDown()  throws IOException
	  {
      BrowserFactoryFK.quitBrowser(driver);		   
     }
	  
	  @AfterMethod
	  public void tearDownMethod(ITestResult result) throws IOException 
	  {
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		  }
		  if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());

		  }
		  extent.flush();
	  }
}