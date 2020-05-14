package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import DataUtilities.BrowserFactory;
import TestCases.BaseClass;

public class LoginPageObjectsFK extends BaseClass  {
	
	

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")public WebElement popclose;
	@FindBy(xpath="//a[@class='_3Ep39l']")public WebElement loginbutton;
	@FindBy(xpath="//div[@class='_1jA3uo _34niwY']//div[@class='_1jcwFN _3dmQRh']//div[text()='My Profile123']")public WebElement myprofilelink;

	
	public void verifyAccLink()
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lpg.popclose.click();
		Actions actions = new Actions(BaseClass.driver);
		actions.moveToElement(lpg.loginbutton).perform();
		
		if(lpg.myprofilelink.getText().equals("My Profile"))
		  {
			test.log(LogStatus.PASS,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Passed");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Test Failed");

		  }
		
	}
	
	public void clickmyprofile()
	{
		
		LoginPageObjectsFK lpg=PageFactory.initElements(BaseClass.driver,LoginPageObjectsFK.class);
		test.log(LogStatus.INFO, "Clicking on My Profile link");
		lpg.myprofilelink.click();
		
	}
	
	public void verifyloginpage()
	{
		String Actual = driver.getTitle();
		test.log(LogStatus.INFO, Actual);
		
		if(Actual.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		  {
			test.log(LogStatus.PASS,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Page title verified");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL,test.addScreenCapture(BrowserFactory.captureScreenshot(driver))+ "Incorrect Page Title");

		  }
	}

}
