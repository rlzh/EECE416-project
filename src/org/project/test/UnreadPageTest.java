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
	}
	
	@Test
	public void ReadArticleTest() {
		String articleTitle = "What the Xbox One tells us about 'the new Microsoft'";
		WebElement articleLink = driver.findElement( By.linkText( articleTitle ) );
		String articleUrl = articleLink.getAttribute("href");
		articleLink.click();
		assertTrue( driver.getCurrentUrl().equals( articleUrl ) );
		
	}
}
