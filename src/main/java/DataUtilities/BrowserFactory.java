package DataUtilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class BrowserFactory {
	
	private static DateFormat customFormat;

	public static WebDriver startApplication(WebDriver driver,String browserName,String Url)
	{
		 if(browserName.equals("Chrome")) {  
			  
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Documents\\rajatesh\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
		  } 
	else if(browserName.equals("firefox")) {
		  
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Documents\\rajatesh\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		  
		  driver = new FirefoxDriver();

		  }
	else
	{
		System.out.println("We do not support the browser");
	}
	 
	 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
     driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 driver.get(Url);
	 return driver;
     
	}
	  public static void quitBrowser(WebDriver driver)
	  {
		   
		  driver.quit();
	  }
	  
	  public static  String captureScreenshot(WebDriver driver)
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String  screenshotPath=System.getProperty("user.dir")+"/Screenshots/Flipkart_"+getCurrentDateTime()+ ".png";
			try {
				FileHandler.copy(src, new File(screenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return screenshotPath;
		}
	  
	  public static String getCurrentDateTime()
	  {
		  DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		  Date currentDate=new Date();
		return customFormat.format(currentDate);
		  
	  }
	  
}
