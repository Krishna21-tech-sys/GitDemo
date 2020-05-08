package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogingPage {
	
public WebDriver driver;
	
	//By singin = By.cssSelector("#homepage > header > div.tools > div > nav > ul > li:nth-child(4) > a");
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.cssSelector("#new_user > div.form-group.text-center > input");

	
	public LogingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement loginClick()
	{
		return driver.findElement(login);
	}

}
