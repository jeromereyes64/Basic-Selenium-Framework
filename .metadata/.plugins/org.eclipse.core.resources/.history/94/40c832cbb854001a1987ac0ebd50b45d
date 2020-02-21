package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	private static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static String projectDIR = System.getProperty("user.dir");
	
	public WebDriver initializeBrowser() throws IOException{
		
		String browserDIR = projectDIR + "\\src\\main\\java\\resources\\browserconfig.properties";
		prop = new Properties();
		FileInputStream fs = new FileInputStream(browserDIR);
		prop.load(fs);
		
		String browserName = System.getProperty("browser");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		//prop.getProperty("browser").equalsIgnoreCase("chrome")
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectDIR + "\\browserdrivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
		}
		else {
			System.setProperty("webdriver.gecko.driver", projectDIR + "\\browserdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void getScreenShot(String name) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileDestination = projectDIR + "\\logs\\" + name + "_" + timeStamp +"_screenshot.png";
		File dest = new File(fileDestination);
		FileUtils.copyFile(src, dest);
	}
	
	public void newOne(){
		System.out.println("Test for Git");
	}
	
	public void newTwo(){
		System.out.println("Test for Git2");
	}
	

}
