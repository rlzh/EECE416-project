Feature: Add Article
    In order to manage things easier
    As a user who uses Internet
    I want to add an article into my account

    Scenario: Adding Engadget into my account
        Given I am at the Add Article Page
        And I have entered http://www.engadget.com/ as the website URL
        And I have entered Engadget as the website title
        And I have entered Engadget Summary as the website summary
        When I click Add Article
        Then Engadget should be added into my Unread List