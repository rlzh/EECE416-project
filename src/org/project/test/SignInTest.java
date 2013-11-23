package org.project.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SignInTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		driver = new FirefoxDriver();
		
	}
	
	@Test
	public void signInTest() {
		
		WebElement home = driver.findElement(By.linkText("Your Home"));
		assertNotNull(home);
		
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		assertNotNull(signOut);
	}

}
