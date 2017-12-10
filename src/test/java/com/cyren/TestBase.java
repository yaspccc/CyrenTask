package com.cyren;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by amiro on 12/7/2017.
 *
 */
public class TestBase {

    protected static final Logger log = Logger.getLogger(TestBase.class);
    protected static WebDriver myDriver;
    protected static DesiredCapabilities desiredCapabilities;
    protected static String hubUrl;

    @BeforeClass
    public static void beforeClass() {
       getSession();

    }

    @AfterClass
    public static void afterclass() {
        myDriver.quit();
    }


    protected static void getSession() {
        if (System.getProperty("testPlatform").equals("mobile")) {
            try {
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "26");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "111");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                //desiredCapabilities.setCapability(MobileCapabilityType.APP, String.format(androidApkPath,appVersion));
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
                URL url = new URL(hubUrl);
                myDriver = new AndroidDriver(url, desiredCapabilities);
            } catch (Exception e) {
            }
        } else {
            System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
            myDriver = new ChromeDriver();
            myDriver.manage().window().maximize();
        }
    }
}
