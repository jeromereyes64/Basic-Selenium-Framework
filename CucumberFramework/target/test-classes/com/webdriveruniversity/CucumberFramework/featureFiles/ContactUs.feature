@contactUs
Feature: Checking the Contact Us form in WebdriverUniversity.com

Scenario: Submit valid information in Contact Us Form
Given User access the WebdriverUniversity.com
When User click the ContactUs Link
And User enter a valid First Name
And User enter a valid Last Name
And User enter a valid Email Aaddress
And User enter a valid Comment
|Message1|Message2|
|Automation is fun|Automation for QA|
When User click the Submit Button
And Successful validation will show
 
 

