Feature: Login into Facebook account

Scenario: Login into Facebook account using correct credentials
Given User navigates to Facebook Login Page
And User enters a valid username in Username Text Field 
And User enters a valid password in Password Text Field
When User clicks the Login Button
Then should be taken to Facebook Home Page
