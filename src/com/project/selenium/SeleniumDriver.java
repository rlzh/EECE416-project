package com.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SeleniumDriver {
	
	private static final String url = "http://www.instapaper.com/";
	private static final String username = "dummy";
	private static final String password = "123456";
	
	private WebDriver driver;
	
	public SeleniumDriver() {
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	public void logIn() {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();
		
		
		WebElement element = driver.findElement(By.name("signinForm"));
		WebElement email = element.findElement(By.name("email"));
		email.sendKeys("nayr3169@hotmail.com");
		WebElement password = element.findElement(By.name("password"));
		password.sendKeys("123456");
		
		element.submit();
	}
	
	
	
	public void close() {
		driver.close();
	}
	
}
