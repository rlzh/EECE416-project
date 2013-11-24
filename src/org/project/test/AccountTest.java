package org.project.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class AccountTest extends BaseTest {

	@Test
	public void createAccountTest() {

		try {

			WebElement createAccount = driver.findElement(By.linkText("Create Account"));
			createAccount.click();

			WebElement newUsername = driver.findElement(By.id("username"));
			newUsername.sendKeys("newDummy@gmail.com");
//			WebElement newPassword = driver.findElement(By.id("password"));
//			newPassword.sendKeys("123456");

//			WebElement register = driver.findElement(By.id("register"));
//			register.click();
//
//			WebElement user_row = driver.findElement(By.id("user_row"));
//			assertEquals("newDummy", user_row.getText());
//
//			deleteAccount();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

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
			fail();
		}
	}

	@Test
	public void signOutTest() {

	}

	@Test
	public void deleteAccountTest() {

	}

	private void deleteAccount() {
		WebElement user_row = driver.findElement(By.id("user_row"));
		user_row.click();

		WebElement deleteAccount = driver.findElement(By.linkText("Delete Account"));
		deleteAccount.click();

		WebElement deleter = driver.findElement(By.className("deleter"));
		deleter.click();
	}

}
