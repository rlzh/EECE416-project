package org.project.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.project.selenium.BaseTest;

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
	public void editArticleTest() {

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
			
			driver.findElement(By.id("unread_nav")).click();
			
			removePage(id, newTitle);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
	
	/**
	 *  test archive all function
	 * 
	 */
	@Test 
	public void archiveAllArticleTest() {
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		String articleId = addPage(url, title, summary);
		try {
			String folderName = movePageToFolder(title);

			driver.findElement( By.id( "folder_toggle" ) ).click();
			driver.findElement( By.linkText( folderName ) ).click();
			driver.findElement( By.linkText( folderName ) ).click(); // <----- NEED 2 CLICKS FOR LINK TO WORK

			driver.findElement( By.xpath( "//a[@title='Actions']" ) ).click();
			driver.findElement( By.id( "archive_all" ) ).click();
			driver.switchTo().alert().accept();
					
			driver.findElement( By.id( "archive_nav" ) ).click();
			
			assertNotNull( driver.findElement( By.linkText( title ) ) );
			
			removePage(articleId, title);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}

	}
	
	/**
	 *  test unarchiving an article
	 * 
	 */
	@Test
	public void unarchiveArticleTest() {
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		String articleId = addPage(url, title, summary);
		try {
			Actions builder = new Actions(driver);
			WebElement article = driver.findElement( By.xpath( "//a[@title='" + title +"']" ) );
			builder.moveToElement(article).perform();
			
			driver.findElement( By.id( "skip"+articleId ) ).click();
			
			driver.findElement( By.id( "archive_nav" ) ).click();
			
			builder = new Actions(driver);
			article = driver.findElement( By.xpath( "//a[@title='" + title +"']" ) );
			builder.moveToElement(article).perform();
			
			driver.findElement( By.id( "unread"+articleId ) ).click();
			
			driver.findElement( By.id( "unread_nav" ) ).click();
			
			assertNotNull( driver.findElement( By.xpath( "//a[@title='" + title +"']" ) ) );
			
			removePage(articleId, title);

		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
		
	}
	
	/**
	 *  test unliking an article
	 * 
	 */
	@Test
	public void unlikeArticleTest() {
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		String id = addPage(url, title, summary);
		try {
			WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));

			Actions builder = new Actions(driver); 
			Actions hoverOverRegistrar = builder.moveToElement(article);
			hoverOverRegistrar.perform();

			driver.findElement(By.xpath("//a[@href='" + "/star_toggle/"+id + "']")).click();
			
			driver.findElement(By.id("liked_nav")).click();
			
			article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
			builder = new Actions(driver); 
			hoverOverRegistrar = builder.moveToElement(article);
			hoverOverRegistrar.perform();
			
			driver.findElement(By.xpath("//a[@href='" + "/star_toggle/"+id + "']")).click();

			article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));

			assertFalse( article.getAttribute("class").contains("starred") );
			
			removePage(id, title);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
}
