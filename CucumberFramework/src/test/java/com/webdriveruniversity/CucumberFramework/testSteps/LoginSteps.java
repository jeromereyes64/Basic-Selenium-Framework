package com.webdriveruniversity.CucumberFramework.testSteps;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	private static WebDriver driver;

	/*@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//this.driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void closeDriver(){
		driver.close();
		System.out.println("LoginSteps Test Done");
	}*/

	//LOGIN USING VALID CREDENTIALS
	@Given("^User navigates to Facebook Login Page$")
	public void user_navigates_to_Facebook_Login_Page()  {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.facebook.com/");
		System.out.println("navigates to Facebook Login Page");
	}

	@Given("^User enters a valid username in Username Text Field$")
	public void user_enters_a_valid_username_in_Username_Text_Field()  {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("email")).sendKeys("jerome.reyes64@yahoo.com");
		System.out.println("enters a valid username in Username Text Field");
	}

	@Given("^User enters a valid password in Password Text Field$")
	public void user_enters_a_valid_password_in_Password_Text_Field()  {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("pass")).sendKeys("09275531775");
		System.out.println("enters a valid password in Password Text Field");
	}

	@When("^User clicks the Login Button$")
	public void user_clicks_the_Login_Button()  {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("loginbutton")).click();
		System.out.println("clicks the Login Button");
	}

	@Then("^should be taken to Facebook Home Page$")
	public void should_be_taken_to_Facebook_Home_Page()  {
		//Thread.sleep(6000);
		// Write code here that turns the phrase above into concrete actions
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		assertNotNull(homeLink);
		assertEquals(true, homeLink.isDisplayed());
		System.out.println();
		System.out.println("should be taken to Facebook Home Page");
	}
}
