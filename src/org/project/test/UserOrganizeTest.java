package org.project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.project.selenium.BaseTest;

public class UserOrganizeTest extends BaseTest{
	@Before
	public void setUp() {
		super.setUp();
		logIn();
		WebElement UnreadNavBtn = driver.findElement( By.id( "unread_nav" ) );
		UnreadNavBtn.click();
	}
	
	/**
	 * Test adding a new article
	 */
	@Test
	public void addNewArticleTest() {
		
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		try {
			
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
			
			Actions builder = new Actions(driver); 
			WebElement added = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
			String link = added.getAttribute("href");
			String[] split = link.split("/");
			String id = split[split.length-1];
			builder.moveToElement(added).perform();
			
			removePage(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
		
		
	}
	
	/**
	 * Test deleting an article
	 */
	@Test
	public void deleteArticleTest() {
		
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		// add a new article
		String id = addPage(url, title, summary);
		
		try {
			
			Actions builder = new Actions(driver); 
			WebElement added = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
			builder.moveToElement(added).perform();
			
			driver.findElement(By.xpath("//a[@href='" + "/delete/"+id + "']")).click();
			driver.switchTo().alert().accept();
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	/**
	 *  move article to an existing folder
	 * 
	 */
	@Test
	public void moveArticleTest() {
		
		String url = "http://www.engadget.com/";
		String title = "Engadget";
		String summary = "Engadget website";
		
		// add a new article
		String id = addPage(url, title, summary);
		
		Actions builder = new Actions(driver);
		WebElement article = driver.findElement( By.xpath( "//a[@title='" + title +"']" ) );
		builder.moveToElement(article).perform();
		
		driver.findElement( By.linkText( "move" ) ).click();

		WebElement folder = driver.findElements( By.className( "moveTo" ) ).get(0);
		String folderName = folder.getText();
		
		folder.click();

		driver.findElement( By.id( "folder_toggle" ) ).click();
		driver.findElement( By.linkText( folderName ) ).click();
		driver.findElement( By.linkText( folderName ) ).click(); // <----- BUG: NEED 2 CLICKS FOR LINK TO WORK

		assertNotNull( driver.findElement( By.linkText( title ) ) );
		
		super.removePage(id, title);
	}
	
	
	/**
	 *  test adding a new folder
	 * 
	 */
	
	@Test
	public void addNewFolderTest() {
		driver.findElement( By.id( "folder_toggle" ) ).click();
		driver.findElement( By.linkText( "Add" ) ).click();
		
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		String folderTitle = "New Folder!"; 
		inputBox.sendKeys( folderTitle );
		
		driver.findElement( By.xpath("//input[@value='Create Folder']" ) ).click();
		
		// check that folder has been created
		assertNotNull( driver.findElement( By.className( "folder_mode" ) ) );
		assertNotNull( driver.findElement( By.className( "has_folders" ) ) );
		assertNotNull( driver.findElement( By.linkText( folderTitle ) ) );
		WebElement editFolderBtn = driver.findElement( By.xpath( "//a[@title='Edit Folder']" ) );
		String folderId = editFolderBtn.getAttribute("href").substring(38);
		
		deleteFolder(folderId);
	}
	
	/**
	 *  test deleting a folder
	 * 
	 */
	@Test 
	public void deleteFolderTest() {
		String id = addFolder("Delete This Folder");
		driver.findElement( By.linkText( "Edit" ) ).click();
		driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id  +"']" ) ).click();
		try {
			driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id  +"']" ) );
			fail();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 *  test renaming a folder
	 * 
	 */
	@Test 
	public void renameFolderTest() {
		String id = addFolder( "Rename This Folder" );
		
		try {
			String newFolderTitle = "New Folder Name";
			driver.findElement( By.linkText( "Edit" ) ).click();
			driver.findElement( By.xpath( "//a[@href='/edit_folder/"+ id  +"']" ) ).click();
			WebElement input = driver.findElement( By.id( "foldertitle" ) );
			input.clear();
			input.sendKeys( newFolderTitle );
			driver.findElement( By.xpath( "//input[@type='submit']" ) ).click();
			
			assertNotNull( driver.findElement( By.linkText( newFolderTitle ) ) );
			
			deleteFolder(id);
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}

	}
	
	/**
	 * test delete all 
	 * 
	 */
	@Test
	public void deleteAllArticleTest() {
		String url1 = "http://www.engadget.com/";
		String title1 = "Engadget";
		String summary1 = "Engadget website";
		String id1 = addPage(url1, title1, summary1);
		
		String url2 = "http://www.bleacherreport.com/";
		String title2 = "Bleacher Report";
		String summary2 = "Sports news";
		String id2 = addPage(url2, title2, summary2);
		
		Actions builder = new Actions(driver);
		WebElement article1 = driver.findElement( By.xpath( "//a[@title='" + title1 +"']" ) );
		builder.moveToElement(article1).perform();
		
		driver.findElement( By.id( "skip"+id1 ) ).click();
		
		WebElement article2 = driver.findElement( By.xpath( "//a[@title='" + title2 +"']" ) );
		builder.moveToElement(article2).perform();
		
		driver.findElement(By.id( "skip"+id2 ) ).click();

		try {
			driver.findElement( By.id( "archive_nav" ) ).click();
			
			driver.findElement( By.xpath( "//a[@title='Actions']" ) ).click();
			driver.findElement( By.id( "delete_all" ) ).click();
			driver.switchTo().alert().accept();
			assertNull( driver.findElement( By.className( "article_item" ) ) );
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			
		}

	}
}
