package org.project.cucumber.test;

import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LikeArticleTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	
	@Given("^I added Engadget into my account$")
	public void I_added_Engadget_into_my_account() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Given("^I liked the Engadget article$")
	public void I_liked_the_Engadget_article() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I click the Heart icon$")
	public void I_click_the_Heart_icon() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Engadget should be liked and shows up in my Liked page$")
	public void Engadget_should_be_liked_and_shows_up_in_my_Liked_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
