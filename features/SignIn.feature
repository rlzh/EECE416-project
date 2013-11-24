Feature: Sign In
    In order to manage things easier
    As a user who uses Internet
    I want to view the articles I added into my account

    Scenario: Logging into dummy account
        Given I have entered my email dummy@gmail.com as username
        And I have entered 123456 as my password
        When I click Sign In
        Then I should be able to see the pages I added into my account






        