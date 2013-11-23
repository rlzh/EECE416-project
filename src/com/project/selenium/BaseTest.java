package com.project.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
	
	private SeleniumDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
	}
	
	@AfterClass
	public void closeFirefox() {
		driver.close();
	}
	

}
