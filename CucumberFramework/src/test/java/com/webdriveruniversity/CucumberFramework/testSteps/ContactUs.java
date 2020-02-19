package com.webdriveruniversity.CucumberFramework.testSteps;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;















import com.webdriveruniversity.CucumberFramework.utils.switchDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

public class ContactUs {

	private static WebDriver driver;
	switchDriver switchBrowser;
	
	@Before("@contactUs")
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After("@contactUs")
	public void quitDriver(){
		driver.quit();
		System.out.println("ContactUs Test Done");
	}

	//ContactUs.Feature
	@Given("^User access the WebdriverUniversity\\.com$")
	public void user_access_the_WebdriverUniversity_com() throws Throwable {
		//driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		driver.get("http://webdriveruniversity.com/");	
		//driver.navigate().to("http://webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@When("^User click the ContactUs Link$")
	public void user_click_the_ContactUs_Link() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("contact-us")).click();

		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			System.out.println(windowHandle);
		}
	}


	@When("^User enter a valid First Name$")
	public void user_enter_a_valid_First_Name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Jerome");
		//Assert.assertEquals(true, element);
		System.out.println("User enter a valid First Name");
	}

	@When("^User enter a valid Last Name$")
	public void user_enter_a_valid_Last_Name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Reyes");
		System.out.println("User enter a valid Last Name");
	}

	@When("^User enter a valid Email Aaddress$")
	public void user_enter_a_valid_Email_Aaddress() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jfreyes@gmail.com");
		System.out.println("User enter a valid email address");
		Thread.sleep(5000);
	}


	@When("^User enter a valid Comment$")
	public void user_enter_a_valid_Comment(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> data = arg1.asMaps(String.class,String.class);
		//Map<String, String> data = arg1.asMap(String.class,String.class);
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get("Message1"));
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get("Message2"));
		//driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(1));
		System.out.println("User enter a valid comments");
	}

	@When("^User click the Submit Button$")
	public void user_click_the_Submit_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='SUBMIT']"));
		Actions action = new Actions(driver);
		action.moveToElement(submitButton).click().build().perform();
	}

	@When("^Successful validation will show$")
	public void successful_validation_will_show() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String message = driver.findElement(By.id("contact_reply")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Thank You for your Message!");
	}

}
