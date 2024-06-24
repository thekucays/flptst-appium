package com.luki.pom;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageLogin {
	public static WebElement buttonLogin(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
	}
	
	public static WebElement inputUsername(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Username"));
	}
	
	public static WebElement inputPassword(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Password"));
	}
}
