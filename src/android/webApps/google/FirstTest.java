package android.webApps.google;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.CommonUtils;

public class FirstTest {

	RemoteWebDriver remoteWebDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		CommonUtils commonUtils = new CommonUtils();

		remoteWebDriverObj = commonUtils.initalizeRemoteWebDriver();
		
	}

	@Test
	public void test001() {

		remoteWebDriverObj.get("https://www.google.com");
		
		System.out.println("Page Title : " + remoteWebDriverObj.getTitle());

	}

	@AfterTest
	public void End() throws IOException {

		remoteWebDriverObj.quit();
	}

}
