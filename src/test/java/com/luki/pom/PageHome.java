package com.luki.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PageHome {
	public static WebElement iconFilter(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Modal Selector Button"));
	}
	
	public static WebElement iconCart(AndroidDriver driver) {
		return driver.findElement(AppiumBy.accessibilityId("test-Cart"));
	}
	
	public static WebElement textPriceLowToHigh(AndroidDriver driver) {
		return driver.findElement(By.xpath("//*[@text='Price (low to high)']"));
	}
	
	public static WebElement textPriceHighToLow(AndroidDriver driver) {
		return driver.findElement(By.xpath("//*[@text='Price (high to low)']"));
	}
	
	public static List<WebElement> listItemPrices(AndroidDriver driver) {
		return driver.findElements(By.xpath("//*[@content-desc='test-Price']"));
	}

	public static List<WebElement> listItemTitle(AndroidDriver driver) {
		return driver.findElements(By.xpath("//*[@content-desc='test-Item title']"));
	}
	
	public static List<WebElement> listButtonAdd(AndroidDriver driver) {
		return driver.findElements(By.xpath("//*[@content-desc='test-ADD TO CART']"));
	}

}
