package org.project.cucumber;

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
	

}
