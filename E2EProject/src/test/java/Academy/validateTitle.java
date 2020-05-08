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

public class validateTitle extends base
{
	private static Logger logger = LogManager.getLogger(base.class.getName());
	LandingPage LP;
	
	
	@BeforeTest
	public void intial() throws IOException
	{
		driver = initializeDrive(); 
		logger.info("Driver is initialized");
		
	    LP = new LandingPage(driver);		
	    
		driver.get(prop.getProperty("url"));
		logger.info("Navigated to home page"); 
	}
	
	@Test
	public void validateTitle() throws IOException
	{
		//String title = LP.getcheckText().getText();
		
		//System.out.println("Title page is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + title);
		
		Assert.assertEquals(LP.getcheckText().getText(), "FEATURED COURSES");
		logger.info("Successfully validated text message");
		
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		//System.out.println("validateHeader is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + LP.getHeader().getText());
		Assert.assertEquals(LP.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		logger.info("Successfully validated header message");
		
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
		driver = null;
	}


}
