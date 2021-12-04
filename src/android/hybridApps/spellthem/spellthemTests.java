package android.hybridApps.spellthem;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.CommonUtils;

public class spellthemTests {

//	AndroidDriver<AndroidElement> androidDriverObj;
//
//	AndroidElement element;
//
//	/**
//	 *
//	 * Chromedriver need to configured while running Appium Server
//	 *
//	 * */
//	@BeforeTest
//	public void setUp() throws MalformedURLException {
//
//		CommonUtils commonUtils = new CommonUtils();
//
//		androidDriverObj = commonUtils.initalizeAndroidDriver("com.spellthem.webpages","com.spellthem.webpages.MainActivity") ;
//	}
//
//	@Test
//	public void firstTest() throws InterruptedException {
//
//		CommonUtils.printContextName(androidDriverObj);
//
//		Thread.sleep(30000);
//
//		//androidDriverObj.context("WEBVIEW_com.spellthem.webpages");
//
//		CommonUtils.waitForElementPresent(androidDriverObj,
//				androidDriverObj.findElement(By.xpath("//span[text()='Try Oracle Cloud Free']")), 30);
//
//		androidDriverObj.findElement(By.xpath("//span[text()='Try Oracle Cloud Free']")).click();
//
//		CommonUtils.waitForElementPresent(androidDriverObj,
//				androidDriverObj.findElement(By.xpath("//a[text()='Create a Free Account']")), 30);
//
//		androidDriverObj.findElement(By.xpath("//a[text()='Create a Free Account']")).click();
//
//	}
//
//	@AfterTest
//	public void End() throws IOException {
//
//		androidDriverObj.quit();
//	}

}