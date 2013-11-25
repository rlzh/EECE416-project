package org.project.cucumber.test;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.project.cucumber.InstapaperDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RenameFolderTest {
	
	private InstapaperDriver driver = new InstapaperDriver(true);
	private String id;
	private String newName = "Folder renamed";
	
	@Given("^I have a folder called Rename this folder!$")
	public void I_have_a_folder_called_Rename_this_folder() throws Throwable {
		id = addFolder( "Rename This Folder" );
	}

	@When("^I click on Edit to rename$")
	public void I_click_on_Edit() throws Throwable {
		WebElement edit = driver.findElement( By.linkText( "Edit" ) );
		assertNotNull(edit);
		edit.click();
	}

	@When("^I click on the Pencil icon$")
	public void I_click_on_the_Pencil_icon() throws Throwable {
	    WebElement pencil = driver.findElement( By.xpath( "//a[@href='/edit_folder/"+ id  +"']" ) );
	    assertNotNull(pencil);
	    pencil.click();
	}

	@When("^I key in Folder renamed as my new folder name$")
	public void I_key_in_Folder_renamed_as_my_new_folder_name() throws Throwable {
		WebElement input = driver.findElement( By.id( "foldertitle" ) );
		assertNotNull(input);
		input.clear();
		input.sendKeys(newName);
		driver.findElement( By.xpath( "//input[@type='submit']" ) ).click();
	}

	@Then("^my folder name is now Folder renamed$")
	public void my_folder_name_is_now_Folder_renamed() throws Throwable {
		assertNotNull( driver.findElement( By.linkText( newName ) ) );
		
		deleteFolder(id);
		driver.quit();
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
