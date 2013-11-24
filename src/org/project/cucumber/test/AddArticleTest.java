package org.project.cucumber.test;

import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddArticleTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private static String url = "http://www.engadget.com/";
	private static String title = "Engadget";
	private static String summary = "Engadget website";
	private static String id;
	
	@Given("^I am at the Add Article Page$")
	public void I_am_at_the_Add_Article_Page() throws Throwable {
	    
	}
	
	@Given("^I have entered http://www.engadget.com/ as the website URL$")
	public void I_have_entered_http_www_engadget_com_as_the_website_URL() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Given("^I have entered Engadget as the website title$")
	public void I_have_entered_Engadget_as_the_website_title() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Given("^I have entered Engadget Summary as the website summary$")
	public void I_have_entered_Engadget_Summary_as_the_website_summary() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I click Add Article$")
	public void I_click_Add_Article() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	@Then("^Engadget should be added into my Unread List$")
	public void Engadget_should_be_added_into_my_Unread_List() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
