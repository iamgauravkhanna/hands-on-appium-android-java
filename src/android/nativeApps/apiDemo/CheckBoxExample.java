package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.CommonUtils;

public class CheckBoxExample {

	AndroidDriver<AndroidElement> androidDriver;

	@BeforeTest
	public void setUp() throws Exception {

		CommonUtils commonUtils = new CommonUtils();

		androidDriver = commonUtils.initalizeAndroidDriver("io.appium.android.apis","io.appium.android.apis.ApiDemos");

	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		androidDriver.findElementByAccessibilityId("Views").click();

		// Click on Controls.
		androidDriver.findElement(By.name("Controls")).click();

		// Click on 2. Dark Theme.
		androidDriver.findElement(By.name("2. Dark Theme")).click();

		// Click on check-box to select it.
		androidDriver.findElement(By.name("Checkbox 2")).click();
	}

	@AfterTest
	public void End() {
		androidDriver.quit();
	}
}