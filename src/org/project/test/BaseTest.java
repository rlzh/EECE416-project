package org.project.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.SeleneseTestBase;

public abstract class BaseTest extends SeleneseTestBase {
	
	private static final String url = "http://tinypic.com/";
	
	protected static WebDriver driver;
	
	protected BaseTest() {
		super();
		driver = new FirefoxDriver();
		driver.get(url);
		assertEquals("TinyPic - Free Image Hosting, Photo Sharing & Video Hosting", driver.getTitle());
	}
	
	protected abstract boolean testPassed();

}
