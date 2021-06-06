Feature: Google Page Search feature
Here I want to test google page for differnt search text


Scenario: Search selenium test
Given User is on google home page
When User search selenium 
Then Should display selenium search result page
And Close the browser

Scenario: Search Java test
Given User is on google home page
When User search Java 
Then Should display Java search result page
And Close the browser