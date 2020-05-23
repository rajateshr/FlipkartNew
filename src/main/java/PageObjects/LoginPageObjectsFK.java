package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import DataUtilities.BrowserFactoryFK;
import TestCases.BaseClass;

public class LoginPageObjectsFK extends BaseClass  {
	
	

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")public WebElement popclose;
	@FindBy(xpath="//a[@class='_3Ep39l']")public WebElement loginbutton;
	@FindBy(xpath="//div[@class='_1jA3uo _34niwY']//div[@class='_1jcwFN _3dmQRh']//div")public WebElement loginlink;
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")public WebElement emailaddress;
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")public WebElement password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']//span[contains(text(),'Login')]")public WebElement Login;
	@FindBy(xpath="//span[contains(text(),'Please enter valid Email ID')]")public WebElement errormsg;




	
	public void verifyAccLink() throws IOException
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lpg.popclose.click();
		/*Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(lpg.loginbutton).perform();*/
		System.out.println("The string is "+lpg.loginlink.getText());
		Assert.assertEquals(lpg.loginlink.getText(),"Login");
		logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
		/*if(lpg.myprofilelink.getText().equals("My Profile"))
		  {
			test.log(LogStatus.PASS,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Passed");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Failed");

		  }*/
		
	}
	
	public void clickmylogin()
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on Login link");
		lpg.loginlink.click();
		
	}
	
	public void verifyloginpopup() throws IOException
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);

		Assert.assertTrue(lpg.emailaddress.isDisplayed());
		logger.pass("Email Address is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		Assert.assertTrue(lpg.password.isDisplayed());
		logger.pass("Password is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		Assert.assertTrue(lpg.Login.isDisplayed());
		
		logger.pass("Login button is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
	}
	public void verifyerrormsg() throws IOException
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on Login button");
		lpg.Login.click();
		Assert.assertEquals(lpg.errormsg.getText(),"Please enter valid Email ID/Mobile number");
		logger.pass("Error message is "+lpg.errormsg.getText(),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}
	
	public void loginbuttoncolor() throws IOException
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		Assert.assertEquals(lpg.Login.getCssValue("background"),"rgba(0,0,0,.2)");
		logger.pass("The background color of Login button "+lpg.Login.getCssValue("background"),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}

}
