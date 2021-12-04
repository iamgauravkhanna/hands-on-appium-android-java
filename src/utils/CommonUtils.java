package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.UUID;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonUtils {

	AndroidDriver androidDriver;

	RemoteWebDriver remoteWebDriver;

	public RemoteWebDriver initalizeRemoteWebDriver(){

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("browserName", "Chrome");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		try {

			remoteWebDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		return remoteWebDriver ;

	}

	public AndroidDriver initalizeAndroidDriver(String APP_PACKAGE, String APP_ACTIVITY) throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "10");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", APP_PACKAGE);

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", APP_ACTIVITY);

		//
		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		// Create Android instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

		return androidDriver;
	}

	public void DesiredCapiblitiesMethod() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	public static void scrollToElementAndClick(AndroidDriver driver, String Value) {

		// Scroll till element which contains Tabs text.
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + Value + "\"));")
				.click();

	}

	public static void printContextName(AndroidDriver androidDriverObj) {

		Set<String> contextNames = androidDriverObj.getContextHandles();

		for (String contextName : contextNames) {

			System.out.println("Context is : " + contextName);

		}

	}

	public static void waitForElementPresent(AndroidDriver driverObj, AndroidElement androidElementObj,
			int secondsToWait) {

		try {

			WebDriverWait wait = new WebDriverWait(driverObj, secondsToWait);

			wait.until(ExpectedConditions.visibilityOf(androidElementObj));

			System.out.println("Great! Element Found");

		} catch (Exception e) {

			System.out.println("Oops !! Element was not visible on UI");

			System.out.println(e.getMessage());

		}

	}

	public static void takeScreenshot(AndroidDriver driver) {

		File srcFile = driver.getScreenshotAs(OutputType.FILE);

		String filename = UUID.randomUUID().toString();

		File targetFile = new File(filename + ".jpg");

		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}