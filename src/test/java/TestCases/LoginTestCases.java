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
	  logger = extent.createTest("Verifying fields in login popup");
	logger.info("Click on Login button");
	LoginPageObjectsFK lp=new LoginPageObjectsFK();
	lp.clickmylogin();
	lp.verifyloginpopup();  
  }
  
 
  @Test(priority=3)
  public void verifyerrormsg() throws Throwable {
	  logger = extent.createTest("Verifying error message with login with blank username");
	LoginPageObjectsFK lp=new LoginPageObjectsFK();
	lp.verifyerrormsg();


	    
  }
}
