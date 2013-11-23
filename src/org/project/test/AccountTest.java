package org.project.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class AccountTest extends BaseTest {
	
	@Test
	public void createAccountTest() {
		createAccount("newDummy@gmail.com", "123456");
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
