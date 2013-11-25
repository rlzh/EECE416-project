Feature: Manage Folder
In order to manage articles easier
As a user who uses Instapaper
I want to manage my articles using folders

Scenario: Creating new folder
	Given I am logged in my dummy account
	When I click the Folder Icon
	And I click Add Folder
	And I key in New Folder! as my folder name
	And I click Create Folder
	Then New Folder! is created
	
Scenario: Renaming folder
	Given I have a folder called Rename this folder!
	When I click on Edit to rename
	And I click on the Pencil icon
	And I key in Folder renamed as my new folder name
	Then my folder name is now Folder renamed

Scenario: Delete folder
	Given I have a folder called Delete this folder!
	When I click on Edit
	And I click on the X icon
	Then Delete this folder should be deleted
	
        
     