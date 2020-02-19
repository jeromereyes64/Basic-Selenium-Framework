@loginSteps
Feature: Validating the Login Feature of Webdriver Univesity.com

Background:
Given User access the Webdriversity.com
When User click the Login Link
And User enter a valid username 

Scenario: Login in Webdriveruniversity.com using valid credentials
And User enter a "valid" Password
When User click the Login Button
Then User should recieve a validation alert


Scenario: Login in Webdriveruniversity.com using invalid credentials
And User enter a "invalid" Password
When User click the Login Button
Then User should recieve a validation alert