package com.luki.pom;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageCheckoutOverview {
	public static WebElement buttonFinish(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-FINISH"));
	}
}
