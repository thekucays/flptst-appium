package com.luki.pom;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageCheckoutComplete {
	public static WebElement layoutCheckoutComplete(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-CHECKOUT: COMPLETE!"));
	}
	
	public static WebElement buttonBackHome(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-BACK HOME"));
	}
}
