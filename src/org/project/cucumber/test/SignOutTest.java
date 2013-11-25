package org.project.cucumber.test;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignOutTest {
	
	private InstapaperDriver driver = new InstapaperDriver(false);
	
	@Given("^I am logged in as dummy$")
	public void I_am_logged_in_as_dummy() throws Throwable {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();

		WebElement newUsername = driver.findElement(By.id("username"));
		newUsername.sendKeys("dummy@gmail.com");
		WebElement newPassword = driver.findElement(By.id("password"));
		newPassword.sendKeys("123456");

		WebElement signInBtn = driver.findElement(By.id("log_in"));
		signInBtn.click();
	}

	@When("^I click on my profile setting$")
	public void I_click_on_my_profile_setting() throws Throwable {
		WebElement profile = driver.findElement(By.id("user_row"));
		assertNotNull(profile);
		profile.click();
	}

	@When("^I click on Sign Out icon$")
	public void I_click_on_Sign_Out_icon() throws Throwable {
		WebElement signOut = driver.findElement(By.className("top_button"));
		assertNotNull(signOut);
		signOut.click();
	}

	@Then("^I should be signed out$")
	public void I_should_be_signed_out() throws Throwable {
		WebElement createAccount = driver.findElement(By.linkText("Create Account"));
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		
		assertNotNull(createAccount);
		assertNotNull(signIn);
		
		driver.quit();
	}

}
