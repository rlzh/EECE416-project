package org.project.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class UploadTest extends BaseTest {
	
	@Test
	public void hhh() {
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();
	}

}
