package org.project.cucumber.test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddArticleTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private static String url = "http://www.engadget.com/";
	private static String title = "Engadget";
	private static String summary = "Engadget website";
	private static String id;
	
	@Given("^I am at the Add Article Page$")
	public void I_am_at_the_Add_Article_Page() throws Throwable {
		try {
			assertNotNull( driver.findElement(By.xpath("//a[@title='Actions']")) );
			driver.findElement(By.xpath("//a[@title='Actions']")).click();
			
			assertNotNull( driver.findElement(By.linkText("Add Article")) );
			driver.findElement(By.linkText("Add Article")).click();
			
			WebElement pageTitle = driver.findElement(By.className("page_title"));
			assertEquals(pageTitle.getText(), "Add Article");
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	@Given("^I have entered http://www.engadget.com/ as the website URL$")
	public void I_have_entered_http_www_engadget_com_as_the_website_URL() throws Throwable {
	    try {
	    	assertNotNull( driver.findElement(By.id("bookmarkurl")));
			driver.findElement(By.id("bookmarkurl")).sendKeys(url);
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}

	@Given("^I have entered Engadget as the website title$")
	public void I_have_entered_Engadget_as_the_website_title() throws Throwable {
		try {
			assertNotNull( driver.findElement(By.id("bookmarktitle")));
			driver.findElement(By.id("bookmarktitle")).sendKeys(title);
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}

	@Given("^I have entered Engadget Summary as the website summary$")
	public void I_have_entered_Engadget_Summary_as_the_website_summary() throws Throwable {
		try {
			assertNotNull( driver.findElement(By.id("bookmarkselection")));
			driver.findElement(By.id("bookmarkselection")).sendKeys(summary);
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}

	@When("^I click Add Article$")
	public void I_click_Add_Article() throws Throwable {
		try {
			assertNotNull( driver.findElement(By.id("submit")) );
			driver.findElement(By.id("submit")).submit();
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
	
	@Then("^Engadget should be added into my Unread List$")
	public void Engadget_should_be_added_into_my_Unread_List() throws Throwable {
		try {
			assertNotNull( driver.findElement( By.xpath("//a[@title='" + title + "']") ) );
			// remove page
			WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));
			String link = article.getAttribute("href");
			String[] split = link.split("/");
			id = split[split.length-1];
			
			driver.removePage(id, title);
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
}
