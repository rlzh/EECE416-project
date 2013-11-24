package org.project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.project.selenium.BaseTest;

public class BrowseArticleTest extends BaseTest {
	
	@Before
	public void setUp() {
		super.setUp();
		logIn();
		WebElement browseNavBtn = driver.findElement( By.id( "browse_nav" ) );
		browseNavBtn.click();
	}
	
	@Test
	public void readArticleNowTest() {
		try {
			List<WebElement> stories = driver.findElements( By.cssSelector( ".headline" ) );
			WebElement story = stories.get(0);		
			WebElement storyLink = story.findElement( By.xpath( "./a" ) );
			String storyUrl = storyLink.getAttribute("href");
			
			storyLink.click();

			assertTrue( driver.getCurrentUrl().equals(storyUrl) );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void readArticleLaterTest() {
		try {
			List<WebElement> stories = driver.findElements( By.cssSelector( ".headline" ) );
			WebElement story = stories.get(0);		
			WebElement storyLink = story.findElement( By.xpath( "./a" ) );
			String storyTitle = storyLink.getAttribute("title");
			
			List<WebElement> links = driver.findElements( By.className( "bookmarklet" ) );
			WebElement readLaterLink = links.get(0);
			
			readLaterLink.click();
			
			driver.findElement( By.id( "unread_nav" ) ).click();
			
			WebElement article = driver.findElement( By.xpath( "//a[@title='"+ storyTitle + "']" ) );
			assertNotNull( article );
			
			String articleId = article.getAttribute("href").substring(31);
			System.out.println(articleId);
			
			super.removePage(articleId, storyTitle);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
		
	}

}
