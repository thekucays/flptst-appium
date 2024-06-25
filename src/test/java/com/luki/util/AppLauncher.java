package com.luki.util;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class AppLauncher {
	public static AndroidDriver startApp(String deviceName) throws Exception {
		// options to connect to device and app under test
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName(deviceName);
		options.setApp(System.getProperty("user.dir") + "/apk/apptest.apk");
		options.setAppWaitActivity("com.swaglabsmobileapp.MainActivity");
		
		// init driver
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		Thread.sleep(4000);
		
		return driver;
	}
}
