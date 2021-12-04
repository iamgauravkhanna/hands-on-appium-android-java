package android.nativeApps.settings;

// com.android.settings

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tools.ant.taskdefs.Touch;
import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.touch.offset.PointOption;
import utils.CommonUtils;

public class NotificationTests {

	// Create Object of WebDriver
	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		CommonUtils commonUtils = new CommonUtils();

		androidDriverObj = commonUtils.initalizeAndroidDriver("com.android.settings", ".Settings");

	}

	@Test
	public void addition() throws Exception {

		Thread.sleep(5000);

		MobileElement displayObj = androidDriverObj.findElementByXPath("//android.widget.TextView[@text='Display']");
		
		displayObj.click();
		
		System.out.println("Current Activity => " + androidDriverObj.currentActivity());
		
		androidDriverObj.openNotifications();

		Thread.sleep(5000);

	}

	@AfterClass
	public void teardown() {

		// close the app
		androidDriverObj.quit();
	}

}