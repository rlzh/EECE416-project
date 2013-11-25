package org.project.cucumber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteAccountTest {
	
	private InstapaperDriver driver = new InstapaperDriver(false);
	
	@Given("^I created newDummy account$")
	public void I_created_newDummy_account() throws Throwable {
		createAccount("newDummy@gmail.com", "123456");
	}

	@Given("^I am logged in as newDUmmy$")
	public void I_am_logged_in_as_newDUmmy() throws Throwable {
		WebElement user_row = driver.findElement(By.id("user_row"));
		assertNotNull(user_row);
	}

	@Given("^I click my profile setting$")
	public void I_click_my_profile_setting() throws Throwable {
		WebElement user_row = driver.findElement(By.id("user_row"));
		user_row.click();
	}

	@When("^I click Delete My Account$")
	public void I_click_Delete_My_Account() throws Throwable {
		WebElement deleteAccount = driver.findElement(By.linkText("Delete Account"));
		assertNotNull(deleteAccount);
		deleteAccount.click();
	}

	@When("^confirmed the deletion$")
	public void confirmed_the_deletion() throws Throwable {
		WebElement deleter = driver.findElement(By.className("deleter"));
		assertNotNull(deleter);
		deleter.click();
	}

	@Then("^a confirmation message should be printed out$")
	public void a_confirmation_message_should_be_printed_out() throws Throwable {
		WebElement msg = driver.findElement(By.className("error"));
		assertEquals(msg.getText(), "Your account has been deleted");
		
		WebElement createAccount = driver.findElement(By.linkText("Create Account"));
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		
		assertNotNull(createAccount);
		assertNotNull(signIn);
		
		driver.quit();
	}
	
	/**
	 * Helper function to create account
	 * @param user
	 * @param pwd
	 */
	private void createAccount(String user, String pwd) {
		WebElement createAccount = driver.findElement(By.linkText("Create Account"));
		createAccount.click();

		WebElement newUsername = driver.findElement(By.name("reg_user[username]"));
		newUsername.sendKeys("newDummy@gmail.com");
		WebElement newPassword = driver.findElement(By.name("reg_user[password]"));
		newPassword.sendKeys("123456");

		WebElement register = driver.findElement(By.id("register"));
		register.click();

		WebElement user_row = driver.findElement(By.id("user_row"));
		assertEquals("newDummy", user_row.getText());
	}

}
