package android.nativeApps.demodslv;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropAction {

	// Object reference of AndroidDriver.
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		// Set Drag-Sort Demos app folder path. This statement will refer
		// project's folder path.
		File classpathRoot = new File(System.getProperty("user.dir"));

		// Set folder name "Apps" where .apk file is stored.
		File appDir = new File(classpathRoot, "/apps");

		// Set Drag-Sort Demos .apk file name.
		File app = new File(appDir, "com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");

		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		//capabilities.setCapability("browserName", "Android");

		// Set android VERSION desired capability. Set your mobile device's OS
		// version.
		//capabilities.setCapability("platformVersion", "7.1.1");

		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", "Android");

		// Set .apk file's path capabilities.
		capabilities.setCapability("app", app.getAbsolutePath());

		// Set app Package desired capability of Drag-Sort Demos app.
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");

		// Set app Activity desired capability of Drag-Sort Demos app.
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		// Created object of AndroidDriver and set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch Drag-Sort Demos app in emulator.
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dragDrop() {

		// Tap on Basic usage Playground.
		// driver.findElementByName("Basic usage playground").click();
		driver.findElementByXPath("//*[@text='Basic usage playground']").click();

		// Locate 3rd element(Chick Corea) from list to drag.
		AndroidElement webElement1 = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);

		//
		Point pointElement1 = webElement1.getLocation();

		//
		Dimension dimElement1 = webElement1.getSize();

		//
		int x = pointElement1.getX() + dimElement1.getWidth() / 2;

		//
		int y = pointElement1.getY() + dimElement1.getHeight() / 2;

		System.out.println(webElement1);

		// Locate 6th element to drop dragged element.
		AndroidElement webElement2 = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);

		//
		System.out.println(webElement2);

		// Created object of TouchAction class.
		TouchAction touchActionObj = new TouchAction(driver);

		//
		System.out.println("Dragging element");

		//
		touchActionObj.press(PointOption.point(x, y));

		//
		System.out.println("Element dropped at destination successfully");
	}

	@AfterTest
	public void End() {
		// Quit
		driver.quit();
	}
}