package DataUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	static Properties pro;

	public  ConfigDataProvider() {
		File src=new File("C:\\workspace\\QaAutomation\\Flipkart\\Configeration\\Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load the file " +e.getMessage());
		}
		}
		
		
		public String getBrowser()
		{
			return pro.getProperty("Browser");
		}
		public String getStagingUrl()
		{
			return pro.getProperty("URL");

		}
}
