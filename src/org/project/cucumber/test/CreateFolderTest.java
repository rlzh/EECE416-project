package org.project.cucumber.test;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateFolderTest {

	private InstapaperDriver driver = new InstapaperDriver(true);
	private String folderTitle = "New Folder!"; 
	
	@Given("^I am logged in my dummy account$")
	public void I_am_logged_in_my_dummy_account() throws Throwable {
		assertNotNull( driver.findElement( By.id( "user_nav" ) ) );
	}

	@When("^I click the Folder Icon$")
	public void I_click_the_Folder_Icon() throws Throwable {
		WebElement icon = driver.findElement( By.id( "folder_toggle" ) );
		assertNotNull(icon);
		icon.click();
	}

	@When("^I click Add Folder$")
	public void I_click_Add_Folder() throws Throwable {
		WebElement add = driver.findElement( By.linkText( "Add" ) );
		assertNotNull(add);
		add.click();
	}

	@When("^I key in New Folder! as my folder name$")
	public void I_key_in_as_my_folder_name() throws Throwable {
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
		assertNotNull(inputBox);
		inputBox.sendKeys( folderTitle );
	}

	@When("^I click Create Folder$")
	public void I_click_Create_Folder() throws Throwable {
		WebElement confirm = driver.findElement( By.xpath("//input[@value='Create Folder']" ) );
		confirm.click();
	}

	@Then("^New Folder! is created$")
	public void is_created() throws Throwable {
		assertNotNull( driver.findElement( By.className( "folder_mode" ) ) );
		assertNotNull( driver.findElement( By.className( "has_folders" ) ) );
		assertNotNull( driver.findElement( By.linkText( folderTitle ) ) );
		WebElement editFolderBtn = driver.findElement( By.xpath( "//a[@title='Edit Folder']" ) );
		String folderId = editFolderBtn.getAttribute("href").substring(38);
		
		deleteFolder(folderId);
	    driver.quit();
	}
	
	/**
	 * delete folder helper function
	 * @param id of folder to be deleted
	 */
	
	private void deleteFolder(String id) {
		WebElement editBtn = driver.findElement( By.linkText( "Edit" ) );
		editBtn.click();
		WebElement deleteBtn = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ id +"']" ) );
		deleteBtn.click();
	}
	
}
