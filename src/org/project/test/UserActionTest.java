package org.project.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.project.selenium.BaseTest;

public class UserActionTest extends BaseTest {
	
	/**
	 * Log into the dummy account using the information in the BaseTest
	 * and go to the Unread tab
	 */
	@Before
	public void setUp() {
		super.setUp();
		logIn();
		
		WebElement unread = driver.findElement(By.id("unread_nav"));
		unread.click();
	}
	
	/**
	 * Like a page that is already added
	 */
	@Test
	public void likePageTest() {
		
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		// add a new article
		String id = addPage(url, title, summary);
		
		try {
			
			WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
			
			Actions builder = new Actions(driver); 
			Actions hoverOverRegistrar = builder.moveToElement(article);
			hoverOverRegistrar.perform();
			
			driver.findElement(By.xpath("//a[@href='" + "/star_toggle/"+id + "']")).click();
			
			driver.findElement(By.id("liked_nav")).click();
			
			removePage(id);
			
		} catch (Exception e) {
			fail();
		}
		
	}
	
	/**
	 * Edit information associated to the page
	 */
	@Test
	public void EditPageTest() {
		
	}
	
	/**
	 * Share the page through email
	 */
	@Test
	public void SharePageTest() {
		
	}
}
