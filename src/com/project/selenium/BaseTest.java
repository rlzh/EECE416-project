package com.project.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public void closeFirefox() {
		driver.close();
	}
	

}
