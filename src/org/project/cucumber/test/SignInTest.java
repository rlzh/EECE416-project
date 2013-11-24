package org.project.cucumber.test;

import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	
	@Given("^I have entered my email dummy@gmail.com as username$")
	public void I_have_entered_my_email_dummy_gmail_com_as_username() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Given("^I have entered (\\d+) as my password$")
	public void I_have_entered_as_my_password(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I click Sign In$")
	public void I_click_Sign_In() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should be able to see the pages I added into my account$")
	public void I_should_be_able_to_see_the_pages_I_added_into_my_account() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
