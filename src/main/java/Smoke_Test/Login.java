package Smoke_Test;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basetest;
import Base.all_xpaths;

public class Login extends Basetest implements all_xpaths{
	
	private static final Logger logger = LogManager.getLogger(Single_Card_Creation.class);
	static WebDriver driver;
	
	@Test
	public static void Single_Card() throws Exception{

		// To read The Property File 
				Properties prop=new Properties();
				FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
				prop.load(ip);
		
		 try{		
		 // Launching Browser	
	     launchBrowser(prop.getProperty("Browser"));	
		 Thread.sleep(5000);

	     // passing the URL
	      sendURL(prop.getProperty("DevUrl"));
		 logger.info("Estockgifts Open Successfully");
		// Thread.sleep(5000);
		  click(LoginButton);
		  click(Login_As_Member);
		  
		// Closing the browser
	         
	       quitBrowser();
		  

			 } catch (Exception e) {
				/* logger.error("Test Fail", e); */
			    onTestFailure();
			    driver.quit();
				Assert.fail("");

			}
	} 

}