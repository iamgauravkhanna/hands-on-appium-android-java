package android.nativeApps.toi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.net.MalformedURLException;

public class FirstTest {

    // Create Object of WebDriver
    AndroidDriver<AndroidElement> androidDriverObj;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        CommonUtils commonUtils = new CommonUtils();

        androidDriverObj = commonUtils.initalizeAndroidDriver("com.toi.reader.activities", ".NavigationFragmentActivity");

    }

    @Test
    public void addition() throws Exception {

        Thread.sleep(5000);

        System.out.println("Current Activity => " + androidDriverObj.currentActivity());

        Thread.sleep(5000);

    }

    @AfterClass
    public void teardown() {

        // close the app
        androidDriverObj.quit();
    }

}
