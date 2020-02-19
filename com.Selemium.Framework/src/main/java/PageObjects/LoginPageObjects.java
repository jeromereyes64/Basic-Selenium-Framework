package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	private WebDriver driver;

	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
	}

	private By logIn_Button = By.xpath("//a[contains(text(),'Log in')]");
	private By userName_TxtField = By.xpath("//input[@name='email']");
	private By passWord_TxtField = By.xpath("//input[@name='password']");
	private By submit_Button = By.xpath("//button[@name='submit-button']");
	private By errorMessage = By.xpath("//div[@class='grid fd-column gs4 gsy js-auth-item has-error']//p[contains(text(),'The email or password is incorrect.')]");

	public WebElement getLogInButton(){
		return driver.findElement(logIn_Button);	
	}

	public WebElement userNameTextField(){
		return driver.findElement(userName_TxtField);
	}

	public WebElement passwordTextField(){
		return driver.findElement(passWord_TxtField);
	}

	public WebElement submitButton(){
		return driver.findElement(submit_Button);
	}

	public WebElement errorMessage(){
		return driver.findElement(errorMessage);
	}


}
