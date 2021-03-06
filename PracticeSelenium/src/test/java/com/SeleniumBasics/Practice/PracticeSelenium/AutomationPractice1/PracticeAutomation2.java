package com.SeleniumBasics.Practice.PracticeSelenium.AutomationPractice1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;





import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeAutomation2 {

	static WebDriver driver;


	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumJavaFramework\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void newMethod1(){
		System.out.println("Test2Exlude");
	}
	
	
	@Test
	public void automationTest() throws InterruptedException{
		String[] neededList = {"Cauliflower","Carrot","Capsicum"};	
		List<WebElement> greenKartText = driver.findElements(By.xpath("//div[@class='product']//h4"));
		List<String> itemsList = Arrays.asList(neededList);

		for (int i = 0; i < greenKartText.size(); i++) {
			String[] name = greenKartText.get(i).getText().split("-");
			String nameList = name[0].trim();
			System.out.println(nameList);

			if (itemsList.contains(nameList)) {
				driver.findElements(By.xpath("//a[contains(text(),'+')]")).get(i).click();
				driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]")).get(i).click();
				continue;
			}
		}
		
		
		WebElement itemsInfo = driver.findElement(By.xpath("//div[@class='cart-info']//table//tbody//tr[1]//td//strong"));
		WebElement cartButton = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		
		if (itemsInfo.getText().equalsIgnoreCase("3")) {
			cartButton.click();
			driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		}

		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		WebElement select = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
		Select s = new Select(select);
		s.selectByValue("Philippines");
		
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		/*	for (WebElement greenKartItems : greenKartText) {
			if (itemsList.contains(greenKartItems.getText().toString())) {
				driver.findElements(By.xpath(""))
			} else {

			}
		}*/
		
		/*WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='chkAgree']")));
		*/
				
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
		Thread.sleep(1000);
		
		
		driver.get("https://www.tutorialspoint.com/java/java_methods.htm");
		List<WebElement> sociamMediaLinks = driver.findElements(By.xpath("//div[@class='social-menu-item']//a"));
		System.out.println(sociamMediaLinks.size());
		
		for (WebElement socialMediaLink : sociamMediaLinks) {
			String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
			socialMediaLink.sendKeys(key);
		}
		
		Set<String> openLink = driver.getWindowHandles();
		Iterator<String> iterator = openLink.iterator();
		
		while (iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}
		
		
		/*driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement drpDown =  driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		drpDown.click();
		Actions act1 = new Actions(driver);
		while (!drpDown.getText().equalsIgnoreCase("Option3")) {
			act1.sendKeys(Keys.ARROW_DOWN).build().perform();
			if (drpDown.getText().equalsIgnoreCase("Option3")) {
				act1.click(drpDown).build().perform();
			}
			
		}*/
		//act1.click(drpDown).build().perform();
	}

	@AfterClass
	public static void quitBrowser(){
		driver.quit();
		System.out.println("Test Done");
	}


}
