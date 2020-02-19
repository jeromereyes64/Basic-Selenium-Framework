@pomSteps
Feature: Check the Page Object Model Link in WebDriverUniversity Web Page

Scenario Outline: Accessing Contact Us Message through Page Object Model Link and submit informations.
Given User Access the "http://webdriveruniversity.com/index.html" Page
When User Click Page Object Model Link
When User Click the Contact Us Tab
And User Enter an information on "<Firstname>" fNameField 
And User Enter an information on "<Lastname>" lNameField
And User Enter an information on "jerome@gmail.com" emailField
And User Enter an information on "<Message>" messageField
When User Click Submit Button
Then User should be redirected to another Page
And User will see Thank You Message 

Examples:
|	Firstname	|	Lastname	|	Message	|
|	Jerome		| 	Reyes		|	JPOGI	|
| 	Roam		|	Estrella	|	MARIMAR	|
|	Mirriam		| 	Feliciano	|	FAMILY	|