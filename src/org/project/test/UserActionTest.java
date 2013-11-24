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
			
		} catch (Exception e) {
			fail();
		}
		
		WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
		
		Actions builder = new Actions(driver); 
		Actions hoverOverRegistrar = builder.moveToElement(article);
		hoverOverRegistrar.perform();
		
		
		
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
	
	/**
	 * Helper function to add new page into the account
	 * @param url
	 * @return the id of the article added
	 */
	private String addPage(String url, String title, String summary) {
		WebElement action = driver.findElement(By.xpath("//a[@title='Actions']"));
		action.click();
		
		WebElement add = driver.findElement(By.linkText("Add Article"));
		add.click();
		
		WebElement pageTitle = driver.findElement(By.className("page_title"));
		assertEquals(pageTitle.getText(), "Add Article");
		
		driver.findElement(By.id("bookmarkurl")).sendKeys(url);
		driver.findElement(By.id("bookmarktitle")).sendKeys(title);
		driver.findElement(By.id("bookmarkselection")).sendKeys(summary);
		
		driver.findElement(By.id("submit")).submit();
		
		WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
		String link = article.getAttribute("href");
		String[] split = link.split("/");
		
		return split[split.length-1];
	}
	
	/**
	 * Helper function to remove page
	 * @param url
	 */
	private void removePage(String url) {
		
	}
}
