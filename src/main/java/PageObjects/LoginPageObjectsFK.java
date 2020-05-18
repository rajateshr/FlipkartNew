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
import DataUtilities.BrowserFactory;
import TestCases.BaseClass;

public class LoginPageObjectsFK extends BaseClass  {
	
	

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")public WebElement popclose;
	@FindBy(xpath="//a[@class='_3Ep39l']")public WebElement loginbutton;
	@FindBy(xpath="//div[@class='_1jA3uo _34niwY']//div[@class='_1jcwFN _3dmQRh']//div")public WebElement myprofilelink;

	
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
		System.out.println("The string is "+lpg.myprofilelink.getText());
		Assert.assertEquals(lpg.myprofilelink.getText(),"SignIn");
		logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());
		
		/*if(lpg.myprofilelink.getText().equals("My Profile"))
		  {
			test.log(LogStatus.PASS,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Passed");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Failed");

		  }*/
		
	}
	
	public void clickmyprofile()
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		logger.info("Clicking on My Profile link");
		lpg.myprofilelink.click();
		
	}
	
	public void verifyloginpage() throws IOException
	{
		String Actual = driver.getTitle();
		logger.info(Actual);
		
		Assert.assertEquals(Actual,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.pass("Page title verified",MediaEntityBuilder.createScreenCaptureFromPath(BrowserFactory.captureScreenshot(driver)).build());

		/*if(Actual.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		  {
			test.log(LogStatus.PASS,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Page title verified");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Incorrect Page Title");

		  }*/
	}

}
