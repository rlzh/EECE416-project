package org.project.selenium;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {
	
	protected WebDriver driver;
	protected static final String url = "http://www.instapaper.com/";
	protected static final String username = "dummy@gmail.com";
	protected static final String password = "123456";
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@After
	public void closeFirefox() {
		driver.quit();
	}
	
	public void logIn() {
		WebElement signIn = driver.findElement(By.linkText("Sign In"));
		signIn.click();

		WebElement newUsername = driver.findElement(By.id("username"));
		newUsername.sendKeys(username);
		WebElement newPassword = driver.findElement(By.id("password"));
		newPassword.sendKeys(password);

		WebElement signInBtn = driver.findElement(By.id("log_in"));
		signInBtn.click();
		
		// check page layout
		checkPageLayout();
	}
	
	private void checkPageLayout() {
		// check for site header
		assertNotNull( driver.findElement( By.id( "header" ) ) );
		// check for navigation side bar
		assertNotNull( driver.findElement( By.id( "side_column" ) ) );
		// check for buttons in navigation side bar
		assertNotNull( driver.findElement( By.id( "unread_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "liked_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "archive_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "search_box" ) ) );
		assertNotNull( driver.findElement( By.id( "browse_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "save_nav" ) ) );
		assertNotNull( driver.findElement( By.id( "user_nav" ) ) );
		// check for foot in navigation side bar
		assertNotNull( driver.findElement( By.linkText( "Help" ) ) );
		assertNotNull( driver.findElement( By.linkText( "Apps" ) ) );
		assertNotNull( driver.findElement( By.linkText( "API" ) ) );
		assertNotNull( driver.findElement( By.linkText( "Blog" ) ) );
		assertNotNull( driver.findElement( By.className( "icon-twitter" ) ) );
		assertNotNull( driver.findElement( By.className( "icon-facebook" ) ) );
		
		// check for main content
		assertNotNull( driver.findElement( By.id( "main_content" ) ) );
		// check for main content header
		assertNotNull( driver.findElement( By.className( "page_header" ) ) );
		// check for main content 
		assertNotNull( driver.findElement( By.id( "main_column" ) ) );
	}
	
	/**
	 * Helper function to add new page into the account
	 * @param url
	 * @return the id of the article added
	 */
	protected String addPage(String url, String title, String summary) {
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
		
		WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
		String link = article.getAttribute("href");
		String[] split = link.split("/");
		
		return split[split.length-1];
	}
	
	/**
	 * Helper function to remove page
	 * @param id
	 */
	protected void removePage(String id) {
		
		driver.findElement(By.xpath("//a[@href='" + "/delete/"+id + "']")).click();
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Helper function to remove page
	 * @param id
	 * @param title
	 */
	protected void removePage(String id, String title) {
		Actions builder = new Actions(driver); 
		WebElement added = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
		builder.moveToElement(added).perform();
		removePage(id);
	}
	
	
	/**
	 * add folder helper function
	 * @param folderTitle
	 * @return returns id of added folder
	 */
	protected String addFolder(String folderTitle) {
		driver.findElement( By.id( "folder_toggle" ) ).click();
		
		driver.findElement( By.linkText( "Add" ) ).click();
		
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		inputBox.sendKeys( folderTitle );
		
		WebElement createFolderBtn = driver.findElement( By.xpath("//input[@value='Create Folder']" ) );
		createFolderBtn.click();
		
		// check that folder has been created
		WebElement editFolderBtn = driver.findElement( By.xpath( "//a[@title='Edit Folder']" ) );
		String folderId = editFolderBtn.getAttribute("href").substring(38);
		
		return folderId;
	}
	
	/**
	 * delete folder helper function
	 * @param id of folder to be deleted
	 */
	
	protected void deleteFolder(String id) {
		WebElement editBtn = driver.findElement( By.linkText( "Edit" ) );
		editBtn.click();
		WebElement deleteBtn = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id +"']" ) );
		deleteBtn.click();
	}

	/**
	 *  takes page title and moves page to top folder in folder list
	 * @param pageTitle
	 * @return returns name of folder moved to
	 */
	protected String movePageToFolder(String pageTitle) {
		Actions builder = new Actions(driver);
		WebElement article = driver.findElement( By.xpath( "//a[@title='" + pageTitle +"']" ) );
		builder.moveToElement(article).perform();
		
		driver.findElement( By.linkText( "move" ) ).click();

		WebElement folder = driver.findElements( By.className( "moveTo" ) ).get(0);
		String folderName = folder.getText();
		folder.click();
		
		return folderName;
	}
}
