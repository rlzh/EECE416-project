package org.project.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class UserOrganizeTest extends BaseTest{
	@Before
	public void setUp() {
		super.setUp();
		logIn();
		WebElement UnreadNavBtn = driver.findElement( By.id( "unread_nav" ) );
		UnreadNavBtn.click();
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
	
	/*@Test 
	public void deleteFolderTest() {
		
		String id = addFolder("Delete This Folder");
		
		WebElement editBtn = driver.findElement( By.linkText( "Edit" ) );
		editBtn.click();
		WebElement deleteBtn = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id  +"']" ) );
		deleteBtn.click();
		
	}*/
	
	
	private String addFolder(String folderTitle) {
		WebElement addFolderBtn = driver.findElement( By.id( "add_folder" ) );
		String addFolderUrl = addFolderBtn.getAttribute("href");

		addFolderBtn.click();
		
		assertTrue( driver.getCurrentUrl().equals(addFolderUrl) );
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		inputBox.sendKeys( folderTitle );
		
		WebElement createFolderBtn = driver.findElement( By.xpath("//input[@value='Create Folder']" ) );
		createFolderBtn.click();
		
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
