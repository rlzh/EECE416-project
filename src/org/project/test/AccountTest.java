package org.project.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class AccountTest extends BaseTest {

	@Test
	public void createAccountTest() {

		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();
		
		WebElement newUsername = driver.findElement(By.id("username"));
		newUsername.sendKeys("newDummy@gmail.com");
		WebElement newPassword = driver.findElement(By.id("password"));
		newPassword.sendKeys("123456");
		
		WebElement register = driver.findElement(By.id("register"));
		register.click();

	}

	@Test
	public void logInTest() {

	}

	@Test
	public void signOutTest() {

	}

	@Test
	public void deleteAccountTest() {

	}

}
