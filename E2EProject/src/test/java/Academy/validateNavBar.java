package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;


public class validateNavBar extends base
{
	private static Logger logger = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intial() throws IOException
	{
		driver = initializeDrive();
		driver.get(prop.getProperty("url"));  
	}

	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage LP = new LandingPage(driver);
		
		//String title = LP.getcheckText().getText();
		
		Assert.assertTrue(LP.getnavBar().isDisplayed());
		logger.info("Navigation bar is deisplayed"); 
		
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
		driver = null;
	}

}
