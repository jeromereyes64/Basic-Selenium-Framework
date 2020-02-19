package com.SeleniumBasics.Practice.PracticeSelenium.AutomationPractice1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestPracticeUsingBase {
	
	public WebDriver driver;
	public BaseTest baseTest;
	
	@Test
	public void automateTest01() throws IOException {
		baseTest = new BaseTest(driver);
		baseTest.accessLoginPage();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
		System.out.println("Test Done");
	}
	
}
