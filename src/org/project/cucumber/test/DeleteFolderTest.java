package org.project.cucumber.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteFolderTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private String folderTitle = "Delete this folder!";
	private String folderId;
	
	@Given("^I have a folder called Delete this folder!$")
	public void I_have_a_folder_called() throws Throwable {
	    folderId = addFolder(folderTitle);
	}
	
	@When("^I click on Edit$")
	public void I_click_on_Edit() throws Throwable {WebElement edit = driver.findElement( By.linkText( "Edit" ) );
	assertNotNull(edit);
	edit.click();
	}

	@When("^I click on the X icon$")
	public void I_click_on_the_icon() throws Throwable {
		WebElement icon = driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ folderId  +"']" ) );
		assertNotNull(icon);
		icon.click();
	}

	@Then("^Delete this folder should be deleted$")
	public void the_should_be_deleted() throws Throwable {
		try {
			driver.findElement( By.xpath( "//a[@href='/delete_folder?folder="+ folderId  +"']" ) );
			fail();
		} catch (Exception e) {
			
		}	    
	    driver.quit();
	}
	
	/**
	 * add folder helper function
	 * @param folderTitle
	 * @return returns id of added folder
	 */
	private String addFolder(String folderTitle) {
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

}
