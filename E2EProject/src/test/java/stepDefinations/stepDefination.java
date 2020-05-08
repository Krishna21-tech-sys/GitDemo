package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LogingPage;
import resources.base;

import java.io.IOException;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination extends base{


	@Given("^Initialize the browserwith chrome$")
	public void initialize_the_browserwith_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDrive();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_sign_in_Page() {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage LP = new LandingPage(driver);
		LP.getLoging().click();
	}



	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable 
	{
		LogingPage logP = new LogingPage(driver);
		logP.getEmail().sendKeys(username);
		logP.getPassword().sendKeys(password);
		logP.loginClick().click();
	}
	
	@And("^close browsers")
	public void close_browsers() throws Throwable
	{
		driver.quit();
	}


}
