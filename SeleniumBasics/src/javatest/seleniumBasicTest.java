package javatest;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumBasicTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumProject\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.findElement(By.)
		//List<WebElement> allLinks = driver.findElement(By.tagName("a"));
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 
		 for (WebElement allLink : allLinks) {
			System.out.println(allLink.getText() + ",");
		} 
		 WebElement drpDownElement = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		 Select selectDrpDown = new Select(drpDownElement);
		 selectDrpDown.selectByValue("option1");
		 Thread.sleep(1000);
		 driver.quit();
		 
	}
	
}
