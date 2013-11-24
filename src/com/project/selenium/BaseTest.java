package com.project.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	protected WebDriver driver;
	protected static final String url = "http://www.instapaper.com/";
	protected static final String username = "dummy@gmail.com";
	protected static final String password = "123456";
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@After
	public void closeFirefox() {
		driver.close();
	}
	
	public void logIn(String username, String password) {
		
	}
	
	public void createAccount(String username, String password) {
		
	}

}
