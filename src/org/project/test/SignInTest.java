package org.project.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;


public class SignInTest extends BaseTest{
	
	@Test
	public void SignInTest() {
		
		super.setUp();
		
		WebElement home = driver.findElement(By.linkText("Your Home"));
		assertNotNull(home);
		
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		assertNotNull(signOut);
		
		
		driver.quit();
	}

}
