Feature: Instapaper Account
    In order to manage things easier
    As a user who uses Internet
    I want to view the articles I added into my account

    Scenario: Logging into dummy account
        Given I have entered my email dummy@gmail.com as username
        And I have entered 123456 as my password
        When I click Sign In
        Then I should be able to see the pages I added into my account

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

Feature: Organizing Articles
    In order to organize my articles
    As a user who added a lot of articles
    I want to like an article

    Scenario: Liking Engadget article
        Given I added Engadget into my account
        And I liked the Engadget article
        When I click the Heart icon
        Then Engadget should be liked and shows up in my Liked page

Feature: Store the website's original url
    In order to go back to the original website
    As a user who wants to read more from the same website
    I want to go back to the original website I got the article from

    Scenario: Going back to Engadget's original website
        Given I am reading Engadget on my account
        When I click on the Globe icon
        Then I should be at Engadget's original website with url http://www.engadget.com
        
        