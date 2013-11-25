package org.project.cucumber.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterTest {
	
	private InstapaperDriver driver = new InstapaperDriver(false);
	
	@Given("^I click Create Account$")
	public void I_click_Create_Account() throws Throwable {
		WebElement createAccount = driver.findElement(By.linkText("Create Account"));
		createAccount.click();
	}

	@Given("^I entered my email newDummy@gmail.com as username$")
	public void I_entered_my_email_newDummy_gmail_com_as_username() throws Throwable {
		WebElement newUsername = driver.findElement(By.name("reg_user[username]"));
		newUsername.sendKeys("newDummy@gmail.com");
	}

	@Given("^I entered (\\d+) as my password$")
	public void I_entered_as_my_password(int arg1) throws Throwable {
		WebElement newPassword = driver.findElement(By.name("reg_user[password]"));
		newPassword.sendKeys("123456");
	}

	@When("^I click Create Account again$")
	public void I_click_Create_Account_again() throws Throwable {
		WebElement register = driver.findElement(By.id("register"));
		register.click();
	}

	@Then("^I should be logged in as newDummy$")
	public void I_should_be_logged_in_as_newDummy() throws Throwable {
		WebElement user_row = driver.findElement(By.id("user_row"));
		assertEquals("newDummy", user_row.getText());
		
		driver.deleteAccount();
		driver.quit();
	}

}
