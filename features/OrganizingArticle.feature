Feature: Organizing Articles
    In order to organize my articles
    As a user who added a lot of articles
    I want to like an article

    Scenario: Liking Engadget article
        Given I added Engadget into my account
        And I liked the Engadget article
        When I click the Heart icon
        Then Engadget should be liked and shows up in my Liked page