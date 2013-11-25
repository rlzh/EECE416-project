Feature: ManageAccount
    In order to manage things easier
    As a user who uses Instapaper
    I want to manage my account

Scenario: Register for newDummy account
	Given I click Create Account
	And I entered my email newDummy@gmail.com as username
	And I entered 123456 as my password
	When I click Create Account
	Then I should be logged in as newDummy

Scenario: Logging into dummy account
	Given I have entered my email dummy@gmail.com as username
	And I have entered 123456 as my password
	When I click Sign In
	Then I should be able to see the pages I added into my account
	
Scenario: Sign out of dummy account
	Given I am logged in as dummy
	When I click on my profile setting
	And I click on Sign Out icon
	Then I should be signed out
	
Scenario: Delete newDummy account
	Given I created newDummy account
	And I am logged in as newDUmmy
	And I click my profile setting
	When I click Delete My Account
	And confirmed the deletion
	Then I should be signed out
	And a confirmation message should be printed out






        