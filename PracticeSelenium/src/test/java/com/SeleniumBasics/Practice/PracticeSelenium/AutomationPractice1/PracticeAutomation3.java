package com.SeleniumBasics.Practice.PracticeSelenium.AutomationPractice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeAutomation3 {
	
	public WebDriver driver = null;
	
	@BeforeClass
	public void setUpDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumJavaFramework\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(dataProvider = "testData")
	public void practiceAutomation3(String userName, String passWord) throws Exception{
		driver.get("https://stackoverflow.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Log in ASD')]")).click();
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//button[@id='submit-button']")).click();
	}
	
	
	@DataProvider(name ="testData")
	public Object[][] getData(){
		Object[][] testData = new Object[3][2];
		System.out.println(testData[1].length);
		
		for (int i = 0; i < testData.length; i++) {
			for (int j = 0; j < testData[i].length; j++) {
				if (j == 0) {
					testData[i][j] = "Username" + j;
				} else {
					testData[i][j] = "Password" + j;
				}
			}
		}
		
		return testData;
	}
	
	
	@AfterClass
	public void quitBrowser(){
		System.out.println("Test Done");
		driver.quit();
	}
}
