package TestCases;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import DataUtilities.BrowserFactory;
import PageObjects.LoginPageObjectsFK;

public class LoginTestCases extends BaseClass  {
	LoginPageObjectsFK lp;
	 
  @Test(priority=1)
  public void verifyMyProfile() throws Throwable {
	logger = extent.createTest("Verifying the My Profile");
	logger.info("Opening the application");

	  lp=new LoginPageObjectsFK();
	  lp.verifyAccLink();
	    
  }
  
  @Test(priority=2)
  public void loginpage() throws Throwable {
	  logger = extent.createTest("Verifying login page");
	logger.info("Click on MyProfile");
	LoginPageObjectsFK lp=new LoginPageObjectsFK();
	lp.clickmyprofile();
	lp.verifyloginpage();

	    
  }
}
