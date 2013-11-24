package org.project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.project.selenium.BaseTest;

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
	
	@Test
	public void addNewFolderTest() {
		WebElement viewFolderBtn = driver.findElement( By.id( "folder_toggle" ) );

		viewFolderBtn.click();
		
		WebElement addFolderBtn = driver.findElement( By.linkText( "Add" ) );
		
		addFolderBtn.click();
		
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		String folderTitle = "New Folder!"; 
		inputBox.sendKeys( folderTitle );
		
		WebElement createFolderBtn = driver.findElement( By.xpath("//input[@value='Create Folder']" ) );
		createFolderBtn.click();
		
		// check that folder has been created
		assertNotNull( driver.findElement( By.className( "folder_mode" ) ) );
		assertNotNull( driver.findElement( By.className( "has_folders" ) ) );
		assertNotNull( driver.findElement( By.linkText( folderTitle ) ) );
		WebElement editFolderBtn = driver.findElement( By.xpath( "//a[@title='Edit Folder']" ) );
		String folderId = editFolderBtn.getAttribute("href").substring(38);
		
		deleteFolder(folderId);
	}
	
	@Test 
	public void deleteFolderTest() {
		String id = addFolder("Delete This Folder");
		
		WebElement editBtn = driver.findElement( By.linkText( "Edit" ) );
		editBtn.click();
		WebElement deleteBtn = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id  +"']" ) );
		deleteBtn.click();
	}
	
	
	private String addFolder(String folderTitle) {
		WebElement viewFolderBtn = driver.findElement( By.id( "folder_toggle" ) );

		viewFolderBtn.click();
		
		WebElement addFolderBtn = driver.findElement( By.linkText( "Add" ) );
		
		addFolderBtn.click();
		
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		inputBox.sendKeys( folderTitle );
		
		WebElement createFolderBtn = driver.findElement( By.xpath("//input[@value='Create Folder']" ) );
		createFolderBtn.click();
		
		// check that folder has been created
		WebElement editFolderBtn = driver.findElement( By.xpath( "//a[@title='Edit Folder']" ) );
		String folderId = editFolderBtn.getAttribute("href").substring(38);
		
		return folderId;
	}
	
	private void deleteFolder(String id) {
		WebElement editBtn = driver.findElement( By.linkText( "Edit" ) );
		editBtn.click();
		WebElement deleteBtn = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id +"']" ) );
		deleteBtn.click();
	}
	
}
