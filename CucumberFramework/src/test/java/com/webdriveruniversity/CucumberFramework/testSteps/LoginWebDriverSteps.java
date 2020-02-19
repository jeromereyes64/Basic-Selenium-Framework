package com.webdriveruniversity.CucumberFramework.testSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class LoginWebDriverSteps {

	WebDriver driver;

	/*@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\CucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void quitDriver(){
		driver.quit();
		System.out.println("LoginWebdriver Test Done");
	}*/

	@Given("^User access the Webdriversity\\.com$")
	public void user_access_the_Webdriversity_com() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://webdriveruniversity.com/");
		System.out.println("User access the Webdriversity");
	}

	@When("^User click the Login Link$")
	public void user_click_the_Login_Link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-portal")).click();
		for (String windowHolder : driver.getWindowHandles()) {
			driver.switchTo().window(windowHolder);		
		}
		System.out.println("User click the Login Link");
	}

	@When("^User enter a valid username$")
	public void user_enter_a_valid_username() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("text")).sendKeys("Jerome");
		System.out.println("User enter a username");
	}

	@When("^User enter a \"([^\"]*)\" Password$")
	public void user_enter_a_Password(String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("User enter a password");
	}

	@When("^User click the Login Button$")
	public void user_click_the_Login_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-button")).click();
		System.out.println("User click the Login Button");
	}

	@Then("^User should recieve a validation alert$")
	public void user_should_recieve_a_validation_alert() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Alert alert = driver.switchTo().alert();
		String validationMessage = alert.getText();
		System.out.println(validationMessage);
		Assert.assertEquals(validationMessage, "validation failed");
		alert.accept();
	}

}
