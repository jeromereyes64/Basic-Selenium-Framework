package StackOverFlowTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;
import Resources.Base;


public class LandingPageClasss extends Base {
	
	//public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException{
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		//log.info("User directed to Website");
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.quit(); 
		System.out.println("Test Done");
		//log.error("Testing Done");
	}
	
	@Test(dataProvider="testDataUsernamePassword")
	public void homePageLogin(String username, String password) throws IOException{
		LoginPageObjects logInPageObjects = new LoginPageObjects(driver);
		logInPageObjects.getLogInButton().click();
		//log.error("User Click the Login Link");
		logInPageObjects.userNameTextField().sendKeys(username);
		logInPageObjects.passwordTextField().sendKeys(password);
		logInPageObjects.submitButton().click();
		//log.error("User Click the Submit Button");
		Assert.assertTrue(logInPageObjects.errorMessage().isDisplayed());
	}
	
	@DataProvider(name="testDataUsernamePassword")
	public Object[][] getData(){
		Object[][] data = new Object[2][2];
		data[0][0] = "jerome@gmail.com";
		data[0][1] = "password";
		
		data[1][0] = "reyes@yahoo.com";
		data[1][1] = "password1";
		return data;
	}

}
