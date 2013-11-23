package com.project.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	protected static WebDriver driver;
	protected static final String url = "http://www.instapaper.com/";
	protected static final String username = "dummy@gmail.com";
	protected static final String password = "123456";
	
	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@AfterClass
	public static void closeFirefox() {
		driver.close();
	}
	
	public void logIn(String username, String password) {
		
	}
	
	public void createAccount(String username, String password) {
		
	}

}
