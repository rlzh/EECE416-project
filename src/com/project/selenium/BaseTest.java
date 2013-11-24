package com.project.selenium;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void logIn() {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();

		WebElement newUsername = driver.findElement(By.id("username"));
		newUsername.sendKeys(username);
		WebElement newPassword = driver.findElement(By.id("password"));
		newPassword.sendKeys(password);

		WebElement register = driver.findElement(By.id("log_in"));
		register.click();
		
		// check page layout
		PageLayout();
	}
	
	public void createAccount(String username, String password) {
		
	}
	
	private void PageLayout() {
		// check for site header
		assertNotNull( driver.findElement( By.id( "header" ) ) );
		// check for navigation side bar
		assertNotNull( driver.findElement( By.id( "side_column" ) ) );
		// check for buttons in navigation side bar
		assertNotNull( driver.findElement( By.id( "user_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "like_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "arhcive_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "search_box" ) ) );
		assertNotNull( driver.findElement( By.id( "browse_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "save_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "user_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "like_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "like_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "like_nav" ) ) );
		// check for foot in navigation side bar
		assertNotNull( driver.findElement( By.linkText( "Help" ) ) );
		assertNotNull( driver.findElement( By.linkText( "Apps" ) ) );
		assertNotNull( driver.findElement( By.linkText( "API" ) ) );
		assertNotNull( driver.findElement( By.linkText( "Blog" ) ) );
		assertNotNull( driver.findElement( By.className( "icon-twitter" ) ) );
		assertNotNull( driver.findElement( By.className( "icon-facebook" ) ) );
		
		// check for main content
		assertNotNull( driver.findElement( By.id( "main_content" ) ) );
		// check for main content header
		assertNotNull( driver.findElement( By.className( "page_header" ) ) );
		// check for main content 
		assertNotNull( driver.findElement( By.id( "main_column" ) ) );
	}
}
