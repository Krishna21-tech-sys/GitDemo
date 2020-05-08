package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LogingPage;
import resources.base;

public class homePage extends base
{
	
	private static Logger logger = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intial() throws IOException
	{
		driver = initializeDrive();
		driver.get(prop.getProperty("url")); 
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{	
		
		driver.get(prop.getProperty("url"));
		
		LandingPage LP = new LandingPage(driver);
		LP.getLoging().click();
		
		LogingPage logP = new LogingPage(driver);
		logP.getEmail().sendKeys(Username);
		logP.getPassword().sendKeys(Password);
		//System.out.println("WHAT TEXT AM I PRINTING HERE >>>>> " + text);
		
		logP.loginClick().click();
		logger.info("login clicked");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//rows: how many diff data you have
		// here we have two tests: restricted students & non restricted
		//so one restricted student have two data: username & password
		//columns stands for how many values per each test: 2
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestrictedstudent@gmail.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restrictedstudent@gmail.com";
		data[1][1] = "67890";
		data[1][2] = "Non Restricted User";
		
		return data;
		
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
		driver = null;
	}


}
