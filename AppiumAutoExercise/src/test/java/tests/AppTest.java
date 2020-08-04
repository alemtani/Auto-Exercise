package tests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import junit.framework.Assert;

public class AppTest extends AppClass {
	
	@Test
	public void testThree() throws InterruptedException {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElementById("android:id/button2").click();
			driver.findElementById("android:id/button1").click();
			
			driver.findElementById("com.clearchannel.iheartradio.controller:id/login_button").click();
			driver.findElementById("com.clearchannel.iheartradio.controller:id/email").sendKeys("mcb02test@gmail.com");
			driver.findElementById("com.clearchannel.iheartradio.controller:id/password").sendKeys("MCBTest1234");
			driver.findElementById("com.clearchannel.iheartradio.controller:id/email_login").click();
			
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]").click();
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout").click();
			
			final long start = System.currentTimeMillis();
			
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton").click();
			
			for (int second = 0;; second++) {
				if (second >= 10) {
					Assert.fail("timeout");
				}
				try {
					if (isElementPresent(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView"))) {
						break;
					}
				} catch(Exception e) {}
				Thread.sleep(1000);
			}
			
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout").click();
			
			((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			while (System.currentTimeMillis() - start < 60000) {}
			
			driver.findElementById("com.clearchannel.iheartradio.controller:id/playPauseProgress").click();
			
			Assert.assertTrue(true);
			
		} catch(Exception exp) {
			
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
			Assert.fail();
			
		}
		
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
