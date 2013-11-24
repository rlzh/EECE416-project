package org.project.cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InstapaperDriver extends FirefoxDriver {

	private static final String url = "http://www.instapaper.com/";
	private static final String username = "dummy@gmail.com";
	private static final String password = "123456";
	
	public InstapaperDriver(boolean loggedIn) {
		super();
		get(url);
		if (loggedIn) logIn();
	}
	
	private void logIn() {
		WebElement signIn = findElement(By.linkText("Sign In"));
		signIn.click();

		WebElement newUsername = findElement(By.id("username"));
		newUsername.sendKeys(username);
		WebElement newPassword = findElement(By.id("password"));
		newPassword.sendKeys(password);

		WebElement signInBtn = findElement(By.id("log_in"));
		signInBtn.click();
	}
	
	 /** Helper function to add new page into the account
	 * @param url
	 * @return the id of the article added
	 */
	public String addPage(String url, String title, String summary) {
		WebElement action = findElement(By.xpath("//a[@title='Actions']"));
		action.click();
		
		WebElement add = findElement(By.linkText("Add Article"));
		add.click();
		
		WebElement pageTitle = findElement(By.className("page_title"));
		assertEquals(pageTitle.getText(), "Add Article");
		
		findElement(By.id("bookmarkurl")).sendKeys(url);
		findElement(By.id("bookmarktitle")).sendKeys(title);
		findElement(By.id("bookmarkselection")).sendKeys(summary);
		
		findElement(By.id("submit")).submit();
		
		WebElement article = findElement(By.xpath("//a[@title='"+ title + "']"));
		String link = article.getAttribute("href");
		String[] split = link.split("/");
		
		return split[split.length-1];
	}
	

}
