package android.webApps.amazon;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

	RemoteWebDriver remoteWebDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		CommonUtils commonUtils = new CommonUtils();

		remoteWebDriverObj = commonUtils.initalizeRemoteWebDriver();
		
	}

	@Test
	public void test001() {

		remoteWebDriverObj.get("https://www.amazon.in/");
		
		System.out.println("Page Title : " + remoteWebDriverObj.getTitle());

	}

	@AfterTest
	public void End() throws IOException {

		remoteWebDriverObj.quit();
	}

}
