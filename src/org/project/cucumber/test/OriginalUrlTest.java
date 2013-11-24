package org.project.cucumber.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OriginalUrlTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	
	@Given("^I am reading Engadget on my account$")
	public void I_am_reading_Engadget_on_my_account() throws Throwable {
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
		} catch(Exception e) {
			
		}
	}

	@When("^I click on the Globe icon$")
	public void I_click_on_the_Globe_icon() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should be at Engadget's original website with url http://www.engadget.com$")
	public void I_should_be_at_Engadget_s_original_website_with_url_http_www_engadget_com() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
