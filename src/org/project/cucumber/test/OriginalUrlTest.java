package org.project.cucumber.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OriginalUrlTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private static String url = "http://www.engadget.com/";
	private static String title = "Engadget";
	private static String summary = "Engadget website";
	private static String id;
	
	@Given("^I am reading Engadget on my account$")
	public void I_am_reading_Engadget_on_my_account() throws Throwable {
		id = driver.addPage(url, title, summary);
		assertNotNull( driver.findElement( By.xpath("//a[@title='" + title + "']") ) );
		driver.findElement( By.xpath("//a[@title='" + title + "']") ).click();
	}

	@When("^I click on the Globe icon$")
	public void I_click_on_the_Globe_icon() throws Throwable {
		assertNotNull( driver.findElement( By.xpath( "//a[@title='View Original']" ) ) );
		driver.findElement( By.xpath( "//a[@title='View Original']" ) ).click();
	}

	@Then("^I should be at Engadget's original website with url http://www.engadget.com$")
	public void I_should_be_at_Engadget_s_original_website_with_url_http_www_engadget_com() throws Throwable {
	   assertEquals(driver.getCurrentUrl(), url);
	   driver.get(driver.getUrl());
	   driver.removePage(id, title);
	   driver.quit();
	}

}
