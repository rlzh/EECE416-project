package org.project.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class ReadArticleTest extends BaseTest {

	@Before
	public void setUp() {
		super.setUp();
		super.logIn();
		WebElement UnreadNavBtn = driver.findElement( By.id( "unread_nav" ) );
		UnreadNavBtn.click();
	}
	
	@Test
	public void simpleReadTest() {
		try {
			WebElement articleLink = driver.findElements( By.className( "title_row" ) )
											.get(0)
											.findElement( By.xpath("./a") );
			String articleUrl = articleLink.getAttribute("href");
			
			articleLink.click();
			
			assertTrue( driver.getCurrentUrl().equals( articleUrl ) );
	
			CheckPageLayout();
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	
	/**
	 *  test font options 
	 * 
	 */
	@Test
	public void editFontTest() {
		goToFirstArticle();
		try {
			driver.findElement( By.className( "fontOptions" ) ).click();
			// Tisa font 
			driver.findElement( By.id("tisaChoice") ).click();
			assertNotNull( driver.findElement( By.className( "tisamode" ) ) );
			// Georgia font 
			driver.findElement( By.id("georgiaChoice") ).click();
			assertNotNull( driver.findElement( By.className( "georgiamode" ) ) );
			// Verdana
			driver.findElement( By.id("verdanaChoice") ).click();
			assertNotNull( driver.findElement( By.className( "verdanamode" ) ) );
			// Helvetica
			driver.findElement( By.id("helveticaChoice") ).click();
			assertNotNull( driver.findElement( By.className( "helveticamode" ) ) );
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}	
	}
	
	/**
	 *  test all font sizes
	 * 
	 */
	@Test
	public void fontSizeTest() {
		goToFirstArticle();
		try {
			driver.findElement( By.className( "fontOptions" ) ).click();
			WebElement incSizeBtn = driver.findElements( By.className( "optIncrease" ) ).get(0);
			WebElement decSizeBtn = driver.findElements( By.className( "optDecrease" ) ).get(0);
			// size 1
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size1mode" ) );	
			// size 2
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size2mode" ) );
			// size 3
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size3mode" ) );			
			// size 4
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size4mode" ) );	
			// size 5
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size5mode" ) );	
			// size 6
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "size6mode" ) );	
			// restore to size 1
			for(int i = 0; i < 6; i++) 	{ decSizeBtn.click(); }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	/**
	 * test all available margin sizes
	 * 
	 */
	@Test
	public void marginSizeTest() {
		goToFirstArticle();
		try {
			driver.findElement( By.className( "fontOptions" ) ).click();
			WebElement incSizeBtn = driver.findElements( By.className( "optIncrease" ) ).get(1);
			WebElement decSizeBtn = driver.findElements( By.className( "optDecrease" ) ).get(1);
			// wide mode
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "widemode" ) );	
			// medium width mode
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "mediumwidthmode" ) );
			// narrow mode
			incSizeBtn.click();
			assertNotNull( driver.findElement( By.xpath( "//body" ) )
								   .getAttribute("class")
								   .contains( "narrowmode" ) );			
			// restore to wide mode
			for(int i = 0; i < 3; i++) 	{ decSizeBtn.click(); }
			
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	/**
	 *  test background colors
	 */
	@Test
	public void backGroundColorTest() {
		goToFirstArticle();
		try {
			driver.findElement( By.className( "fontOptions" ) ).click();
			
			// Light background color
			driver.findElement( By.className("backgroundWhite") ).click();
			assertNotNull( driver.findElement( By.className( "lightmode" ) ) );
			// Sepia background color
			driver.findElement( By.className("backgroundSepia") ).click();
			assertNotNull( driver.findElement( By.className( "sepiamode" ) ) );
			// Dark background color
			driver.findElement( By.className("backgroundDark") ).click();
			assertNotNull( driver.findElement( By.className( "darkmode" ) ) );
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	/**
	 *  test going back to original article site
	 */
	@Test
	public void goToOriginalTest() {
		goToFirstArticle();
		try {
			WebElement originalLink = driver.findElement( By.xpath( "//a[@title='View Original']" ) );
			String originalUrl = originalLink.getAttribute("href");
			
			originalLink.click();
			
			assertTrue( driver.getCurrentUrl().equals(originalUrl) );
			
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	// helper function to go to article reading page
	private void goToFirstArticle() {
		driver.findElements( By.className( "title_row" ) )
				.get(0)
				.findElement( By.xpath("./a") )
				.click();		
	}
	
	// helper function to verify GUI presence
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
