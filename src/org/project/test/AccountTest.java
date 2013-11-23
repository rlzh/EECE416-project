package org.project.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class AccountTest extends BaseTest {
	
	@Test
	public void signUpTest() {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("newDummy");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement checkbox = driver.findElement(By.name("keep_logged_in"));
		if (checkbox.isSelected()) checkbox.click();
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
