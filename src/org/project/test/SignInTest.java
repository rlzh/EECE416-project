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
		
		String homeUrl = driver.getCurrentUrl();
		assertTrue(homeUrl.contains("/u"));
		
		WebElement accountInfo = driver.findElement(By.linkText("nayr3169"));
		assertNotNull(accountInfo);
		accountInfo.click();
		WebElement signOut = driver.findElement(By.className("top_button"));
		assertNotNull(signOut);

		driver.quit();
	}

}
