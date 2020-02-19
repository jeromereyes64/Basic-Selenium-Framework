package javatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BasicElements {

	static WebDriver driver;
	
	public static void main(String[] args) {		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumProject\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		try {
			driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[1]//input[1]")).click();
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Alb");
			
		/*	Actions builder = new Actions(driver);
			Action seriesOfAction = builder
											.moveToElement(suggetionBtn)
											.sendKeys("Alb")
											.sendKeys(Keys.ARROW_DOWN)
											.sendKeys(Keys.ENTER)
											.build();
			seriesOfAction.perform();	*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
