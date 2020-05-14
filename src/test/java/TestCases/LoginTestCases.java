package TestCases;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import DataUtilities.BrowserFactory;
import PageObjects.LoginPageObjectsFK;

public class LoginTestCases extends BaseClass  {
	LoginPageObjectsFK lp;
	 
  @Test(priority=1,description = "Verifying the My Profile")
  public void verifyMyProfile() throws Throwable {
	test = report.startTest("Verifying the My Profile");
	test.log(LogStatus.INFO,"Opening the application");

	  lp=new LoginPageObjectsFK();
	  lp.verifyAccLink();
	    
  }
  
  @Test(priority=2,description = "Login Page")
  public void loginpage() throws Throwable {
	test = report.startTest("Verifying login page");
	test.log(LogStatus.INFO,"Click on MyProfile");
	LoginPageObjectsFK lp=new LoginPageObjectsFK();
	lp.clickmyprofile();
	lp.verifyloginpage();

	    
  }
}
