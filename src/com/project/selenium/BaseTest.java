package com.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	private static final String url = "http://tinypic.com/";
	
	protected static WebDriver driver;
	
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		
		WebElement element = driver.findElement(By.name("signinForm"));
		WebElement email = element.findElement(By.name("email"));
		email.sendKeys("nayr3169@hotmail.com");
		WebElement password = element.findElement(By.name("password"));
		password.sendKeys("123456");
		
		element.submit();
	}
	

}
