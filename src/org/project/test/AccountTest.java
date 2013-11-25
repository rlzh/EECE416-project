package org.project.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.selenium.BaseTest;

public class AccountTest extends BaseTest {

	/**
	 * Test to make a new account
	 */
	@Test
	public void createAccountTest() {

		try {

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

			deleteAccount();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * Test to log in
	 */
	@Test
	public void logInTest() {
		try {

			WebElement signIn = driver.findElement(By.linkText("Sign In"));
			signIn.click();

			WebElement newUsername = driver.findElement(By.id("username"));
			newUsername.sendKeys(username);
			WebElement newPassword = driver.findElement(By.id("password"));
			newPassword.sendKeys(password);

			WebElement register = driver.findElement(By.id("log_in"));
			register.click();

			WebElement user_row = driver.findElement(By.id("user_row"));
			assertEquals("dummy", user_row.getText());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test to sign out
	 */
	@Test
	public void signOutTest() {
		logIn();
		
		try {
			
			WebElement profile = driver.findElement(By.id("user_row"));
			profile.click();
			
			WebElement signOut = driver.findElement(By.className("top_button"));
			signOut.click();
			
			WebElement createAccount = driver.findElement(By.linkText("Create Account"));
			WebElement signIn = driver.findElement(By.linkText("Sign In"));
			
			assertNotNull(createAccount);
			assertNotNull(signIn);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	/**
	 * Test to delete account
	 */
	@Test
	public void deleteAccountTest() {
		
		createAccount("testDelete@gmail.com", "123456");
		
		try {
			
			WebElement user_row = driver.findElement(By.id("user_row"));
			user_row.click();

			WebElement deleteAccount = driver.findElement(By.linkText("Delete Account"));
			deleteAccount.click();

			WebElement deleter = driver.findElement(By.className("deleter"));
			deleter.click();
			
			WebElement msg = driver.findElement(By.className("error"));
			assertEquals(msg.getText(), "Your account has been deleted");
			
			WebElement createAccount = driver.findElement(By.linkText("Create Account"));
			WebElement signIn = driver.findElement(By.linkText("Sign In"));
			
			assertNotNull(createAccount);
			assertNotNull(signIn);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
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

	/**
	 * Helper function to delete account
	 */
	private void deleteAccount() {
		WebElement user_row = driver.findElement(By.id("user_row"));
		user_row.click();

		WebElement deleteAccount = driver.findElement(By.linkText("Delete Account"));
		deleteAccount.click();

		WebElement deleter = driver.findElement(By.className("deleter"));
		deleter.click();
	}

}
