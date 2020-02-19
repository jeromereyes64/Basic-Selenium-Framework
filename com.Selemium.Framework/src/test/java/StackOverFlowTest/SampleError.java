package StackOverFlowTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;

public class SampleError extends Base {
	
	@Test
	public void makeError() throws IOException{
		driver = initializeBrowser();
		driver.get("https://www.youtube.com/watch?v=kqhVNZgZGqQ");
		Assert.assertFalse(true);
	}
	
	@AfterTest
	public void quitSetup(){
		driver.quit();
	}
}
