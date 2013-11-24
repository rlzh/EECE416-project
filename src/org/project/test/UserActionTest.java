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
	public void likeArticleTest() {

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

	@Test
	public void archiveArticleTest() {

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

			driver.findElement(By.xpath("//a[@href='" + "/skip/"+id + "']")).click();

			driver.findElement(By.id("archive_nav")).click();

			removePage(id);


		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Edit information associated to the page
	 */
	@Test
	public void editPageTest() {

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

			driver.findElement(By.xpath("//a[@href='" + "/edit/"+id + "']")).click();
			
			String newUrl = "http://www.newurl.com/";
			String newTitle = "New Title";
			String newSummary = "New Summary";
			
			WebElement oriUrl = driver.findElement(By.id("bookmarkurl"));
			oriUrl.clear();
			oriUrl.sendKeys(newUrl);
			
			WebElement oriTitle = driver.findElement(By.id("bookmarktitle"));
			oriTitle.clear();
			oriTitle.sendKeys(newTitle);
			
			WebElement oriSummary = driver.findElement(By.id("bookmarkselection"));
			oriSummary.clear();
			oriSummary.sendKeys(newSummary);
			
			driver.findElement(By.id("submit")).submit();
			
			WebElement modifiedArticle = driver.findElement(By.xpath("//a[@title='"+ newTitle + "']"));
			hoverOverRegistrar = builder.moveToElement(modifiedArticle);
			hoverOverRegistrar.perform();
			
			driver.findElement(By.xpath("//a[@href='" + "/edit/"+id + "']")).click();
			
			String resultUrl = driver.findElement(By.id("bookmarkurl")).getAttribute("value");
			String resultTitle = driver.findElement(By.id("bookmarktitle")).getAttribute("value");
			String resultSummary = driver.findElement(By.id("bookmarkselection")).getAttribute("value");
			
			assertEquals(newUrl, resultUrl);
			assertEquals(newTitle, resultTitle);
			assertEquals(newSummary, resultSummary);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
