package com.SeleniumBasics.Practice.PracticeSelenium.AutomationPractice1;



import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;






import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PracticeAutomation1 {

	static WebDriver driver;
	static String suggestion;
	
	@Parameters({"URL"})
	@BeforeTest
	public static void setUp(String url){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumJavaFramework\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void newMethod(){
		System.out.println("Test2Exlude");
	}
	
	@Parameters({"name"})
	@Test
	public void testAutomation1(String name) throws Exception{
		System.out.println("Test Start");
		
		//Radio Button Example
		List <WebElement> radioButton = driver.findElements(By.xpath("//div[@id='radio-btn-example']//label"));
		for (WebElement rdioButton : radioButton) {
			if (rdioButton.getText().equalsIgnoreCase("Radio2")) {
				Assert.assertTrue(true);
				rdioButton.findElement(By.xpath("//div[@id='radio-btn-example']//label[2]//input")).click();
			} else {
				System.out.println(rdioButton.getText());
				Assert.assertFalse(false);
			}
		}
		
		//Suggestion Class Example
		WebElement suggestionExample = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		Actions builder = new Actions(driver);
		Action seriesOfAction = builder
								.moveToElement(suggestionExample)
								.sendKeys(suggestionExample, "Al")
								.sendKeys(suggestionExample,Keys.ARROW_DOWN)
								.sendKeys(suggestionExample, Keys.ARROW_DOWN)
								.sendKeys(suggestionExample, Keys.ENTER)
								.build();
		seriesOfAction.perform();

		
		//DropDown Example
		WebElement drpDownExample = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select slct = new Select(drpDownExample);
		slct.selectByIndex(2);
		
		
		//CheckBox Example
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		
		
		//Switch Window Example
		String currentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		
		for (String windowHandles : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandles);
		}
		driver.close();
		driver.switchTo().window(currentWindow);
		
		
		//Switch to Alert Example
		WebElement inputType = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement alertButton = driver.findElement(By.xpath("//input[@id='confirmbtn']"));
		Action seriesOfAction2 = builder
										.sendKeys(inputType, name)
										.click(alertButton)
										.build();
		seriesOfAction2.perform();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Web Table Example
		List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='product']//tbody//tr//th"));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("Table Header Size: " + tableHeader.size());
		for (int i = 0; i < tableHeader.size(); i++) {
			System.out.println("Table Header Name: " + tableHeader.get(i).getText()); 
		}
		List<WebElement> tableRowCount = driver.findElements(By.xpath("//table[@id='product']//tbody//tr//td[1]"));
		System.out.println("Table Row Count: "+ tableRowCount.size());
		
		//MouseHover
		WebElement mouseHoverButton = driver.findElement(By.xpath("//button[@id='mousehover']"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverButton).build().perform();	
		driver.findElement(By.xpath("//a[contains(text(),'Reload')]")).click();
		
		
		//Iframe		
		Thread.sleep(2000);
	}

	@AfterClass
	public static void quitBrowser(){
		driver.quit();
		System.out.println("Test Done");
	}

}
