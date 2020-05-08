package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDrive() throws IOException
	{
		prop = new Properties();
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(file);
		//String browserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		//String URLName = prop.getProperty("url");
		

		
		if(browserName.contains("chrome"))   
		{
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\Chrome\\Version 81.0.4044.69\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			
			//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\Firefox\\Version_0.26.0\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\IE\\Version_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShots(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\104795\\Mavenjava\\E2EProject\\Screenshots\\"+result+"screenshot.png"));
		
	}

}
