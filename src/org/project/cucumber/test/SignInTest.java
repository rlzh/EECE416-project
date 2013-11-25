package org.project.cucumber.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInTest {
	
	private InstapaperDriver driver = new InstapaperDriver(false);
	
	@Given("^I have entered my email dummy@gmail.com as username$")
	public void I_have_entered_my_email_dummy_gmail_com_as_username() throws Throwable {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();

		WebElement newUsername = driver.findElement(By.id("username"));
		newUsername.sendKeys("dummy@gmail.com");
	}

	@Given("^I have entered (\\d+) as my password$")
	public void I_have_entered_as_my_password(int arg1) throws Throwable {
		WebElement newPassword = driver.findElement(By.id("password"));
		newPassword.sendKeys("123456");
	}

	@When("^I click Sign In$")
	public void I_click_Sign_In() throws Throwable {
		WebElement register = driver.findElement(By.id("log_in"));
		register.click();
	}

	@Then("^I should be able to see the pages I added into my account$")
	public void I_should_be_able_to_see_the_pages_I_added_into_my_account() throws Throwable {
		WebElement user_row = driver.findElement(By.id("user_row"));
		assertEquals("dummy", user_row.getText());
		driver.quit();
	}

}
