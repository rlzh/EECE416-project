package org.project.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SignIn extends BaseTest{
	
	public boolean testPassed() {
		WebElement element = driver.findElement(By.name("signinForm"));
		WebElement email = element.findElement(By.name("email"));
		email.sendKeys("nayr3169@hotmail.com");
		WebElement password = element.findElement(By.name("password"));
		password.sendKeys("123456");
		
		element.submit();
		
		driver.findElement(By.linkText("Your Home"));
		driver.findElement(By.linkText("Sign Out"));
		
		driver.quit();
		
		return true;
	}

}
