package com.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	private static final String url = "http://www.instapaper.com/";
	
	protected static WebDriver driver;
	
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();
		WebElement email = driver.findElement(By.id("username"));
		email.sendKeys("nayr3169@hotmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement signInBtn = driver.findElement(By.id("log_in"));
		signInBtn.click();
	}
	

}
