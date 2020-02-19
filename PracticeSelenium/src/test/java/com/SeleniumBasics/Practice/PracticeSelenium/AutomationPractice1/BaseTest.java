package com.SeleniumBasics.Practice.PracticeSelenium.AutomationPractice1;

import java.awt.peer.SystemTrayPeer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BaseTest {
	
	public WebDriver driver = null;
	
	public BaseTest(WebDriver driver){
		this.driver = driver;
	}
	
	public void accessLoginPage() throws IOException{
		Properties prop = new Properties();
		FileInputStream fileInput = new FileInputStream("D:\\Selenium\\PracticeSelenium\\testData.properties");
		prop.load(fileInput);
		
		if (prop.getProperty("browser").contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumJavaFramework\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (prop.getProperty("browser").contains("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\SeleniumJavaFramework\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
}
