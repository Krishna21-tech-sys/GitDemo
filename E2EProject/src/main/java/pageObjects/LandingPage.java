package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	//By singin = By.cssSelector("#homepage > header > div.tools > div > nav > ul > li:nth-child(4) > a");
	private By singin = By.cssSelector("a[href*='sign_in']");
	private By checkTest = By.cssSelector("#content > div > div > h2"); 
	//By navBar = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top");
	private By navBar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav");
	//private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By header = By.xpath("//*[@id=\"myCarousel\"]/div/div/div/div/div[1]/h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}  


	public WebElement getLoging()
	{
		return driver.findElement(singin);
	}
	
	public WebElement getcheckText()
	{
		return driver.findElement(checkTest);
	}
	
	public WebElement getnavBar()
	{
		return driver.findElement(navBar);
	}
	

	public WebElement getHeader() {
		// TODO Auto-generated method stub
		return driver.findElement(header);
	}


}
