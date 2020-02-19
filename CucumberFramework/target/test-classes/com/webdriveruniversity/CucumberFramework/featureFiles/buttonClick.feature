@buttonClickPage
Feature: Validating Button Click Link in WebDriverUniversity Page

Scenario: Validating Button Click Link and checking 3 Click Me Buttons
Given User redirect in WebDriverUniversity
When User click Button Clicks Link
Then User should be redirected to Button Clicks Page
When User click WebElement Click Button
Then an Congratulations! alert prompt should show
When User click Javascript Click Button
Then an It’s that Easy!! alert prompt should show
When User click Action Move Button
Then an Well done! alert prompt should show

