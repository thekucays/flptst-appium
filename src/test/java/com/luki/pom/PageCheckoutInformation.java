package com.luki.pom;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageCheckoutInformation {
	public static WebElement inputFirstName(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-First Name"));
	}
	
	public static WebElement inputLastName(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Last Name"));
	}
	
	public static WebElement inputPostalCode(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code"));
	}
	
	public static WebElement buttonContinue(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-CONTINUE"));
	}
	
}
