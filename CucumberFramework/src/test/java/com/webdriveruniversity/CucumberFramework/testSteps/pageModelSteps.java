package com.webdriveruniversity.CucumberFramework.testSteps;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sun.jna.platform.win32.WinUser.HARDWAREINPUT;
import com.webdriveruniversity.CucumberFramework.utils.switchDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class pageModelSteps {
	
	WebDriver driver;
	switchDriver switchBrowser;
	String actualTitle;
	
	@Before("@pomSteps")
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		switchBrowser = new switchDriver(driver);
	}
	
	@After("@pomSteps")
	public void quitBrowser(){
		driver.quit();
		System.out.println("Test Done");
	}
	
	
	@Given("^User Access the \"([^\"]*)\" Page$")
	public void user_Access_the_Page(String url) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
		String actualTitle = driver.getTitle().toString().toLowerCase();
		String expectedTitle = "webdriveruniversity.com";
		Assert.assertEquals(actualTitle, expectedTitle.toLowerCase());
		System.out.println("User Access webDriverPage");
		
	}
	
	
	
	@When("^User Click Page Object Model Link$")
	public void user_Click_Page_Object_Model_Link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("page-object-model")).click();
		switchBrowser.switchBrowser();
		actualTitle = driver.getTitle().toString();
		Assert.assertEquals(actualTitle,"WebDriver | Page Object Model");
		System.out.println("User Acces Page Object Model Link");
	}

	@When("^User Click the Contact Us Tab$")
	public void user_Click_the_Contact_Us_Tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Contact Us")).click();
		//Assert.assertEquals(true, element.isDisplayed());
		switchBrowser.switchBrowser();
		actualTitle = driver.getTitle().toString();
		Assert.assertEquals(actualTitle, "WebDriver | Contact Us");
		System.out.println("User access Contact Us");
	}

	@When("^User Enter an information on \"([^\"]*)\" fNameField$")
	public void user_Enter_an_information_on_fname(String fName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement fNameElement = driver.findElement(By.xpath("//input[@name='first_name']"));
		Assert.assertEquals(true, fNameElement.isDisplayed());
		fNameElement.sendKeys(fName);
	}
	
	@When("^User Enter an information on \"([^\"]*)\" lNameField$")
	public void user_Enter_an_information_on_lname(String lName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement lNameElement = driver.findElement(By.xpath("//input[@name='last_name']"));
		Assert.assertEquals(true, lNameElement.isDisplayed());
		lNameElement.sendKeys(lName);
	}
	
	@When("^User Enter an information on \"([^\"]*)\" emailField$")
	public void user_Enter_an_information_on_email(String email) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
		Assert.assertEquals(true, emailElement.isEnabled());
		emailElement.sendKeys(email);
	}
	
	@When("^User Enter an information on \"([^\"]*)\" messageField$")
	public void user_Enter_an_information_on_message(String message) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement messageElement = driver.findElement(By.xpath("//textarea[@name='message']"));
		Assert.assertEquals(true, messageElement.isDisplayed());
		messageElement.sendKeys(message);
	}

	@When("^User Click Submit Button$")
	public void user_Click_Submit_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='SUBMIT']"));
		Actions action = new Actions(driver);
		action.moveToElement(submitButton).click().build().perform();
	}

	@Then("^User should be redirected to another Page$")
	public void user_should_be_redirected_to_another_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		switchBrowser.switchBrowser();
		actualTitle = driver.getTitle().toString();
		Assert.assertEquals(actualTitle, "Gianni Bruno - Designer");
	}

	@Then("^User will see Thank You Message$")
	public void user_will_see_Thank_You_Message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement notifMessage = driver.findElement(By.id("contact_reply"));
		actualTitle = notifMessage.getText();
		assertEquals(actualTitle, "Thank You for your Message!");
	}

}
