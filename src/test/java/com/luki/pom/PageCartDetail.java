package com.luki.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageCartDetail {
	public static WebElement buttonCheckout(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-CHECKOUT"));
	}
}
