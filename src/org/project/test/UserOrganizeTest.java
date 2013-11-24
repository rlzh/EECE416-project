package org.project.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.project.selenium.BaseTest;

public class UserOrganizeTest extends BaseTest{
	@Before
	public void SetUp() {
		super.logIn();
	}
	
	@Test
	public void AddFolderTest() {
		WebElement addFolderBtn = driver.findElement( By.id( "add_folder" ) );
		String addFolderUrl = addFolderBtn.getAttribute("href");

		addFolderBtn.click();
		
		assertTrue( driver.getCurrentUrl().equals(addFolderUrl) );
		WebElement inputBox = driver.findElement( By.id( "foldertitle" ) );
	}
	
}
