package org.project.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class ReadArticleTest extends BaseTest {

	@Before
	public void SetUp() {
		super.logIn();

	}
	
	@Test
	public void SimpleReadTest() {
		WebElement UnreadNavBtn = driver.findElement( By.id( "unread_nav" ) );
		UnreadNavBtn.click();
		
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
