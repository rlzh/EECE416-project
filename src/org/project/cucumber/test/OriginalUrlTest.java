package org.project.cucumber.test;

import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OriginalUrlTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	
	@Given("^I am reading Engadget on my account$")
	public void I_am_reading_Engadget_on_my_account() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I click on the Globe icon$")
	public void I_click_on_the_Globe_icon() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should be at Engadget's original website with url http://www.engadget.com$")
	public void I_should_be_at_Engadget_s_original_website_with_url_http_www_engadget_com() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
