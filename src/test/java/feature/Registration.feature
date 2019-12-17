Feature: As a new user
I should be able to register myself with marathishadi.com
so that I can access features within marathishadi.com web portal


Scenario Outline: Verify registeration of new user by entering all mandatory fields
Given I enter url as '<url>' in the url bar of the browser
And I navigate to '<page>' login page
And I select option as '<concernedPerson>' who is looking for partner
And  I click on Let's Begin button
And I can see registeration pop up
And I enter '<emailId>' in Enter your email id text field
And I enter '<password>' in Create a password field
And I select <profile> from Create Profile for drop down
And I select '<gender>' radio button
And I click on Next button
When I navigate to basic details pop up
Then I should see '<language>' as Mother tongue
And I should see the web browser closed

Examples:
|url|page|emailId|password|language|concernedPerson|profile|gender|
|https://www.marathishaadi.com/|Marathi Shaadi|randomguy123@gmail.com|@@@123|Marathi|Self|Self|Male|
|https://www.gujaratishaadi.com/|Gujarati Shaadi|randomguy258@gmail.com|@@3121|Gujarati|Family|Relative|Female|



