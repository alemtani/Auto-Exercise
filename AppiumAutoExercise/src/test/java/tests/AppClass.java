package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;
import java.net.URL;
import java.net.MalformedURLException;

public class AppClass {

	protected AndroidDriver<AndroidElement> driver = null;

	DesiredCapabilities dc = new DesiredCapabilities();

	@Before
	public void setUp() throws MalformedURLException {
		
		try {
			
			dc.setCapability(CapabilityType.PLATFORM_NAME,"ANDROID");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
			dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			dc.setCapability("appPackage", "com.clearchannel.iheartradio.controller");
			dc.setCapability("appActivity", ".activities.NavDrawerActivity");
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
			
		} catch(Exception exp) {
			
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
			
		}
		
	}

	@After
	public void tearDown() {
		
		driver.closeApp();
		driver.quit();
		
	}
}
