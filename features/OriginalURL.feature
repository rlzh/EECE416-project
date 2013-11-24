Feature: Original URL
    In order to go back to the original website
    As a user who wants to read more from the same website
    I want to go back to the original website I got the article from

    Scenario: Going back to Engadget's original website
        Given I am reading Engadget on my account
        When I click on the Globe icon
        Then I should be at Engadget's original website with url http://www.engadget.com
        
        