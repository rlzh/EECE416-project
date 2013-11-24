package org.project.cucumber.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LikeArticleTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private String url = "http://www.engadget.com/";
	private String title = "Engadget";
	private String summary = "Engadget website";
	private String id;
	
	@Given("^I added Engadget into my account$")
	public void I_added_Engadget_into_my_account() throws Throwable {
		id =driver.addPage(url, title, summary);
	}

	@When("^I click the Heart icon$")
	public void I_click_the_Heart_icon() throws Throwable {
		WebElement article = driver.findElement(By.xpath("//a[@title='"+ title + "']"));

		Actions builder = new Actions(driver); 
		Actions hoverOverRegistrar = builder.moveToElement(article);
		hoverOverRegistrar.perform();

		driver.findElement(By.xpath("//a[@href='" + "/star_toggle/"+id + "']")).click();
	}

	@Then("^Engadget should be liked and shows up in my Liked page$")
	public void Engadget_should_be_liked_and_shows_up_in_my_Liked_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
