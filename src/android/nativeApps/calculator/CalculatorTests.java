package android.nativeApps.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.CommonUtils;

public class CalculatorTests {

	// Create Object of WebDriver
	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		CommonUtils commonUtils = new CommonUtils();

		androidDriverObj = commonUtils.initalizeAndroidDriver("com.google.android.calculator","com.android.calculator2.Calculator") ;

	}

	@Test
	public void addition() throws Exception {

		CommonUtils.printContextName(androidDriverObj);
		
		//androidDriverObj.openNotifications();
		
		Thread.sleep(5000);

		// locate the Text '2' on the calculator by using By.name()
		AndroidElement two = androidDriverObj.findElement(By.id("digit_2"));

		// click on AndroidElement
		two.click();

		//
		AndroidElement plus = androidDriverObj.findElement(By.id("op_add"));

		// click on AndroidElement
		plus.click();

		//
		AndroidElement four = androidDriverObj.findElement(By.id("digit_4"));

		// click on AndroidElement
		four.click();

		//
		AndroidElement equalTo = androidDriverObj.findElement(By.id("eq"));

		// click on AndroidElement
		equalTo.click();

		// Get result from result text box.
		String result = androidDriverObj.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

		//
		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() {

		// close the app
		androidDriverObj.quit();
	}
}