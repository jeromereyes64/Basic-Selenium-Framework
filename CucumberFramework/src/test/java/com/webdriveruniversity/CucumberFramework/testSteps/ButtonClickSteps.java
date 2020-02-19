package com.webdriveruniversity.CucumberFramework.testSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webdriveruniversity.CucumberFramework.utils.switchDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class ButtonClickSteps {

	WebDriver driver;
	switchDriver switchDriver;
	Alert alert;
	String actual;

	@Before("@buttonClickPage")
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		switchDriver = new switchDriver(driver);
	}

	@After("@buttonClickPage")
	public void quitBrowser(){
		driver.quit();
		System.out.println("Test Done");
	}

	@Given("^User redirect in WebDriverUniversity$")
	public void user_redirect_in_WebDriverUniversity() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://webdriveruniversity.com/index.html");
	}

	@When("^User click Button Clicks Link$")
	public void user_click_Button_Clicks_Link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("button-clicks")).click();
	}

	@Then("^User should be redirected to Button Clicks Page$")
	public void user_should_be_redirected_to_Button_Clicks_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		switchDriver.switchBrowser();
		WebElement buttonClickPageText = driver.findElement(By.id("main-header"));
		actual = buttonClickPageText.getText();
		Assert.assertEquals(actual, "Lets Get Clicking!");
	}

	@When("^User click WebElement Click Button$")
	public void user_click_WebElement_Click_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("button1")).click();
		Thread.sleep(5000);
	}

	@Then("^an Congratulations! alert prompt should show$")
	public void an_Congratulations_alert_prompt_should_show() throws Throwable {
		try {
			WebElement divText = driver.findElement(By.cssSelector("div.modal-body > p"));
			Assert.assertEquals(divText.getText().contains("Well done for successfully using the click() method!"), true);
			driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^User click Javascript Click Button$")
	public void user_click_Javascript_Click_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions 
		driver.findElement(By.id("button2")).click();
		Thread.sleep(5000);
	}

	@Then("^an It’s that Easy!! alert prompt should show$")
	public void an_It_s_that_Easy_alert_prompt_should_show() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			WebElement divText = driver.findElement(By.cssSelector("div.modal-body > p"));
			System.out.println(divText.getText().toString());
			//Assert.assertEquals(divText.getText().contains("We can use JavaScript code if all else fails!"), true);
			driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-default")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

	@When("^User click Action Move Button$")
	public void user_click_Action_Move_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("button3")).click();
		Thread.sleep(5000);
	}

	@Then("^an Well done! alert prompt should show$")
	public void an_Well_done_alert_prompt_should_show() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			//WebElement divText = driver.findElement(By.cssSelector("div.modal-body > p"));
			//Assert.assertEquals(divText.getText().contains("Advanced user interactions (API)"), true);
			driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-default")).click();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
