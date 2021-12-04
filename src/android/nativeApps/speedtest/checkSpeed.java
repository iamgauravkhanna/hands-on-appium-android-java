package android.nativeApps.speedtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkSpeed {
	//
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Set Drag-Sort Demos app folder path. This statement will refer
		// project's folder path.
		File classpathRoot = new File(System.getProperty("user.dir"));

		// Set folder name "Apps" where .apk file is stored.
		File appDir = new File(classpathRoot, "/apps");

		// Set Drag-Sort Demos .apk file name.
		File app = new File(appDir, "org.zwanoo.android.speedtest-3.2.12.apk");

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set BROWSER_NAME desired capability
		// capabilities.setCapability("BROWSER_NAME", "Android");

		// Set android VERSION desired capability
		//capabilities.setCapability("VERSION", "5.0.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "org.zwanoo.android.speedtest-1");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.ookla.speedtest.softfacade.MainActivity");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void checkSpeedTest() {

		// locate the Text on the calculator by using By.name()
		WebElement two = driver.findElement(By.name("2"));
	}
}
