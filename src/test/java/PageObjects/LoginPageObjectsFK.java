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
	@FindBy(xpath="//div[contains(@class,'_39M2dM JB4AMj')]/input[@type='text']")public WebElement emailaddress;
	@FindBy(xpath="//input[@type='password']")public WebElement password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']//span[contains(text(),'Login')]")public WebElement Login;
	@FindBy(xpath="//span[contains(text(),'Please enter valid Email ID')]")public WebElement errormsg;
	@FindBy(xpath="//span[contains(text(),'Your username or password is incorrect')]")public WebElement invalidlogin;
	@FindBy(xpath="//div[text()='You are not registered with us. Please sign up.']")public WebElement invalidloginmsg;
	@FindBy(xpath="//div[contains(text(),'USHA')]")public WebElement userfirstname;
	@FindBy(xpath="//a[@class='_2AkmmA _1LctnI jUwFiZ']")public WebElement existloginbutton;





	
	public void verifyAccLink() throws Throwable
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		Thread.sleep(5000);
		lpg.popclose.click();
		/*Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(lpg.loginbutton).perform();*/
		System.out.println("The string is "+loginlink.getText());
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
	
	public void clickmylogin() throws Throwable
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on Login link");
		lpg.loginlink.click();
		
	}
	
	public void verifyloginpopup() throws Throwable
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);

		Assert.assertTrue(lpg.emailaddress.isDisplayed());
		logger.pass("Email Address is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		Assert.assertTrue(lpg.password.isDisplayed());
		logger.pass("Password is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		Assert.assertTrue(lpg.Login.isDisplayed());
		
		logger.pass("Login button is field present",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
	}
	public void verifyerrormsg() throws Throwable
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on Login button");
		lpg.Login.click();
		Assert.assertEquals(lpg.errormsg.getText(),"Please enter valid Email ID/Mobile number");
		logger.pass("Error message is "+lpg.errormsg.getText(),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}
	
	public void loginbuttoncolor() throws Throwable
	{		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		Assert.assertEquals(lpg.Login.getCssValue("background"),"rgba(0,0,0,.2)");
		logger.pass("The background color of Login button "+lpg.Login.getCssValue("background"),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}
	public void verifyinvalidpwdlogin() throws  Throwable
	{		
		String Username=excel.getStringData("Login", 1, 0);
		String Password=excel.getStringData("Login", 1, 1);
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on Login button");
		Thread.sleep(5000);
		lpg.emailaddress.sendKeys(Username);
		lpg.password.sendKeys(Password);
		lpg.Login.click();
		Thread.sleep(5000);
		Assert.assertEquals(lpg.invalidlogin.getText(),"Your username or password is incorrect");
		logger.pass("Error message is "+lpg.invalidlogin.getText(),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}
	public void verifyinvalidusnlogin() throws  Throwable
	{		
		String Username=excel.getStringData("Login", 2, 0);
		String Password=excel.getStringData("Login", 2, 1);
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		lpg.emailaddress.clear();
		lpg.password.clear();
		Thread.sleep(5000);
		lpg.emailaddress.sendKeys(Username);
		lpg.password.sendKeys(Password);
		lpg.Login.click();
		Thread.sleep(5000);
		Assert.assertEquals(lpg.invalidloginmsg.getText(),"You are not registered with us. Please sign up.");
		logger.pass("Error message is "+lpg.invalidloginmsg.getText(),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}
	
	public void existLoginclick() throws  Throwable
	{		
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		lpg.existloginbutton.click();
		
	}
	public void verifyvalidlogin() throws  Throwable
	{		
		String Username=excel.getStringData("Login", 3, 0);
		String Password=excel.getStringData("Login", 3, 1);
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		lpg.emailaddress.clear();
		lpg.password.clear();
		Thread.sleep(5000);
		lpg.emailaddress.sendKeys(Username);
		lpg.password.sendKeys(Password);
		lpg.Login.click();
		Thread.sleep(5000);
		Assert.assertEquals(lpg.userfirstname.getText(),"USHA");
		logger.pass("The login is successfull and the correct User's first name is "+lpg.userfirstname.getText(),MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactoryFK.captureScreenshot(driver)).build());
		
	}

}
