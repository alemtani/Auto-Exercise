package tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class BrowserTests extends BrowserClass {

	@Test
	public void testOne() {
		driver.get("http://google.com");
		Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());
	}
	
	@Test
	public void testTwo() throws InterruptedException {
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("mobile integration workgroup");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		try {
			List<AndroidElement> results = driver.findElementsByXPath("//*[@id='rso']/div[2]/div/div[1]/a");
			results.get(0).click();
			Assert.assertEquals("https://miwtech.com/", driver.getCurrentUrl());
		} catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
			Assert.fail();
		}

	}

}
