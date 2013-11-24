package org.project.test;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class UnreadPageTest extends BaseTest {
	
	@Before
	public void SetUp() {
		super.logIn();
		WebElement UnreadNavBtn = driver.findElement( By.id( "unread_nav" ) );
		UnreadNavBtn.click();
	}
	
	@Test
	public void AddFolderTest() {
		WebElement addFolderBtn = driver.findElement( By.id( "add_folder" ) );
		String addFolderUrl = addFolderBtn.getAttribute("href");

		addFolderBtn.click();
		
		assertTrue( driver.getCurrentUrl().equals(addFolderUrl) );
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
	}
	
	@Test
	public void ReadArticleTest() {
		String articleTitle = "What the Xbox One tells us about 'the new Microsoft'";
		WebElement articleLink = driver.findElement( By.linkText( articleTitle ) );
		String articleUrl = articleLink.getAttribute("href");
		
		articleLink.click();
		
		assertTrue( driver.getCurrentUrl().equals( articleUrl ) );
		CheckPageLayout();
	}
	
	private void CheckPageLayout() {
		assertNotNull( driver.findElement( By.id("titlebar") ) );
		assertNotNull( driver.findElement( By.id("story") ) );
		assertNotNull( driver.findElement( By.id("footer") ) );
		assertNotNull( driver.findElement( By.className("icon-globe") ) );
		assertNotNull( driver.findElement( By.className("menuContainer") ) );
		assertNotNull( driver.findElement( By.className("icon-like") ) );
		assertNotNull( driver.findElement( By.className("deleteButton") ) );
		assertNotNull( driver.findElement( By.className("archiveButton") ) );
		assertNotNull( driver.findElement( By.className("shareOptions") ) );
	}
}
