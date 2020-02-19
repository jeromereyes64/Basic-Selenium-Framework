package com.webdriveruniversity.CucumberFramework.utils;

import org.openqa.selenium.WebDriver;


public class switchDriver {
	WebDriver driver;
	
	public switchDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public void switchBrowser(){
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			System.out.println(window);
		}
	}	
}
